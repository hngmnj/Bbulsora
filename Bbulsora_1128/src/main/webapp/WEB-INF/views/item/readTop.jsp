<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Info</title>
</head>
<body>
<table>
	<tr><td>품목이미지</td><td><img src="/images/${item.imgName}" alt="" width="300" height="200"></td></tr>
	<tr><td>품목코드</td><td>${item.itemCd}</td></tr>	
	<tr><td>품목명</td><td>${item.itemName}</td></tr>
	<tr><td>대분류</td><td>${item.major}</td></tr>
	<tr><td>중분류</td><td>${item.middle}</td></tr>
	<tr><td>소분류</td><td>${item.minor}</td></tr>
	<tr><td>규격</td><td>${item.standard}</td></tr>
	<tr><td>단위</td><td>${item.unit}</td></tr>
	<tr><td>기업코드</td><td>${item.compCd}</td></tr>
</table>
</body>
</html>