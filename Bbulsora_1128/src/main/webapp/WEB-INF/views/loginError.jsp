<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/main.css" type="text/css">
<title>로그인 에러</title>
</head>
<body class="main">
<div class="fixed1">
<p>아이디 또는 비밀번호가 일치하지 않습니다</p>
<a href="${contextPath}/."><input type="button" value="로그인 페이지로"></a>
</div>
</body>
</html>