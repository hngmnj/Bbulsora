<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${contextPath}/resources/css/default_table.css" type="text/css">
<script type="text/javascript">
	function showItemInfo(itemCd) {
		let topMargin = event.screenY - event.clientY + 10;
		let leftMargin = event.screenX - event.clientX;
		let url = "${contextPath}/item/readTop.do?itemCd=" + itemCd;
		let name = "품목 상세정보";
		let option = "width = 500, height = 500, top = " + topMargin
				+ ", left = " + leftMargin + ", location = no";
		window.open(url, name, option);
	}
	function delConfirm() {
		return confirm("요청을 취소하시겠습니까?");
	}
	function upConfirm() {
		return confirm("주문상태를 수정하시겠습니까?");
	}
	function outStoreCsv() {
		return confirm("입고 명세서를 내보내시겠습니까?");
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

			<th>주문수량</th>

			<th>단위</th>
			<c:if test="${fn:substring(user.compCd,0,3) eq 'SUP'}">
				<th>고객사</th>
			</c:if>
			<c:if test="${fn:substring(user.compCd,0,3) eq 'CLI'}">
				<th>공급사</th>
			</c:if>
			<th>요청일</th>
			<th>발주일</th>
			<th>주문상태</th>
			<c:if test="${user.compCd ne 'ADMIN'}">
				<th>입고수량과 상태</th>
				
			</c:if>
		</tr>
		<c:forEach var="order" items="${list}">
			<!-- 고객사 주문상세 화면 -->
			<c:if test="${fn:substring(user.compCd,0,3) eq 'CLI'}">
				<tr>
					<td><a href="#" target="_top"
						onclick="showItemInfo('${order.itemCd}')">${order.itemName}</a></td>

					<td>${order.orderQtt}</td>
					<td>${order.unit}</td>
					<td>${order.compName}</td>
					<td>${order.submitDate}</td>
					<td>${order.orderDate}</td>
					<td>${order.stateContent}</td>


					<td><c:if
							test="${order.stateCd eq 'O001' and user.compCd eq order.compCd}">
							<form action="${contextPath}/order/delete.do">
								<input type="hidden" name="orderCd" value="${order.orderCd}">
								<input type="hidden" name="orderSeq" value="${order.orderSeq}">
								<input type="submit" value="주문취소" onclick="return delConfirm()">
							</form>
						</c:if></td>
			</c:if>


			<!-- 공급사 주문상세 화면 -->
			<c:if test="${fn:substring(user.compCd,0,3) eq 'SUP'}">
				<tr>
					<td><a href="#" target="_top"
						onclick="showItemInfo('${order.itemCd}')">${order.itemName}</a></td>
					<td>
						<%-- <form action="${contextPath }/order/" method="post"> --%>
							<c:if test="${order.stateCd eq 'O004' }">
								<input type="" value="0" min="0" id="storeQtt">&nbsp;/
							</c:if>
							${order.orderQtt}
							<!-- <input type="submit">
						</form> -->
					</td>

					<td>${order.unit}</td>
					<td>${order.compNameCli}</td>
					<td>${order.submitDate}</td>
					<td>${order.orderDate}</td>
					<td>${order.stateContent}</td>

					<td>
						<form action="${contextPath}/order/update.do" method="post">
							<input type="hidden" name="orderCd" value="${order.orderCd}">
							<input type="hidden" name="orderSeq" value="${order.orderSeq}">
							<input type="hidden" name="prevStateCd" value="${order.stateCd}">
							<%-- <input type="number" value="0" min="0" name="storeQtt">&nbsp;/${order.orderQtt}&nbsp;&nbsp;&nbsp;
							 --%>
							<select name="stateCd">
								<option value="${order.stateCd}">선택안함</option>

								<c:forEach var="state" items="${order.stateList}">
									<option value="${state.stateCd}">${state.stateContent}</option>
								</c:forEach>
							</select> <input type="submit" value="변경저장" onclick="return upConfirm()">

						</form>
					</td>

				</tr>
			</c:if>
		</c:forEach>

	</table>
	<div style="text-align: center;">
		<a href="${contextPath}/order/list.do"> <input type="button"
			value="전체 목록"></a>

		<c:if test="${fn:substring(user.compCd,0,3) eq 'SUP'}">
			<form action="${contextPath}/order/upload.do" method="post">
				<input type="hidden" name="orderCd" value="${order.orderCd}">
				<input type="hidden" name="orderSeq" value="${order.orderSeq}">
				<input type="submit" value="내보내기" onclick="return outStoreCsv()">
			</form>
		</c:if>
	</div>


</body>
</html>