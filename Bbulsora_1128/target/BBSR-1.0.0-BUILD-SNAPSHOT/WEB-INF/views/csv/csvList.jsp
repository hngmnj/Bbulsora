<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Company List</title>
</head>
<body>
<h1>이용 기업 정보</h1>
<a href="viewCreate.do">코드 CSV 추가</a>
<table>
	<tr><th>상태코드</th><th>정의</th></tr>
	<c:forEach var="state" items="${list}">
	<tr>
		<td>${state.stateCd}</td>
		<td>${state.stateContent}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>