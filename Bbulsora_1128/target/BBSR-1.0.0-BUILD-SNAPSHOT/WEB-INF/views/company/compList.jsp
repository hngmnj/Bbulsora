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
<a href="viewCreate.do">신규 기업 추가</a>
<table>
	<tr><th>기업코드</th><th>기업명</th><th>영문명</th><th>대표명</th><th>주소</th><th>연락처</th><th>기업구분</th></tr>
<c:forEach var="company" items="${list}">
	<tr>
		<td><a href="./read.do?compCd=${company.compCd}">${company.compCd}</a></td>
		<td>${company.compName}</td>
		<td>${company.engName}</td>
		<td>${company.repName}</td>
		<td>${company.address}</td>
		<td>${company.compCall}</td>
		<td>${company.sort}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>