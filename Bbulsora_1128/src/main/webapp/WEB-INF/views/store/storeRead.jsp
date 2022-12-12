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
var open;

function upConfirm(seq) {
	return confirm("입고상태를 수정하시겠습니까?");
}

//로케이션 설정창 띄우기
function showLocSetWindow(storeSeq) {
    let url = "${contextPath}/store/location.do?storeSeq="+storeSeq;
    let name = "로케이션 설정";
    let option = "width = 1200, height = 600, top = 0, left = 0, location = no";
    open = window.open(url, name, option);
}
</script>


<title>입고 상세</title>
</head>
<body>
	<h3 style="text-align: center; ">주문코드</h3>
	<h2 style="text-align: center;">${list == null ? '' : list[0].orderCd}</h2>
	<table>
		<tr>
			<th>입고순번</th>
			<th>입고수량</th>
<!-- 		<th>단위</th>
			<th>고객사</th>
			<th>요청일</th> -->
			<th>입고일</th>
			<th>입고상태</th>
			<th>배치</th>
			<th>관리</th>
		</tr>	
		
		<c:forEach var="store" items="${list}">
			<tr>
				<td>${store.storeSeq}</td>
				
				<td>${store.storeQtt}</td>
				<td>${store.storeDate}</td>
				<td>${store.stateContent}</td>
				<c:if test="${not empty store.locArea}">
					<td>${store.locArea}</td>
				</c:if>
				<c:if test="${empty store.locArea}">
					<td><a href='#' target="_top" onclick="showLocSetWindow(${store.storeSeq})">설정하기</a></td>
				</c:if>
				<td>
					<form action="${contextPath}/store/update.do" method="post">
						  <input type="hidden" name="itemCd" value="${store.itemCd}">
		                  <input type="hidden" name="locArea" value="${store.locArea}">
		                  <input type="hidden" name="storeQtt" value="${store.storeQtt}">
		                  <input type="hidden" id="orderCd" name="orderCd" value="${store.orderCd}">
		                  <input type="hidden" name="storeSeq" value="${store.storeSeq}">
		                  <input type="hidden" name="prevStateCd" value="${store.stateCd}">
					
							<select name="stateCd">
								<option value="${store.stateCd}">선택해주세요</option>
								
									<c:forEach var="state" items="${store.stateList}">
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