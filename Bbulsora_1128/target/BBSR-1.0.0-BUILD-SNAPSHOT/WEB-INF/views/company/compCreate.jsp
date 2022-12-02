<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Company Info</title>
</head>
<body>
<form action="create.do" method="post">
<table>	
	<tr><td>기업명</td><td><input type="text" name="compName"></td></tr>
	<tr><td>영문명</td><td><input type="text" name="engName"></td></tr>
	<tr><td>대표명</td><td><input type="text" name="repName"></td></tr>
	<tr><td>주소</td><td><input type="text" name="address"></td></tr>
	<tr><td>연락처</td><td><input type="text" name="compCall"></td></tr>
	<tr><td>기업구분</td><td><select name="sort"><option value="CLIENT">고객사</option><option value="SUPPLY">공급사</option></select></tr>
	<tr><td colspan="3"><input type="submit" value="추가하기"></td><td>
</table>
</form>
</body>
</html>