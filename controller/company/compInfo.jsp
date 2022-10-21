<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Company Info</title>
</head>
<body>
<form action="update.do" method="post">
<input type="hidden" name="compCd" value="${company.compCd}">
<table>
	<tr><td>기업코드</td><td>${company.compCd}</td></tr>	
	<tr><td>기업명</td><td><input type="text" name="compName" value="${company.compName}"></td></tr>
	<tr><td>영문명</td><td><input type="text" name="engName" value="${company.engName}"></td></tr>
	<tr><td>대표명</td><td><input type="text" name="repName" value="${company.repName}"></td></tr>
	<tr><td>주소</td><td><input type="text" name="address" value="${company.address}"></td></tr>
	<tr><td>연락처</td><td><input type="text" name="compCall" value="${company.compCall}"></td></tr>
	<tr><td>기업구분</td><td><input type="text" name="sort" value="${company.sort}"></td></tr>
	<tr><td colspan="3"><input type="submit" value="수정하기"> <a href="delete.do?compCd=${company.compCd}"><input type="button" value="삭제하기"></a></td><td>
</table>
</form>
</body>
</html>