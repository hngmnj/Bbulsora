<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add State Info</title>
</head>
<body>
<form action="create.do" method="post">
<table>	
	<tr><td>상태코드</td><td><input type="text" name="stateCd"></td></tr>
	<tr><td>내용</td><td><input type="text" name="stateContent"></td></tr>
	<tr><td colspan="3"><input type="submit" value="추가하기"></td><td>
</table>
</form>
</body>
</html>