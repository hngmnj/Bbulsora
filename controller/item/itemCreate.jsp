<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Item Info</title>
</head>
<body>
<form action="create.do" method="post" enctype="multipart/form-data">
<table>	
	<tr><td>품목명</td><td><input type="text" name="itemName"></td></tr>
	<tr><td>대분류</td><td><input type="text" name="major"></td></tr>
	<tr><td>중분류</td><td><input type="text" name="middle"></td></tr>
	<tr><td>소분류</td><td><input type="text" name="minor"></td></tr>
	<tr><td>규격</td><td><input type="text" name="standard"></td></tr>
	<tr><td>단위</td><td><input type="text" name="unit"></td></tr>
	<tr><td>품목이미지</td><td><input type="file" name="uploadImage"></td></tr>
	<tr><td>기업코드</td><td><input type="text" name="compCd"></td></tr>
	<tr><td colspan="3"><input type="submit" value="추가하기"></td><td>
</table>
</form>
</body>
</html>