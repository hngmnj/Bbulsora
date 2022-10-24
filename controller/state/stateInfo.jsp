<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>State Info</title>
</head>
<body>
<form action="update.do" method="post">
<table>	
	<tr><td>상태코드</td><td><input type="text" name="stateCd" value="${state.stateCd}"></td></tr>
	<tr><td>내용</td><td><input type="text" name="stateContent" value="${state.stateContent}"></td></tr>
	<tr><td colspan="3"><input type="submit" value="수정하기"> <a href="delete.do?stateCd=${state.stateCd}"><input type="button" value="삭제하기"></a></td><td>
</table>
</form>
</body>
</html>