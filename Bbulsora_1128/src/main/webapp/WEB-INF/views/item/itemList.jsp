<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취급 품목 내역</title>
<link rel="stylesheet" href="${contextPath}/resources/css/info_table.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
//아이템 상세
function showItemInfo(itemCd) {
   let topMargin = event.screenY - event.clientY + 10;
   let leftMargin = event.screenX - event.clientX;
    let url = "${contextPath}/item/read.do?itemCd="+itemCd;
    let name = "품목 상세정보";
    let option = "width = 350, height = 450, location = no";
    window.open(url, name, option);
}
</script>
</head>
<body>
<div style="text-align:center"><h1>취급 품목 정보</h1></div>
<div style="overflow:auto; height: 400px">
<table>
	<tr><th>품목코드</th><th>품목명</th><th>대분류</th><th>중분류</th><th>소분류</th><th>단위</th><th>기업코드</th>
<c:forEach var="item" items="${list}">
	<tr>
		<td><a href='#' target='_top' onclick='showItemInfo("${item.itemCd}")'>${item.itemCd}</a></td>
		<td>${item.itemName}</td>
		<td>${item.major}</td>
		<td>${item.middle}</td>
		<td>${item.minor}</td>
		<td>${item.unit}</td>
		<td>${item.compCd}</td>
	</tr>
</c:forEach>
</table>
</div>
<br/>
<div style="text-align:center"><a href="viewCreate.do"><button>신규 품목 추가</button></a>
<a href="viewCsvCreate.do"><button>신규 품목 csv 품목 등록</button></a></div>
</body>
</html>