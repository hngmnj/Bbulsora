<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/main.css" type="text/css">
<title>비밀번호 변경 페이지</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#btn1').on('click',function(){
		if(document.getElementsByName("id")[0].value ==  "") {
			alert("아이디를 입력하지 않았습니다.");
			return false;
		}else if(document.getElementsByName("name")[0].value ==  "") {
			alert("이름을 입력하지 않았습니다.");
			return false;
		}else if(document.getElementsByName("compName")[0].value == "") {
			alert("기업명을 입력하지 않았습니다.");
			return false;
		}else if(document.getElementsByName("phone")[0].value == "") {
			alert("휴대폰번호를 입력하지 않았습니다.");
			return false;
		}
		$.ajax({
			type : "get",
			url : "rest/findPwd.do",
			dataType : "text",
			data : {id:$('#id').val(), name:$('#name').val(), compName:$('#compName').val(), phone:$('#phone').val()},
			success : function(data,status){
				let result = "";
				if(data == "nag") {
					result = "입력하신 정보와 일치하는 데이터가 없습니다.";
					alert(result);
				}else{
					$('#component_input').css("display","none");
					$('#component_result1').css("display","block");
				}
			},
			error : function(data,status){
				alert("error "+status);
			},
		}); // ajax end
	});// btn1 end
	$('#btn2').on('click',function(){
		if($('#pwd').val() != $('#pwd2').val()) {
			alert("입력한 비밀번호가 일치하지 않습니다.");
			return false;
		}
		$.ajax({
			type : "get",
			url : "rest/changePwd.do",
			dataType : "text",
			data : {id:$('#id').val(), pwd:$('#pwd').val()},
			success : function(data,status){
				let result = "";
				if(data == "nag") {
					result = "서버 오류 발생.";
					alert(result);
				}else{
					$('#component_result1').css("display","none");
					$('#component_result2').css("display","block");
				}
			},
			error : function(data,status){
				alert("error "+status);
			},
		}); // ajax end
	});// btn2 end
});
</script>
</head>
<body class="main">
<form action="changePwd.do" method="post">
<div class="fixed1" id="component_input">
	<input type="text" placeholder="아이디" name="id" id="id"><br/>
	<input type="text" placeholder="이름" name="name" id="name"><br/>
	<input type="text" placeholder="기업명" name="compName" id="compName"><br/>
	<input type="text" placeholder="휴대폰번호" name="phone" id="phone"><br/>
	<input type="button" value="비밀번호 변경 요청" id="btn1"><br/>
</div>
<div class="fixed1" id="component_result1" style="display:none;">
	<input type="password" placeholder="새로운 비밀번호" name="pwd" id="pwd"><br/>
	<input type="password" placeholder="다시 입력" name="pwd2" id="pwd2"><br/>
	<input type="button" value="비밀번호 변경" id="btn2">
</div>
<div class="fixed1" id="component_result2" style="display:none;">
	<p>비밀번호가 정상적으로 변경되었습니다.</p>
	<a href="${contextPath}"><input type="button" value="로그인 페이지로"></a>
</div>
</form>
</body>
</html>