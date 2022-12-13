<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="list" value="${deliveryMap.list}" />
<c:set var="fromDate" value="${deliveryMap.fromDate}" />
<c:set var="toDate" value="${deliveryMap.toDate}" />
<c:set var="compCd" value="${user.compCd}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
   href="${contextPath}/resources/css/default_table.css" type="text/css">
<script type="text/javascript">

//출하상태 일괄변경
function allDlvryStateUd(code) {
   if(confirm("상태를 일괄변경 하시겠습니까?")) {
      $.ajax({
         type : "get",
         url : "${contextPath}/delivery/updateAll.do",
         dataType : "text",
         data : {dlvryCd: code, prevStateCd: $('#prevStateCd'+code).val(), stateCd: $('#stateCd'+code).val()},
         success : function(data, status) {
            alert("상태 변경 성공");
            location.replace("${contextPath}/delivery/list.do");
         },
         error : function(data, status) {
            alert("Fail...");
         }
      })
   }
}

//출하상태 개별변경
function sepDlvryStateUd(seq) {
   $.ajax({
      type : "get",
      url : "${contextPath}/delivery/updateSep.do",
      dataType : "text",
      data : {dlvrySeq:$('#dlvrySeq'+seq).val(), prevStateCd:$('#prevStateCd'+seq).val(), stateCd:$('#stateCd'+seq).val(), dlvryCd:$('#dlvryCd'+seq).val(), dlvryQtt:$('#dlvryQtt'+seq).val(),
    	  		itemCd:$('#itemCd'+seq).val(), compCd:$('#compCd'+seq).val()},
      success : function(data, status) {
         alert("상태 변경 성공");
         location.replace("${contextPath}/delivery/list.do");
      },
      error : function(data, status) {
         alert("Fail...");
      }
   })
}
    
//코드별 상세조회
function showReqInfoByCode(code, comp) {
   $.ajax({
      type : "get",
      url : "${contextPath}/rest/searchReqInfoByCode.do",
      dataType : "text",
      data : {dlvryCd:code, compCd:comp},
      success : function(data,status) {
         let i = 0;
         let dlvryObj = JSON.parse(data);
         let stateObj = null;
         let result = "<table><tr><th>순번</th><th>품목명</th><th>수량</th><th>총 재고량</th><th>개별상태</th></tr>";
         for(let i=0;i<dlvryObj.length;i++) {
        	if(dlvryObj.length != 0) {
        		stateObj = dlvryObj[i].stateList;
            	result += "<input type='hidden' id='dlvrySeq"+dlvryObj[i].dlvrySeq+"' value="+dlvryObj[i].dlvrySeq+">"
            	+"<input type='hidden' id='dlvryCd"+dlvryObj[i].dlvrySeq+"' value="+dlvryObj[i].dlvryCd+">"
            	+"<input type='hidden' id='itemCd"+dlvryObj[i].dlvrySeq+"' value="+dlvryObj[i].itemCd+">"
            	+"<input type='hidden' id='compCd"+dlvryObj[i].dlvrySeq+"' value="+dlvryObj[i].compCd+">"
            	+"<input type='hidden' id='dlvryQtt"+dlvryObj[i].dlvrySeq+"' value="+dlvryObj[i].dlvryQtt+">"
            	+"<input type='hidden' id='prevStateCd"+dlvryObj[i].dlvrySeq+"' value="+dlvryObj[i].stateCd+">"
        	}
            result += "<tr><td>"+(i+1)+"</td><td>"+dlvryObj[i].itemName+"</td><td>"+dlvryObj[i].dlvryQtt
            +"</td><td>"+dlvryObj[i].totalQtt+"</td>"
            if("${compCd}" == 'ADMIN') {
               result += "<td><select id='stateCd"+dlvryObj[i].dlvrySeq+"'>"
               +"<option value='"+dlvryObj[i].stateCd+"'>"+dlvryObj[i].stateContent+"</option>"
               for(let j=0;j<stateObj.length;j++) {
                  result += "<option value='"+stateObj[j].stateCd+"'>"+stateObj[j].stateContent+"</option>"
               }
               result += "</select> <input type='button' value='변경' onclick='sepDlvryStateUd(\""+dlvryObj[i].dlvrySeq+"\")'></td></tr>"
            } else {
               result += "<td>"+dlvryObj[i].stateContent+"</td></tr>"
            }
         }
         result += "</table>";
         $('#search_req_by_code').html(result);
      },
      error : function(data,status){
         alert("error "+status);
      },
   });
}    
    
