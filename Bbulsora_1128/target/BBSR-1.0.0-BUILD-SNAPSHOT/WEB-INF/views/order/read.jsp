<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${contextPath}/resources/css/default_table.css" type="text/css">
<script type="text/javascript">
function showItemInfo(itemCd) {
	let topMargin = event.screenY - event.clientY + 10;
	let leftMargin = event.screenX - event.clientX;
    let url = "${contextPath}/item/readTop.do?itemCd="+itemCd;
    let name = "품목 상세정보";
    let option = "width = 500, height = 500, top = "+topMargin+", left = "+leftMargin+", location = no";
    window.open(url, name, option);
}
function delConfirm(){
	return confirm("요청을 취소하시겠습니까?");
}
function upConfirm(){
	return confirm("주문상태를 수정하시겠습니까?");
}
</script>
<title>주문상세</title>
</head>
<body>
<h3 style="text-align: center;">주문코드</h3>
<h3 style="text-align: center;">${list == null ? '' : list[0].orderCd}</h3>
<table>
<tr>
	<th>품목명</th>
	<th>수량</th>
	<th>단위</th>
	<c:if test="${fn:substring(user.compCd,0,3) ne 'CLI'}"><th>고객사</th></c:if>
	<c:if test="${fn:substring(user.compCd,0,3) eq 'CLI'}"><th>공급사</th></c:if>
	<th>요청일</th>
	<th>발주일</th>
	<th>주문상태</th>
	<c:if test="${user.compCd ne 'ADMIN'}"><th>관리</th></c:if>
</tr>
<c:forEach var="order" items="${list}">
<tr>
	<td><a href="#" target="_top" onclick="showItemInfo('${order.itemCd}')">${order.itemName}</a></td>
	<td>${order.orderQtt}</td>
	<td>${order.unit}</td>
	<c:choose>
	<c:when test="${fn:substring(user.compCd,0,3) ne 'CLI'}">
	<td>${order.compNameCli}</td>
	</c:when>
	<c:otherwise>
	<td>${order.compName}</td>
	</c:otherwise>
	</c:choose>
	<td>${order.submitDate}</td>
	<td>${order.orderDate}</td>
	<td>${order.stateContent}</td>

	<c:if test="${fn:substring(user.compCd,0,3) eq 'CLI'}">
	<td>
		<c:if test="${order.stateCd eq 'O001' and user.compCd eq order.compCd}">
		<form action="${contextPath}/order/delete.do">
		<input type="hidden" name="orderCd" value="${order.orderCd}">
		<input type="hidden" name="orderSeq" value="${order.orderSeq}">
		<input type="submit" value="주문취소" onclick="return delConfirm()">
		</form>
		</c:if>
	</td>
	</c:if>
	
	<c:if test="${fn:substring(user.compCd,0,3) eq 'SUP'}">
	<td>
		<form action="${contextPath}/order/update.do" method="post">
		<input type="hidden" name="orderCd" value="${order.orderCd}">
		<input type="hidden" name="orderSeq" value="${order.orderSeq}">
		<input type="hidden" name="prevStateCd" value="${order.stateCd}">
			<select name="stateCd">
			<option value="${order.stateCd}">선택안함</option>
			<c:forEach var="state" items="${order.stateList}">
			<option value="${state.stateCd}">${state.stateContent}</option>
			</c:forEach>
			</select>
		<input type="submit" value="상태변경" onclick="return upConfirm()">	
		</form>
	</td>
	</c:if>
	
</tr>
</c:forEach>
</table>
<div style="text-align: center;">
<a href="${contextPath}/order/list.do"><input type="button" value="전체 목록"></a>
</div>
</body>
</html>