<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/main.css" type="text/css">
<title>회원가입 페이지</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function catchNullException() {
	if(document.getElementsByName("pwd")[0].value == "") {
		alert("비밀번호를 입력하지 않았습니다.");
		return false;
	}else if(document.getElementsByName("name")[0].value == "") {
		alert("이름을 입력하지 않았습니다.");
		return false;
	}else if(document.getElementsByName("phone")[0].value == "") {
		alert("연락처를 입력하지 않았습니다.");
		return false;
	}else if(document.getElementsByName("email")[0].value == "") {
		alert("이메일을 입력하지 않았습니다.");
		return false;
	}
	alert("회원정보가 수정되었습니다.");
}
</script>
</head>
<body class="main">
<form action="${contextPath}/update.do" method="post">
<input type="hidden" value="${user.compCd}" name="compCd">
<table style="margin: auto;">
	<tr><td>아이디 : </td><td><input type="text" value="${user.id}" name="id" id="id" readonly="readonly"></td></tr>
	<tr><td>비밀번호 : </td><td><input type="password" value="${user.pwd}" name="pwd"></td></tr>
	<tr><td>이름 : </td><td><input type="text" value="${user.name}" name="name"></td></tr>
	<tr><td>연락처 : </td><td><input type="text" value="${user.phone}" name="phone"></td></tr>
	<tr><td>이메일 : </td><td><input type="text" value="${user.email}" name="email"></td></tr>
	<tr><td colspan="2" align="center"><input type="submit" value="수정완료" onclick="return catchNullException()" id="btn_submit"></td></tr>
</table>
</form>
</body>
</html>
