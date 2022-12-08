<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<style type="text/css">
.cal_top{
    text-align: center;
    font-size: 30px;
}
.cal{
    text-align: center;
}
table.calendar{
    border: 1px solid black;
    display: inline-table;
    text-align: left;
}
table.calendar td{
    vertical-align: top;
    border: 1px solid skyblue;
    width: 100px;
}
</style>
</head>
<body>
	<div>
		공급사<select id="supName">
			<option value="">선택</option>
			
			<c:forEach var="company" items="${supList}">
				<option value="${company.compCd}">${company.compName}</option>
			</c:forEach>
		</select>
	
	<span id="itemName_list">
		품목<select id="itemName"><option value="">선택</option>
		
		</select>
	</span>
		
	<input type="submit" value="일정조회" id="check_cal">
	</div>
	<input type="file" id="infoCsv" name="infoCsv">

    <div class="cal_top">
        <a href="#" id="movePrevMonth"><span id="prevMonth" class="cal_tit">&lt;</span></a>
        <span id="cal_top_year"></span>
        <span id="cal_top_month"></span>
        <a href="#" id="moveNextMonth"><span id="nextMonth" class="cal_tit">&gt;</span></a>
    </div>
    <div id="cal_tab" class="cal">
    </div>
	
<script type="text/javascript">
    
    var today = null;
    var year = null;
    var month = null;
    var firstDay = null;
    var lastDay = null;
    var $tdDay = null;
    var $tdSche = null;
   
    
    //calendar 그리기
    function drawCalendar(){
        var setTableHTML = "";
        setTableHTML+='<table class="calendar"> ';
        setTableHTML+='<tr><th>SUN</th><th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th></tr>';
        for(var i=0;i<6;i++){
            setTableHTML+='<tr height="70">';
            for(var j=0;j<7;j++){
                setTableHTML+='<td style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap">';
                setTableHTML+='    <div class="cal-day"></div>';
                setTableHTML+='    <div class="cal-schedule"></div>';
                setTableHTML+='</td>';
            }
            setTableHTML+='</tr>';
        }
        setTableHTML+='</table>';
        $("#cal_tab").html(setTableHTML);
    }
 
    //날짜 초기화
    function initDate(){
        $tdDay = $("td div.cal-day")
        $tdSche = $("td div.cal-schedule")
        dayCount = 0;
        today = new Date();
        year = today.getFullYear();
        month = today.getMonth()+1;
        firstDay = new Date(year,month-1,1);
        lastDay = new Date(year,month,0);
    }
    
    //calendar 날짜표시
    function drawDays(){
        $("#cal_top_year").text(year);
        $("#cal_top_month").text(month);
        for(var i=firstDay.getDay();i<firstDay.getDay()+lastDay.getDate();i++){
            $tdDay.eq(i).text(++dayCount);
        }
        for(var i=0;i<42;i+=7){
            $tdDay.eq(i).css("color","red");
        }
        for(var i=6;i<42;i+=7){
            $tdDay.eq(i).css("color","blue");
        }
    }
 
    //calendar 월 이동
    function movePrevMonth(){
        month--;
        if(month<=0){
            month=12;
            year--;
        }
        if(month<10){
            month=String("0"+month);
        }
        getNewInfo();
        }
    
    function moveNextMonth(){
        month++;
        if(month>12){
            month=1;
            year++;
        }
        if(month<10){
            month=String("0"+month);
        }
        getNewInfo();
    }

    //정보갱신
     function getNewInfo(){
        for(var i=0;i<42;i++){
            $tdDay.eq(i).text("");
            $tdSche.eq(i).text("");
        }
        dayCount=0;
        firstDay = new Date(year,month-1,1);
        lastDay = new Date(year,month,0);
        drawDays();
        drawSche();
    }
     
    
    //스케줄 그리기
    function drawSche(jsonData){
        var dateMatch = null;
        for(var i=firstDay.getDate();i<firstDay.getDate()+lastDay.getDate();i++){
            var txt = "";
            txt =jsonData[year];
            if(txt){
                txt = jsonData[year][month];
                if(txt){
                    txt = jsonData[year][month][i];
                    dateMatch = firstDay.getDay() + i -1; 
                    $tdSche.eq(dateMatch).text(txt);
                    
                }
            }
        }
    }
    
    $(document).ready(function() {
        drawCalendar();
        initDate();
        drawDays();
        $("#movePrevMonth").on("click", function(){movePrevMonth();});
        $("#moveNextMonth").on("click", function(){moveNextMonth();});
        
        
        $('#supName').on('change', function() {
        	$.ajax({
        		type : "get",
        		url : "${contextPath}/rest/getSupsItem.do",
        		dataType : "text",
        		data : {compCd:$('#supName').val()},
        		
        		success : function(data,status){
        			let jsonObj =JSON.parse(data);
        			let result = "품목<select id='itemCd'> <option value=''>선택하세요</option>";
        			for(let i=0; i<jsonObj.length; i++) {
        				result += "<option value='"+jsonObj[i].itemCd+"'>"+jsonObj[i].itemName+"</option>";
        				
        			}
        			result += "</select>&nbsp;&nbsp;";
        			$('#itemName_list').html(result);
        		},
        		
        		error : function(data, status) {
        			alert("error?"+status);
        		},
        		
        	}); //ajax end
        });//supName end
        
        
         $('#check_cal').on('click', function() {
            $.ajax({
            	type : "get",
            	url : "${contextPath}/rest/getMonthSche.do",
            	dataType : "text",
            	data : {itemCd:$('#itemCd').val()},
            	success : function(data, status) {
            		let jsonData = JSON.parse(data);
            		console.log(jsonData);
            		drawSche(jsonData);
        		},
        		error : function(data, status) {
        			alert("error?"+status);
        			console.log(itemCd);
        		},
        		
            });//ajax end
        });//check_cal end
 
        
    });//document end
    
</script>


</head>
<body>

</body>
</html>