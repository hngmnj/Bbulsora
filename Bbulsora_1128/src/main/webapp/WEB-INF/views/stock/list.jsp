<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="list" value="${stockMap.list}" />
<c:set var="itemList" value="${stockMap.itemList}" />
<c:set var="clientList" value="${stockMap.clientList}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${contextPath}/resources/css/default_table.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
// 총 재고수량 초과 불가
function checkValue(qtt) {
	let inputText = event.target.value;
	let modText = inputText.replaceAll(/[^0-9]/g,"");
	if(inputText != modText){
		alert("숫자만 입력 가능합니다.");
		event.target.value = modText;
	}
	if(inputText > qtt) {
		alert("총 수량을 초과할 수 없습니다.");
		event.target.value = "";
	}
}

//아이템 상세
function showItemInfo(itemCd) {
   let topMargin = event.screenY - event.clientY + 10;
   let leftMargin = event.screenX - event.clientX;
    let url = "${contextPath}/item/readTop.do?itemCd="+itemCd;
    let name = "품목 상세정보";
    let option = "width = 350, height = 450, location = no";
    window.open(url, name, option);
}

//재고 로트별 조회
function showStockInfoByLot(code) {
   $.ajax({
      type : "get",
      url : "${contextPath}/rest/searchStockByLot.do",
      dataType : "text",
      data : {itemCd:code, compCd:"${user.compCd}", client:$('#client').val()},
      success : function(data,status) {
         let jsonObj = JSON.parse(data);
         let result = "<table><tr><th>Lot No.</th><th>품목명</th><th>수량</th><th>로케이션</th><th>상태내용</th></tr>"
         if("${user.compCd}"=="ADMIN") {
        	 result = "<table><tr><th>Lot No.</th><th>품목명</th><th>고객사명</th><th>수량</th><th>로케이션</th><th>상태내용</th></tr>"
         }
         for(let i=0;i<jsonObj.length;i++) {   
            result += "<tr><td>"+jsonObj[i].lot+"</td><td>"+jsonObj[i].itemName+"</td>"
            if("${user.compCd}"=="ADMIN") {
            	result += "<td>"+jsonObj[i].compName+"</td>"
            }
            result += "<td>"+jsonObj[i].stockQtt+"</td><td>"+jsonObj[i].locArea+"</td><td>"+jsonObj[i].stateContent+"</td></tr>"
         }
         result += "</table>";
         $('#search_stock_by_lot').html(result);
      },
      error : function(data,status){
         alert("error "+status);
      },
   });
}

//출고 요청 Part
//0. 출고 기본 폼
//주문요청 대기 테이블 폼
const tableHeader = "<table><tr><th>품목명</th><th>수량</th><th>납기요청일</th><th>관리</th></tr>";
let tableMap = new Map();
const tableFooter = "</table><br/><input type='button' value='출하요청' onclick='checkDelivery()'>";

//1. 리스트에 항목 추가
function addItem(code, qtt) {
   $.ajax({
      type : "get",
      url : "${contextPath}/rest/selectForDelivery.do",
      dataType : "text",
      data : {itemCd:code},
      success : function(data,status){
         let jsonObj = JSON.parse(data);
         let result = "<tr><td><a href='#' target='_top' onclick='showItemInfo(\""+jsonObj.itemCd+"\")'>"+jsonObj.itemName+"</a></td>"
         +"<td><input type='text' oninput='checkValue("+qtt+")' id='"+jsonObj.itemCd+"qtt'></td><td><input type='date' id='"+jsonObj.itemCd+"date'></td>"
         +"<td><input type='button' value='삭제' onclick='deleteRequest(\""+jsonObj.itemCd+"\")'></td></tr>";
         tableMap.set(jsonObj.itemCd,result);
         changeDeliveryList();
      },
      error : function(data,status){
         alert("error "+status);
      },
   }); // ajax end
}

//2. 출고요청 리스트 갱신
function changeDeliveryList() {
   let tableBody = "";
   let iterator = tableMap.values()
   for(let i=0; i<tableMap.size; i++){
      tableBody += iterator.next().value;
   }
   if(tableMap.size == 0){
      $('#delivery_request').html(tableHeader+tableBody+"</table>");
   } else {
      $('#delivery_request').html(tableHeader+tableBody+tableFooter);
   }
}

//3. 불필요 항목 삭제
function deleteRequest(itemCd) {
   tableMap.delete(itemCd);
   changeDeliveryList();
}

