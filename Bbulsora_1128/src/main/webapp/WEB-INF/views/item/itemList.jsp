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
<h1>취급 품목 정보</h1>
<a href="viewCreate.do"><button>신규 품목 추가</button></a>
<a href="viewCsvCreate.do"><button>신규 품목 csv 품목 등록</button></a>
<table>
	<tr><th>품목코드</th><th>품목명</th><th>대분류</th><th>중분류</th><th>소분류</th><th>단위</th><th>기업코드</th>
<c:forEach var="item" items="${list}">
	<tr>
		<td><a href="./read.do?itemCd=${item.itemCd}">${item.itemCd}</a></td>
		<td>${item.itemName}</td>
		<td>${item.major}</td>
		<td>${item.middle}</td>
		<td>${item.minor}</td>
		<td>${item.unit}</td>
		<td>${item.compCd}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>