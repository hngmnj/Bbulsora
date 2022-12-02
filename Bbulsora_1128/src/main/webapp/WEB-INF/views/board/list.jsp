<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="list" value="${boardObjects.list}" />
<c:set var="total" value="${boardObjects.total}" />
<c:set var="section" value="${boardObjects.section}" />
<c:set var="pageNum" value="${boardObjects.pageNum}" />
<c:set var="searchText" value="${boardObjects.searchText}" />
<c:set var="searchOption" value="${boardObjects.searchOption}" />
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
	width:70%; 
    margin-left:15%; 
    margin-right:15%;
}
table, tr, th, td {
	border: 1px solid white;
	border-collapse: collapse;
}
th{
	background-color: rgb(75,75,255);
	color: white;
	text-align: center;
	padding: 5px;
}
td{
	background-color: rgb(204,204,255);
	padding: 5px;
	padding-left: 10px;
}
td>a{
	color: black;
	text-decoration: none;
}
input[type=button] {
	border: none;
	color: white;
	padding : 4px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	background-color: rgb(102,102,255);
	border-radius:12px;
	font-size: 12px;
	margin:10px;
}
input[type=button]:hover {
	background-color: rgb(51,51,255);
}
.no_deco {
	text-decoration: none;
}
.selected_page {
	text-decoration: none;
	color: red;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//양식 저장
	$('#searchText').val('${searchText}');
	const selects = document.getElementById('searchOption');
	const len = selects.options.length;
	for (let i=0; i<len; i++) {  
    	if(selects.options[i].value == '${searchOption}') {
	    	selects.options[i].selected = true;
	    }
	}
	
}); // document end
</script>
<title>공지사항</title>
</head>
<body>

<div id="board_sub_manu" style="text-align: center">
<form action="${contextPath}/board/list.do" method="get">
<select id="searchOption" name="searchOption">
	<option value="category">카테고리</option>
	<option value="title">글제목</option>
	<option value="brdWriter">작성자</option>
</select>
&nbsp;<input type="text" id="searchText" name="searchText">
&nbsp;<input type="submit" value="검색">
</form>
</div>

<div id="search_result">
<table>
<tr><th width="90px">카테고리</th><th>글제목</th><th width="90px">작성자</th><th width="90px">작성일</th></tr>
<c:forEach var="board" items="${list}">
<tr>
	<td>${board.category}</td>
	<td><a href="${contextPath}/board/read.do?brdSeq=${board.brdSeq}">${board.title}</a></td>
	<td>${board.brdWriter}</td>
	<td>${board.brdDate}</td>
</tr>
</c:forEach>
</table>
</div>

<div id="paging" style="text-align: center">
<c:choose>
<c:when test="${total > 100}">
	<c:forEach var="bpage" begin="1" end="10" step="1">
		<c:if test="${section > 1 && bpage == 1}">
			<a class="no_deco" href="${contextPath}/board/list.do?section=${section-1}&pageNum=${(section-1)*10}&searchText=${searchText}&searchOption=${searchOption}">&nbsp;pre</a>
		</c:if>
		<a class="no_deco" href="${contextPath}/board/list.do?section=${section}&pageNum=${bpage}&searchText=${searchText}&searchOption=${searchOption}">${(section-1)*10+bpage}</a>
		<c:if test="${bpage == 10}">
			<a class="no_deco" href="${contextPath}/board/list.do?section=${section+1}&pageNum=${section*10+1}&searchText=${searchText}&searchOption=${searchOption}">&nbsp;next</a>
		</c:if>
	</c:forEach>
</c:when>
<c:when test="${total == 100}">
	<c:forEach var="bpage" begin="1" end="10" step="1">
		<a class="no_deco" href="${contextPath}/board/list.do?section=${section}&pageNum=${bpage}&searchText=${searchText}&searchOption=${searchOption}">${bpage}</a>	
	</c:forEach>
</c:when>
<c:when test="${total < 100}">
	<c:forEach var="bpage" begin="1" end="${total/10+1}" step="1">
		<c:choose>
			<c:when test="${bpage == pageNum}">
				<a class="selected_page" href="${contextPath}/board/list.do?section=${section}&pageNum=${bpage}&searchText=${searchText}&searchOption=${searchOption}">${bpage}</a>
			</c:when>
			<c:otherwise>
				<a class="no_deco" href="${contextPath}/board/list.do?section=${section}&pageNum=${bpage}&searchText=${searchText}&searchOption=${searchOption}">${bpage}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</c:when>
</c:choose>
<br/>
<c:if test="${user.compCd eq 'ADMIN'}">
<a href="${contextPath}/board/viewCreate.do"><input type="button" value="글쓰기"></a>
</c:if>
</div>

</body>
</html>