$(document).ready(function(){
   $('#btn_srchDelivery').on('click',function(code){
	  var code;
      $.ajax({
         type : "get",
         url : "${contextPath}/rest/searchDelivery.do",
         dataType : "text",
         data : {fromDate:$('#fromDate').val(), toDate:$('#toDate').val(), client:$('#client').val()},
         success : function(data,status){
            let i = 0;
            let dlvryObj = JSON.parse(data);
            let stateObj = null;
            let result = "";
            if(dlvryObj.length != 0) {
            	result = "<input type='hidden' id='compCd"+dlvryObj[i].dlvryCd+"' value="+dlvryObj[i].compCd+">"
            	+"<input type='hidden' id='prevStateCd"+dlvryObj[i].dlvryCd+"' value="+dlvryObj[i].stateCd+">"
            }
            if("${compCd}" == 'ADMIN') {
               result = "<table><tr><th>출고코드</th><th>납기요청일</th><th>요청업체명</th><th>상태일괄변경</th></tr>";
               for(let i=0; i<dlvryObj.length; i++){
            	  stateObj = dlvryObj[i].stateList;
                  result += "<tr><td><a href='#' target='_top' onclick='showReqInfoByCode(\""+dlvryObj[i].dlvryCd+"\",\""+dlvryObj[i].compCd+"\")'>"+dlvryObj[i].dlvryCd
                  +"</a></td><td>"+dlvryObj[i].reqDate+"</td><td>"+dlvryObj[i].compName+"</td>"
                  +"<td><select id='stateCd"+dlvryObj[i].dlvryCd+"'><option value="+dlvryObj[i].stateCd+">"+dlvryObj[i].stateContent+"</option>";
                  for(let j=0; j<stateObj.length; j++) {
                     result += "<option value="+stateObj[j].stateCd+">"+stateObj[j].stateContent+"</option>"
                  }
                  result += "</select> <input type='button' value='변경' onclick='allDlvryStateUd(\""+dlvryObj[i].dlvryCd+"\")'></td></tr>"
               };
            } else {
               result = "<table><tr><th>출고코드</th><th>납기요청일</th><th>품목</th><th>현재상태</th></tr>";
               for(let i=0; i<dlvryObj.length; i++){
                  result += "<tr><td><a href='#' target='_top' onclick='showReqInfoByCode(\""+dlvryObj[i].dlvryCd+"\")'>"+dlvryObj[i].dlvryCd
                  +"</a></td><td>"+dlvryObj[i].reqDate+"</td><td>"+dlvryObj[i].itemName
                  if(dlvryObj[i].cnt != 1) {
                  	result += " 외 "+(dlvryObj[i].cnt-1)+" 건</td>"
                  }
                  result += "<td>"+dlvryObj[i].stateContent+"</td></tr>"
               }
            }
            result += "</table>";
            $('#search_result').html(result);         
         },
         error : function(data,status){
            alert("error "+status);
         },
      });
   });
});
</script>
<title>출고조회</title>
</head>
<body>
<h1 align = "center">[출고 현황]</h1>
</br>
</br>
   <div id="delivery_sub_manu" style="text-align: center">
         요청일<input type="date" id="fromDate">&nbsp;~&nbsp;
         <input type="date" id="toDate">&nbsp;
         고객사명<input type="text" id="client"> 
         <input type="button" id="btn_srchDelivery" value="검색">
   </div>
   <div id="search_result" style="overflow:auto; height: 250px">
      <table>
         <tr>
            <th>출고코드</th>
            <th>납기요청일</th>
            <c:if test="${user.compCd eq 'ADMIN'}"><th>요청업체명</th><th>상태일괄변경</th></c:if>
            <c:if test="${user.compCd ne 'ADMIN'}"><th>품목</th><th>현재상태</th></c:if>
         </tr>
         <c:forEach var="dlvryList" items="${dlvryList}">
         <input type="hidden" id="prevStateCd${dlvryList.dlvryCd}" value="${dlvryList.stateCd}">
            <tr>
               <td><a href='#' target='_top' onclick='showReqInfoByCode("${dlvryList.dlvryCd}", "${dlvryList.compCd}")'>${dlvryList.dlvryCd}</a></td>
               <td>${dlvryList.reqDate}</td>
               <c:if test="${user.compCd eq 'ADMIN'}">
                  <td>${dlvryList.compName}</td>
               </c:if>
               <c:if test="${user.compCd ne 'ADMIN'}">
                  <td>${dlvryList.itemName}<c:if test="${dlvryList.cnt > 1}"> 외 ${dlvryList.cnt-1} 건</c:if></td>
               </c:if>
               <c:if test="${user.compCd eq 'ADMIN'}">
               <td><select id="stateCd${dlvryList.dlvryCd}">
                     <option value="${dlvryList.stateCd}">${dlvryList.stateContent}</option>
                        <c:forEach var="state" items="${dlvryList.stateList}">
                               <option value="${state.stateCd}">${state.stateContent}</option>
                        </c:forEach>
                        </select>
                        <input type="button" value="변경" onclick="allDlvryStateUd('${dlvryList.dlvryCd}')">
                     </td>
                     </c:if>
                     <c:if test="${user.compCd ne 'ADMIN'}">
                     <td>${dlvryList.stateContent}</td>
                     </c:if>
            </tr>
         </c:forEach>
      </table>
   </div>
<br/>
<div id="search_req_by_code" style="overflow:auto; height: 250px">

</div>

</body>
</html>