//4. 출고요청하기
function checkDelivery() {

   if(confirm("요청확인")){
      let deliveryList = [];
      let delivery;
      let iterator = tableMap.keys();
      const date = new Date();
      let year = date.getFullYear();
      let month = "-"+(date.getMonth()+1);
      let day = "-"+date.getDate();
      if(date.getMonth()+1<10) {
    	  month = "-0"+(date.getMonth()+1);
      } if(date.getDate()<10) {
    	  day = "-0"+date.getDate();
      }
      for(let i=0; i<tableMap.size; i++){
         let key = iterator.next().value;
         delivery = new Object();
         delivery.itemCd = key;
         delivery.dlvryQtt = $('#'+key+'qtt').val();
         delivery.reqDate = $('#'+key+'date').val();
         let today = year+month+day;
         console.log(delivery.reqDate+" vs "+today)
         if(delivery.dlvryQtt==0 || delivery.dlvryQtt=="") {
        	 alert("수량은 0이 될 수 없습니다.");
        	 return false;
         } if(delivery.reqDate=="") {
        	 alert("요청일은 필수로 기입해주시기 바랍니다.");
        	 return false;
         } if(delivery.reqDate<today) {
        	 alert("오늘 이전의 날짜를 선택할 수 없습니다.");
        	 return false;
         } else {
         	deliveryList.push(delivery);
         }
      }

      $.ajax({
         type : "post",
         url : "${contextPath}/delivery/create.do",
         dataType : "text",
         contentType: "application/json",
         data : JSON.stringify(deliveryList),
         success : function(data,status){
            alert("주문요청완료");
            location.replace("${contextPath}/stock/list.do");
         },
         error : function(data,status){
            alert("error "+status);
         },
      }); // ajax end
   }//if end
   else {
      return false;
   }
}

$(document).ready(function(){
	$('#btn_srchStock').on('click',function(){
		$.ajax({
			type : "get",
			url : "${contextPath}/rest/searchStock.do",
			dataType : "text",
			data : {item:$('#item').val(), client:$('#client').val()},
			success : function(data,status){
				let jsonObj = JSON.parse(data);
				let result = "<table><tr><th>품목코드</th><th>품목명</th><th>공급사명</th><th>총 수량</th></tr>";
				for(let i=0; i<jsonObj.length; i++){
					result += "<tr><td><a href='#' target='_top' onclick='showItemInfo(\""+jsonObj[i].itemCd+"\")'>"+jsonObj[i].itemCd
					+"</a></td><td><a href='#' target='_top' onclick='showStockInfoByLot(\""+jsonObj[i].itemCd+"\")'>"+jsonObj[i].itemName+"</a></td><td>"+jsonObj[i].compName+"</td>"
					if("${user.compCd}" != "ADMIN") {
						result += "<td><a href='#' onclick='addItem(\""+jsonObj[i].itemCd+"\", "+jsonObj[i].stockSum+")'>"+jsonObj[i].stockSum+"</td></tr>"
					} else {
						result += "<td>"+jsonObj[i].stockSum+"</td>"
					}
				}
            result += "</table>";
            $('#search_stock').html(result);
         },
         error : function(data,status){
            alert("error "+status);
         },
      });
   });
});
</script>
<title>재고조회</title>
</head>
<body>

<div id="stock_sub_menu" style="text-align: center">
품목명<select id="item"><option value="">선택안함</option><c:forEach var="item" items="${itemList}"><option value="${item.itemName}">${item.itemName}</option></c:forEach></select>
<c:if test="${fn:substring(user.compCd,0,3) ne 'CLI'}">고객사명<select id="client"><option value="">선택안함</option><c:forEach var="client" items="${clientList}"><option value="${client.compName}">${client.compName}</option></c:forEach></select></c:if>
<input type="button" value="검색" id="btn_srchStock">
</div>

<div id="search_stock" style="overflow:auto; height: 200px">
<table>
<tr><th>품목코드</th><th>품목명</th><th>공급사명</th><th>총 수량</th></tr>
<c:forEach var="stock" items="${list}">
<tr>
   <td><a href='#' target='_top' onclick='showItemInfo("${stock.itemCd}")'>${stock.itemCd}</a></td>
   <td><a href="#" onclick='showStockInfoByLot("${stock.itemCd}")'>${stock.itemName}</a></td>
   <td>${stock.compName}</td>
   <c:if test="${fn:substring(user.compCd,0,3) eq 'CLI'}"><td><a href="#" onclick='addItem("${stock.itemCd}", ${stock.stockSum})'>${stock.stockSum}</a></td></c:if>
   <c:if test="${fn:substring(user.compCd,0,3) ne 'CLI'}"><td>${stock.stockSum}</td></c:if>
</tr>
</c:forEach>
</table>
</div>
<br/>
<div id="search_stock_by_lot" style="overflow:auto; height: 200px">

</div>
<br/>
<c:if test="${fn:substring(user.compCd,0,3) eq 'CLI'}">
<div id="delivery_request" style="overflow:auto; text-align:center; height: 200px">

</div>
</c:if>
</body>
</html>