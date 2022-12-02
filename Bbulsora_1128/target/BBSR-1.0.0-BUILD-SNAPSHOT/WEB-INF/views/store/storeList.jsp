<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/default_table.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">


//주문코드 클릭시 주문서 상세
function showOrderInfo(orderCd) {
    let url = "${contextPath}/order/read.do?orderCd="+orderCd;
    let name = "주문 상세정보";
    let option = "width = 500, height = 500, top = 200, left = 200, location = no";
    window.open(url, name, option);
}

$(document).ready(function(){
	
	//입고순번 클릭하면 해당 입고 정보 조회
	
	
	//검색 버튼 클릭 시 실행
	$('#btn_srchStore').on('click',function(){
		console.log("start");
		$.ajax({
			type : "get",
			url : "${contextPath}/rest/searchStore.do",
			dataType : "text",
			data : {orderCd:$('#orderCd').val(), toDate:$('#toDate').val(), fromDate:$('#fromDate').val(), stateContent:$('#stateContent').val()},
			success : function(data,status){
			
				let jsonObj = JSON.parse(data);
				console.log(jsonObj);

				let result = "<table><thead><tr><th>입고순번</th><th>수량</th><th>요청일</th><th>입고상태</th><th>주문코드</th></tr></thead>";
				for(let i=0; i<jsonObj.length; i++){
					result += "<tr>"
					+"<td><a href='#' target='_top' onclick='showStoreInfo('"+jsonObj[i].storeSeq+"')'>"
					+jsonObj[i].storeSeq+"</a></td><td>"
					+jsonObj[i].storeQtt+"</td><td>"
					+jsonObj[i].storeDate+"</td><td>"
					+jsonObj[i].stateContent+"</td><td>"
					+"<form action='${contextPath}/store/update.do' method='post'>"
					+"<a href='${contextPath}/store/read.do?orderCd="+jsonObj[i].orderCd+"'>"
					+jsonObj[i].orderCd+"</a></td></tr>";
				}
				
				
				$('#search_result').html(result);
			},
			error : function(data,status){
				alert("error "+status);
			},
		}); // ajax end
	});//btn_srchStore end
	});//document end

</script>


<style>
	thead tr th{position: sticky; top:0;}
</style>
<title>Store List</title>
</head>
<body>
<h1>입고 목록</h1>

	<div id="store_sub_menu" style="text-align: left; height: 50px">
		주문코드<select id="orderCd"><option value="">주문코드</option>
				<c:forEach var="store" items="${orderCdList}">
					<option value="${store.orderCd}">${store.orderCd}</option>
				</c:forEach></select>
				
			<span id="storeDate"> 입고일
				<input type="date" id="fromDate" value="${fromDate}">
					~ <input type="date" id="toDate" value="${toDate}">
			</span>
			
			<span id="stateContentList">진행상태
			
			<select id="stateContent">
				<option value="${store.stateCd }">선택해주세요</option>
				
				  <c:forEach var="state" items="${stateContentList}">
				  	  <option value="${state.stateContent}">${state.stateContent}</option>
				  </c:forEach>
				  
			</select>
			</span>
			
			<input type="submit" value="검색" id="btn_srchStore">
			 
	</div>
	<br />


	<h2>&nbsp;&nbsp;&nbsp;입고목록</h2>
	<div id="all_store_list" style="overflow: auto; text-align: center; height: 200px">
		<table>
			<thead>
			<tr>
				<th>입고순번</th>
				<th>수량</th>
				<th>입고일</th>
				<th>상태</th>
			</tr>
			</thead>
			<tbody>
				<c:forEach var="store" items="${list }">
					<tr>
						<td>${store.storeSeq }</td>
						<td>${store.storeQtt }</td>
						<td>${store.storeDate }</td>
						<td>${store.stateContent }</td>
					</tr>
				</c:forEach>
			</tbody>
			
		</table>
	</div>


	<h2>&nbsp;&nbsp;&nbsp;검색결과</h2>
	<div id="search_result" style="overflow: auto; text-align: center; height: 250px">

	</div>

	<br />


</body>
</html>