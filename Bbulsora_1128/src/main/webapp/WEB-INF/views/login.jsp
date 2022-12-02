<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/main.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

/*
let topMargin = 0;
let leftMargin = 0;

$(document).ready(function(){
	$('#finding_menu').on('click', function(event) {
		topMargin = event.screenY - event.clientY + 10;
		leftMargin = event.screenX - event.clientX;
	});
});
*/

function catchNullException() {
	if(document.getElementsByName("id")[0].value ==  "") {
		alert("아이디를 입력하지 않았습니다.");
		return false;
	}else if(document.getElementsByName("pwd")[0].value == "") {
		alert("비밀번호를 입력하지 않았습니다.");
		return false;
	}
}
/*
function popupID(){
    let url = "viewFindId.do";
    let name = "find id";
    let option = "width = 500, height = 500, top = "+topMargin+", left = "+leftMargin+", location = no";
    window.open(url, name, option);
}
function popupPWD(){
    let url = "viewChangePwd.do";
    let name = "find pwd";
    let option = "width = 500, height = 500, top = "+topMargin+", left = "+leftMargin+", location = no";
    window.open(url, name, option);
}
*/
</script>
<title>로그인</title>
</head>
<body class="main">
<div class="fixed1" id="loginInput">
	<form method="post" action="${contextPath}/login.do">
	<input type="text" placeholder="ID" name="id"><br/>
	<input type="password" placeholder="PASSWORD" name="pwd"><br/>
	<input type="submit" value="로그인" onclick="return catchNullException()" id="test">
	<a href="${contextPath}/viewJoin.do"><input type="button" value="회원가입"></a><br/>
	</form>
	<div id="finding_menu">
		<!-- <a href="javascript:popupID()" target="_top">아이디 찾기</a>&nbsp;&nbsp;&nbsp;<a href="javascript:popupPWD()" target = "_top">비밀번호 변경</a> -->
		<a href="${contextPath}/viewFindId.do">아이디 찾기</a>&nbsp;&nbsp;&nbsp;<a href="${contextPath}/viewFindPwd.do">비밀번호 변경</a>
	</div>
	
</div>

</body>
</html>