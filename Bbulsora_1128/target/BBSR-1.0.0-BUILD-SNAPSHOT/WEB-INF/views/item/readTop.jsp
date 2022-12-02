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
	<tr><td>품목이미지</td><td><img src="${item.img}" alt="" width="300" height="200"></td></tr>
	<tr><td>품목코드</td><td>${item.itemCd}</td></tr>	
	<tr><td>품목명</td><td><input type="text" name="itemName" value="${item.itemName}"></td></tr>
	<tr><td>대분류</td><td><input type="text" name="major" value="${item.major}"></td></tr>
	<tr><td>중분류</td><td><input type="text" name="middle" value="${item.middle}"></td></tr>
	<tr><td>소분류</td><td><input type="text" name="minor" value="${item.minor}"></td></tr>
	<tr><td>규격</td><td><input type="text" name="standard" value="${item.standard}"></td></tr>
	<tr><td>단위</td><td><input type="text" name="unit" value="${item.unit}"></td></tr>
	<tr><td>기업코드</td><td><input type="text" name="compCd" value="${item.compCd}"></td></tr>
</table>
</body>
</html>