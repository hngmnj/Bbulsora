<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/default_table.css" type="text/css">

<script type="text/javascript">
	function upConfirm() {
		return confirm("입고상태를 수정하시겠습니까?");
	}
</script>


<title>입고상세</title>
</head>
<body>
	<h3 style="text-align: center;">주문코드</h3>
	<h3 style="text-align: center;">${list == null ? '' : list[0].orderCd}</h3>
	<table>
		<tr>
			<th>입고순번</th>
			<th>입고수량</th>
<!-- 			<th>단위</th>
			<th>고객사</th>
			<th>요청일</th> -->
			<th>입고일</th>
			<th>입고상태</th>
			<th>관리</th>
		</tr>	
		
		<c:forEach var="store" items="${list}">
			<tr>
				<td>${store.storeSeq}</td>
				<td>${store.storeQtt}</td>
				<td>${store.storeDate}</td>
				<td>${store.stateContent}</td>
				<td>
					<form action="${contextPath}/store/update.do" method="post">
						<input type="hidden" name="orderCd" value="${store.orderCd}">
						<input type="hidden" name="storeSeq" value="${store.storeSeq}">
						<input type="hidden" name="prevStateCd" value="${store.stateCd}">
					
							<select name="stateCd">
								<option value="${store.stateCd}">선택해주세요</option>
								
									<c:forEach var="state" items="${stateContentList}">
										<option value="${state.stateCd}"> ${state.stateContent}</option>
									</c:forEach>
									
							</select>
						<input type="submit" value="상태변경" onclick="return upConfirm()">
					</form>
					
				</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>