<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/default_table.css">
<title>View Employee Info</title>
</head>
<body>
<form action="${contextPath}/employee/update.do" method="post">
<table>
	<tr><td>사원번호 : </td><td><input type="text" name="empNo" readonly="readonly" value="${employee.empNo}"></td></tr>
	<tr><td>이름 : </td><td><input type="text" name="name" value="${employee.name}"></td></tr>
	<tr><td>생년월일 : </td><td><input type="date" name="birthDate" value="${employee.birthDate}"></td></tr>
	<tr><td>전화번호 : </td><td><input type="text" name="phoneNum" value="${employee.phoneNum}"></td></tr>
	<tr><td>이메일 : </td><td><input type="text" name="email" value="${employee.email}"></td></tr>
	<tr><td>성별 : </td><td><input type="text" name="gender" value="${employee.gender}"></td></tr>
	<tr><td>주소 : </td><td><input type="text" name="address" value="${employee.address}"></td></tr>
	<tr><td>우편번호 : </td><td><input type="text" name="postNum" value="${employee.postNum}"></td></tr>
	<tr><td>주민등록번호 : </td><td><input type="text" name="regiNum" value="${employee.regiNum}"></td></tr>
	<tr><td>소속부서 : </td><td><input type="text" name="deptmt" value="${employee.deptmt}"></td></tr>
	<tr><td>직책 : </td><td><input type="text" name="position" value="${employee.position}"></td></tr>
	<tr><td>입사년월일 : </td><td><input type="date" name="startDate" value="${employee.startDate}"></td></tr>
	<tr><td>퇴사년월일 : </td><td><input type="date" name="endDate" value="${employee.endDate}"></td></tr>
	<tr><td><input type="submit" value="수정"></td><td><a href="${contextPath}/employee/list.do"><input type="button" value="리스트로 가기"></a></td></tr>
</table>
</form>
</body>
</html>