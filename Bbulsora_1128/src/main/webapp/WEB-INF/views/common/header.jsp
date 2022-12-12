<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>메인메뉴</title>
</head>
<body style="padding: 0px">
<c:choose>
	<c:when test="${user.compCd eq 'ADMIN'}">
	<!-- 관리자 매뉴 -->
	<a href="${contextPath}/order/list.do">주문관리</a>
	<a href="${contextPath}/store/list.do">입고관리</a>
	<a href="${contextPath}/delivery/list.do">출고관리</a>
	<a href="${contextPath}/stock/list.do">재고관리</a>
	<a href="${contextPath}/company/list.do">업체관리</a>
	<a href="${contextPath}/item/list.do?compCd=${user.compCd}">품목관리</a>
	<a href="${contextPath}/board/list.do">공지사항</a>
	<a id="ali_right" href="${contextPath}/logout.do">로그아웃</a>
	<a id="ali_right" href="${contextPath}/viewUpdate.do">개인정보 수정</a>
	</c:when>
	<c:when test="${fn:substring(user.compCd,0,3) eq 'SUP'}">
	<!-- 공급사 매뉴 -->
	<a href="${contextPath}/cal/read.do">정보조회</a>
	<a href="${contextPath}/order/list.do">주문관리</a>
	<a href="${contextPath}/item/list.do?compCd=${user.compCd}">품목관리</a>
	<a href="${contextPath}/board/list.do">공지사항</a>
	<a id="ali_right" href="${contextPath}/logout.do">로그아웃</a>
	<a id="ali_right" href="${contextPath}/viewUpdate.do">개인정보 수정</a>
	</c:when>
	<c:otherwise>
	<!-- 고객사 매뉴 -->
	<a href="${contextPath}/cal/read.do">정보조회</a>
	<a href="${contextPath}/order/viewCreate.do">주문등록</a>
	<a href="${contextPath}/order/list.do">주문조회</a>
	<a href="${contextPath}/stock/list.do">재고조회/출고요청</a>
	<a href="${contextPath}/delivery/list.do">출고조회</a>
	<a href="${contextPath}/board/list.do">공지사항</a>
	<a id="ali_right" href="${contextPath}/logout.do">로그아웃</a>
	<a id="ali_right" href="${contextPath}/viewUpdate.do">개인정보 수정</a>
	</c:otherwise>
</c:choose>    
</body>
</html>