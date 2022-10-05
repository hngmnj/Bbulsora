<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/default_table.css">
<title>JOIN</title>
</head>
<body>
<form action="${contextPath}/employee/create.do" method="post">
<table>
	<tr><td>사원번호 : </td><td><input type="text" name="empNo" value=""></td></tr>
	<tr><td>이름 : </td><td><input type="text" name="name" value=""></td></tr>
	<tr><td>생년월일 : </td><td><input type="text" name="birthDate" value=''></td></tr>
	<tr><td>전화번호 : </td><td><input type="text" name="phoneNum" value=""></td></tr>
	<tr><td>이메일 : </td><td><input type="text" name="email" value=""></td></tr>
	<tr><td>성별 : </td><td><input type="text" name="gender" value=""></td></tr>
	<tr><td>주소 : </td><td><input type="text" name="address" value=""></td></tr>
	<tr><td>우편번호 : </td><td><input type="text" name="postNum" value=""></td></tr>
	<tr><td>주민등록번호 : </td><td><input type="text" name="regiNum" value=""></td></tr>
	<tr><td>소속부서 : </td><td><input type="text" name="deptmt" value=""></td></tr>
	<tr><td>직책 : </td><td><input type="text" name="position" value=""></td></tr>
	<tr><td>입사년월일 : </td><td><input type="text" name="startDate" value=''></td></tr>
	<tr><td>퇴사년월일 : </td><td><input type="text" name="endDate" value=''></td></tr>
	<tr><td><input type="reset" value="다시입력"></td><td><input type="submit" value="제출"></td></tr>
</table>
</form>
</body>
</html>