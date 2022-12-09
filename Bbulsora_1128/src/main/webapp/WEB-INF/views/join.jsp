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
$(document).ready(function(){
	$('#btn1').on('click',function(){
		if(document.getElementsByName("id")[0].value ==  "") {
			alert("아이디를 입력하지 않았습니다.");
			return false;
		}
		$.ajax({
			type : "get",
			url : "rest/idCheck.do",
			dataType : "text",
			data : {id:$('#id').val()},
			success : function(data,status){
				let result = "";
				console.log(data);
				if(data == 'true'){
					result = "이미 존재하는 아이디 입니다.";
					alert(result);
				}else{
					result = $('#id').val() + "은 사용 가능한 아이디 입니다.\n해당 아이디로 회원가입을 계속 하시겠습니까?";
					if(confirm(result)){
						$('#id').attr("readonly",true);
						$('#btn_submit').css("display","block");
						$('#btn1').css("display","none");
					}else{
						return false;
					}
				}
				
			},
			error : function(data,status){
				alert("error "+status);
			},
		}); // ajax end
	});
});

function catchNullException() {
	if(document.getElementsByName("id")[0].value ==  "") {
		alert("아이디를 입력하지 않았습니다.");
		return false;
	}else if(document.getElementsByName("pwd")[0].value == "") {
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
	}else if(document.getElementsByName("compCd")[0].value == "") {
		alert("기업명을 입력하지 않았습니다.");
		return false;
	}
	alert("회원가입 요청이 처리되었습니다.");
}
</script>
</head>
<body class="main">
<div class="fixed2">
	<form action="${contextPath}/join.do" method="post">
	<table style="margin: auto;">
		<tr><td><input type="text" placeholder="아이디" name="id" id="id"></td><td></td></tr>
		<tr><td><input type="button" value="ID 중복체크" id="btn1"></td><td></td></tr>
		<tr><td><input type="password" placeholder="비밀번호" name="pwd"></td><td></td></tr>
		<tr><td><input type="text" placeholder="이름" name="name"></td><td></td></tr>
		<tr><td><input type="text" placeholder="연락처" name="phone"></td><td></td></tr>
		<tr><td><input type="text" placeholder="이메일" name="email"></td><td></td></tr>
		<tr><td><select name="compCd"><option value="">--기업명 선택--</option><c:forEach var="comp" items="${compList}"><option value="${comp.compCd}">${comp.compName}(${comp.sort eq 'CLIENT' ? "고객사" : "공급사"})</option></c:forEach></select></td><td></td></tr>
		<tr><td align="center"><input style="display: none;" type="submit" value="회원가입" onclick="return catchNullException()" id="btn_submit"></td><td></td></tr>
	</table>
	</form>
</div>
</body>
</html>
