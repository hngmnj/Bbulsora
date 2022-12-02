<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="list" value="${orderMap.list}" />
<c:set var="fromDate" value="${orderMap.fromDate}" />
<c:set var="toDate" value="${orderMap.toDate}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${contextPath}/resources/css/default_table.css" type="text/css">
<script type="text/javascript">
	/*
	 function checkInput() {
	 let from = document.getElementsByName("fromDate")[0].value;
	 let to = document.getElementsByName("toDate")[0].value;
	 if(from > to){
	 alert("from > to");
	 return false;
	 }
	 }
	 */
</script>
<title>주문조회</title>
</head>
<body>
	<div id="order_sub_manu" style="text-align: center">
		<form action="${contextPath}/order/list.do" method="get">
			요청일<input type="date" name="fromDate" value="${fromDate}">&nbsp;~&nbsp;<input
				type="date" name="toDate" value="${toDate}">&nbsp; <input
				type="submit" value="검색" onclick="return checkInput()">
		</form>
	</div>
	<div id="search_result">
		<table>
			<tr>
				<th>주문코드</th>
				<th>품목명</th>
				<th>요청일</th>
				<c:if test="${user.compCd eq 'ADMIN'}">
					<th>요청업체명</th>
				</c:if>
				<c:if test="${fn:substring(user.compCd,0,3) eq 'SUP'}">
					<th>첨부파일</th>
				</c:if>
			</tr>
			<c:forEach var="order" items="${list}">
				<tr>
					<td><a href="${contextPath}/order/read.do?orderCd=${order.orderCd}">${order.orderCd}</a></td>
					<td>${order.itemName}<c:if test="${order.cnt > 1}"> 외 ${order.cnt-1} 건</c:if></td>
					<td>${order.submitDate}</td>
					<c:if test="${user.compCd eq 'ADMIN'}">
						<td>${order.compName}</td>
					</c:if>
					<c:if test="${fn:substring(user.compCd,0,3) eq 'SUP'}">
						<td>
						<form action="${contextPath}/order/upload.do" method="post" enctype="multipart/form-data">
						<input type="hidden" value="${order.orderCd }" name="orderCd">
						<input type="file" value="Upload">
						<input type="submit" value="저장">
						</form>
						</td>
					</c:if>
				</tr>
			</c:forEach>
			
		</table>
		
	</div>

</body>
</html>