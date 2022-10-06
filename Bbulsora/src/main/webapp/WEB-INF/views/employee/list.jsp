<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/default_table.css">
<title>Employee List</title>
</head>
<body>
<h1>Employee List</h1>
<a href="${contextPath}/employee/viewJoin.do">회원가입</a>
<table>
	<tr><th>사원번호</th><th>이름</th><th>전화번호</th><th>생년월일</th><th>이메일</th><th>주소</th><th>우편번호</th><th>소속부서</th><th>직책</th><th>입사일</th><th>퇴사일</th><th>관리</th></tr>
<c:forEach var="employee" items="${list}">
	<tr>
		<td><a href="${contextPath}/employee/read.do?empNo=${employee.empNo}">${employee.empNo}</a></td>
		<td>${employee.name}</td>
		<td>${employee.phoneNum}</td>
		<td><fmt:formatDate value="${employee.birthDate}" pattern="yyyy-MM-dd" /></td>
		<td>${employee.email}</td>
		<td>${employee.address}</td>
		<td>${employee.postNum}</td>
		<td>${employee.deptmt}</td>
		<td>${employee.position}</td>
		<td><fmt:formatDate value="${employee.startDate}" pattern="yyyy-MM-dd" /></td>
		<td><fmt:formatDate value="${employee.endDate}" pattern="yyyy-MM-dd" /></td>
		<td><a href="${contextPath}/employee/delete.do?empNo=${employee.empNo}">삭제</a></td>
	</tr>
</c:forEach>
</table>
</body>
</html>