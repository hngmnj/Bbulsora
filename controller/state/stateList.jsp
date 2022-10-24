<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item List</title>
</head>
<body>
<h1>상태 정의 목록</h1>
<a href="viewCreate.do">상태코드 추가</a>
<table>
	<tr><th>상태코드</th><th>상태내용</th></tr>
<c:forEach var="state" items="${list}">
	<tr>
		<td><a href="./read.do?stateCd=${state.stateCd}">${state.stateCd}</a></td>
		<td>${state.stateContent}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>