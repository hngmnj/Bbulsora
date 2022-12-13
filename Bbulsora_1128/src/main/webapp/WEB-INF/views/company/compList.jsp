<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Company List</title>
<link rel="stylesheet" href="${contextPath}/resources/css/info_table.css" type="text/css">
</head>
<body>
<div style="text-align:center"><h1>[이용 기업 정보]</h1></div>
<div style="overflow:auto; height: 400px">
<table>
	<tr>
		<th class="code">기업코드</th>
		<th>기업명</th>
		<th class="english">영문명</th>
		<th class="narrow">대표명</th>
		<th class="address">주소</th>
		<th>연락처</th>
		<th class="narrow">기업구분</th></tr>
<c:forEach var="company" items="${list}">
	<tr>
		<td class="code"><a href="./read.do?compCd=${company.compCd}">${company.compCd}</a></td>
		<td>${company.compName}</td>
		<td class="english">${company.engName}</td>
		<td class="narrow">${company.repName}</td>
		<td class="address">${company.address}</td>
		<td>${company.compCall}</td>
		<td class="narrow">${company.sort}</td>
	</tr>
</c:forEach>
</table>
</div>
<br/>
<div style="text-align:center"><a href="viewCreate.do"><input type="button" value="신규 기업 추가"></a></div>
</body>
</html>