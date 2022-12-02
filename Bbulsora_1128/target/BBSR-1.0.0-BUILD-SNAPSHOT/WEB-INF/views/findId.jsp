<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/main.css" type="text/css">
<title>아이디 찾기 페이지</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#btn1').on('click',function(){
		if(document.getElementsByName("name")[0].value ==  "") {
			alert("이름을 입력하지 않았습니다.");
			return false;
		}else if(document.getElementsByName("compCd")[0].value == "") {
			alert("기업코드를 입력하지 않았습니다.");
			return false;
		}else if(document.getElementsByName("phone")[0].value == "") {
			alert("휴대폰번호를 입력하지 않았습니다.");
			return false;
		}
		$.ajax({
			type : "get",
			url : "rest/findId.do",
			dataType : "text",
			data : {name:$('#name').val(), compName:$('#compName').val(), phone:$('#phone').val()},
			success : function(data,status){
				let result = "";
				console.log(data);
				if(data.length < 1){
					result = "입력하신 정보와 일치하는 데이터가 없습니다.";
					alert(result);
				}else{
					result = "입력하신 정보와 일치하는 아이디는 " + data + "입니다.";
					$('#finding_result').html(result);
					$('#component_input').css("display","none");
					$('#component_result').css("display","block");
				}
				
			},
			error : function(data,status){
				alert("error "+status);
			},
		}); // ajax end
	});
});
</script>
</head>
<body class="main">
<div class="fixed1" id="component_input">
	<input type="text" placeholder="이름" name="name" id="name"><br/>
	<input type="text" placeholder="기업코드" name="compCd" id="compCd"><br/>
	<input type="text" placeholder="휴대폰번호" name="phone" id="phone"><br/>
	<input type="button" value="아이디 찾기" id="btn1">
</div>
<div class="fixed1" id="component_result" style="display:none;">
<p id="finding_result"></p>
<a href="${contextPath}"><input type="button" value="로그인 페이지로"></a>
</div>
</body>
</html>