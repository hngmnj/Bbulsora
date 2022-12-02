<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>게시글 수정 페이지</title>
</head>
<body>

<div style="text-align: center;">

<form action="${contextPath}/board/update.do" method="post" enctype="multipart/form-data">
<input type="hidden" value="${board.brdSeq}" name="brdSeq">
<table style="margin: auto;">
<tr>
	<td>카테고리 : <select name="category"><option value="${board.category}">${board.category}</select></td>
	<td><input type="text" value="${board.title}" name="title"></td>	
	<td></td>	
</tr>
<tr>
	<td colspan="3"><textarea rows="20" cols="100" name="brdContent">${board.brdContent}</textarea></td>
</tr>
<tr>
	<td colspan="3"><input type="submit" value="수정완료"></td>
</tr>
</table>
</form>

</div>

</body>
</html>