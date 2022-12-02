<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function btn_on(cmntSeq){
	$('#read'+cmntSeq).css("display","none");
	$('#update'+cmntSeq).css("display","block");
}
</script>
<style type="text/css">
table {
	width:70%; 
    margin-left:15%; 
    margin-right:15%;
}
table, tr, th, td {
	border: 1px solid;
	border-collapse: collapse;
}
th{
	text-align: center;
	padding: 5px;
}
td{
	padding: 5px;
	padding-left: 10px;
}
#board_body{
	padding: 20px;
}
#comments table, #comments th,#comments td,#comments tr {
	border: 0px solid;
	border-collapse: collapse;
}
</style>
<title>공지사항</title>
</head>
<body>

<div id="board_head">
<table>
<tr>
	<td colspan="3">* ${board.category}</td>
</tr>
<tr>
	<th style="width: 90px">제목</th><td colspan="2">${board.title}</td>
</tr>
<c:if test="${board.filename ne null}">
<tr>
	<td>첨부파일</td><td>${board.filename}</td><td><a href="${contextPath}/board/download.do?filepath=${board.filepath}"><input type="button" value="다운로드"></a></td>
</tr>
</c:if>
</table>
</div>

<div id="board_body" style="height: 250px; margin-left: 15%; margin-right: 15%; overflow: auto;">
${board.brdContent}
</div>

<div id="board_footer">
<table>
<tr>
	<th style="width: 90px">작성자</th><td colspan="2">${board.brdWriter}</td>
</tr>
<tr>
	<td colspan="3"  style="text-align: center;"><a href="${contextPath}/board/list.do"><input type="button" value="공지사항 목록으로"></a></td>
</tr>
<c:if test="${user.compCd eq 'ADMIN'}">
<tr>
	<td colspan="3" style="text-align: center;">
		<a href="${contextPath}/board/viewUpdate.do?brdSeq=${board.brdSeq}"><input type="button" value="수정"></a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="${contextPath}/board/delete.do?brdSeq=${board.brdSeq}"><input type="button" value="삭제"></a>
	</td>
</tr>
</c:if>
</table>
</div>

<div id="comments">

<form action="${contextPath}/board/createComment.do" method="post">
<input type="hidden" value="${user.id}" name="cmntWriter">
<input type="hidden" value="${board.brdSeq}" name="brdSeq">
<table>
<tr><td>${user.id}<td><input type="text" placeholder="댓글 입력" name="cmntContent"></td><td><input type="submit" value="댓글등록"></td></tr>
</table>
</form>

<table>
<c:forEach var="comment" items="${board.commentList}">
<tr id="read${comment.cmntSeq}">
	<td>${comment.cmntWriter}</td>
	<td>${comment.cmntContent}</td>
	<td>${comment.cmntDate}</td>
	<c:if test="${comment.cmntWriter ne null}">
	<td><c:if test="${user.id eq comment.cmntWriter}"><input type="button" value="수정" onclick="btn_on(${comment.cmntSeq})"></c:if></td>
	<td><c:if test="${user.id eq comment.cmntWriter or user.compCd eq 'ADMIN'}"><a href="${contextPath}/board/deleteComment.do?cmntSeq=${comment.cmntSeq}&brdSeq=${board.brdSeq}"><input type="button" value="삭제"></a></c:if></td>
	</c:if>
</tr>
<form action="${contextPath}/board/updateComment.do?brdSeq=${board.brdSeq}" method="post">
<tr id="update${comment.cmntSeq}" style="display: none;">
	<td>${comment.cmntWriter}</td>
	<td><input type="text" value="${comment.cmntContent}" name="cmntContent"><input type="hidden" value="${comment.cmntSeq}" name="cmntSeq"></td>
	<td>${comment.cmntDate}</td>
	<td><c:if test="${user.id eq comment.cmntWriter}"><input type="submit" value="수정완료"></c:if></td>
	<td><c:if test="${user.id eq comment.cmntWriter}"><a href="${contextPath}/board/read.do?brdSeq=${board.brdSeq}"><input type="button" value="취소"></a></c:if></td>
</tr>
</form>
</c:forEach>
</table>


</div>

</body>
</html>