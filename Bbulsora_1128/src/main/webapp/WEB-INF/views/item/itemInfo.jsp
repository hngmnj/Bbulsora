<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item Info</title>
</head>
<body>
<form action="update.do" method="post">
<input type="hidden" name="itemCd" value="${item.itemCd}">
<table>
	<tr><td>품목이미지</td><td><img src="/images/${item.imgName}" alt="" width="300" height="200"></td></tr>
	<tr><td>품목코드</td><td>${item.itemCd}</td></tr>
	<tr><td>기업명</td><td>${item.compName}</td></tr>
	<tr><td>품목명</td><td><input type="text" name="itemName" value="${item.itemName}"></td></tr>
	<tr><td>대분류</td><td><input type="text" name="major" value="${item.major}"></td></tr>
	<tr><td>중분류</td><td><input type="text" name="middle" value="${item.middle}"></td></tr>
	<tr><td>소분류</td><td><input type="text" name="minor" value="${item.minor}"></td></tr>
	<tr><td>규격</td><td>${item.standard}</td></tr>
	<tr><td>단위</td><td><input type="text" name="unit" value="${item.unit}"></td></tr>
	<c:if test="${fn:substring(user.compCd,0,3) ne 'CLI'}">
	<tr><td colspan="3"><input type="submit" value="수정하기"> <a href="delete.do?itemCd=${item.itemCd}"><input type="button" value="삭제하기"></a></td></tr>
	</c:if>
</table>
</form>
</body>
</html>