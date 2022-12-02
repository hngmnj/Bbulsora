<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<title>하단 부분</title>
<style>
p {
 font-size:15px;
  text-align:center;
}
</style>
<script type="text/javascript">

let topMargin = 0;
let leftMargin = 0;

$(document).ready(function(){
	$('#compMap').on('click', function(event) {
		topMargin = event.screenY - event.clientY + 10;
		leftMargin = event.screenX - event.clientX;
		showMap();
	});
});

function showMap(){
    let url = "https://map.naver.com/v5/entry/place/15826419?c=14315950.4574501,4198069.4192432,15.45,0,0,0,dh";
    let name = "company map";
    let option = "width = 1000, height = 800, top = "+topMargin+", left = "+leftMargin+", location = no";
    window.open(url, name, option);
}

</script>
</head>
<body>
<p> e-mail : bbulsora@gntp.com</p> 
<p> 회사주소 : 경남 창원시 의창구 창원대로18번길 22</p>
<p>찾아오는 길 : <a href="#" target="_top" id="compMap">약도</a></p>
</body>
</html>