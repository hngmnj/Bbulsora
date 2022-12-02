<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성 페이지</title>
</head>
<body>

<div style="text-align: center;">

<form action="${contextPath}/board/create.do" method="post" enctype="multipart/form-data">
<input type="hidden" value="${user.id}" name="brdWriter">
<table style="margin: auto;">
<tr>
	<td>카테고리 : <select name="category"><option value="일반">일반</select></td>
	<td><input type="text" placeholder="제목" name="title"></td>	
	<td>첨부파일 : <input type="file" name="uploadFile"></td>	
</tr>
<tr>
	<td colspan="3"><textarea rows="20" cols="100" name="brdContent"></textarea></td>
</tr>
<tr>
	<td colspan="3"><input type="submit" value="작성 완료"></td>
</tr>
</table>
</form>

</div>
</body>
</html>