<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/default_table.css">
<title>JOIN</title>
</head>
<body>
<form action="./create.do" method="post">
<table>
	<tr><td>사원번호 : </td><td><input type="text" size="30px" name="empNo"></td></tr>
	<tr><td>이름 : </td><td><input type="text" size="30px" name="name"></td></tr>
	<tr><td>생년월일 : </td><td><input type="text" size="30px" name="birthDate" placeholder="yyyy-MM-dd HH:mm:ss 형식 준수!"></td></tr>	
	<tr><td>전화번호 : </td><td><input type="text" size="30px" name="phoneNum"></td></tr>
	<tr><td>이메일 : </td><td><input type="text" size="30px" name="email"></td></tr>
	<tr><td>성별 : </td><td><input type="text" size="30px" name="gender"></td></tr>
	<tr><td>주소 : </td><td><input type="text" size="30px" name="address"></td></tr>
	<tr><td>우편번호 : </td><td><input type="text" size="30px" name="postNum"></td></tr>
	<tr><td>주민등록번호 : </td><td><input type="text" size="30px" name="regiNum"></td></tr>
	<tr><td>소속부서 : </td><td><input type="text" size="30px" name="deptmt"></td></tr>
	<tr><td>직책 : </td><td><input type="text" size="30px" name="position"></td></tr>
	<tr><td>입사년월일 : </td><td><input type="text" size="30px" name="startDate" placeholder="yyyy-MM-dd HH:mm:ss 형식 준수!"></td></tr> 
<!--<tr><td>퇴사년월일 : </td><td><input type="text" name="endDate"></td></tr>-->
	<tr><td><input type="reset" value="다시입력"></td><td><input type="submit" value="제출"></td></tr>
</table>
</form>
</body>
</html>