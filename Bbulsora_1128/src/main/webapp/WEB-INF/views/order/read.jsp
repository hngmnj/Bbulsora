<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
   href="${contextPath}/resources/css/default_table.css" type="text/css">
<script type="text/javascript">
   function showItemInfo(itemCd) {
      let topMargin = event.screenY - event.clientY + 10;
      let leftMargin = event.screenX - event.clientX;
      let url = "${contextPath}/item/readTop.do?itemCd=" + itemCd;
      let name = "품목 상세정보";
      let option = "width = 320, height = 400, location = no";
      window.open(url, name, option);
   }
   function delConfirm() {
      return confirm("요청을 취소하시겠습니까?");
   }
   function upConfirm(seq) {
      if(confirm("주문상태를 수정하시겠습니까?")) {
    	  $.ajax({
    		type: "get",
    		url: "${contextPath}/order/update.do",
    		dataType: "text",
    		data: {storeQtt: $('#storeQtt'+seq).val(), prevStateCd: $('#prevStateCd'+seq).val(), stateCd: $('#stateCd'+seq).val(), orderCd: $('#orderCd'+seq).val(), orderSeq: $('#orderSeq'+seq).val()},
    	  	success : function(data,status){
				alert("수정 완료");
				location.replace("${contextPath}/order/read.do?orderCd="+$('#orderCd'+seq).val());
			},
			error : function(data,status){
				alert("Fail...");
			}
    	  });
      } else {
    	  return false;
      }
   }
   function outStoreCsv() {
      return confirm("입고 명세서를 내보내시겠습니까?");
   }
</script>
<title>주문상세</title>
</head>
<body>
   <h3 style="text-align: center;">주문코드</h3>
   <h2 style="text-align: center;">${list == null ? '' : list[0].orderCd}</h2>
	<table>
		<tr>
			<th>품목명</th>

			<th>수량</th>

			<th>단위</th>
			<c:if test="${fn:substring(user.compCd,0,3) eq 'SUP'}">
				<th>고객사</th>
			</c:if>
			<c:if test="${fn:substring(user.compCd,0,3) eq 'CLI'}">
				<th>공급사</th>
			</c:if>
			<th>요청일</th>
			<th>발주일</th>
			<th>주문상태</th>
			<c:if test="${user.compCd ne 'ADMIN'}">
				<th>관리</th>
			</c:if>
		</tr>
		<c:forEach var="order" items="${list}">

			<!-- 관리자 주문상세 화면 -->
			<c:if test="${user.compCd eq 'ADMIN' }">
				<tr>
					<td><a href="#" target="_top"
						onclick="showItemInfo('${order.itemCd}')">${order.itemName}</a></td>
					<td>${order.orderQtt}</td>
					<td>${order.unit}</td>
					<td>${order.submitDate}</td>
					<td>${order.orderDate}</td>
					<td>${order.stateContent}</td>
				</tr>
			</c:if>

			<!-- 고객사 주문상세 화면 -->
			<c:if test="${fn:substring(user.compCd,0,3) eq 'CLI'}">
				<tr>
					<td><a href="#" target="_top"
						onclick="showItemInfo('${order.itemCd}')">${order.itemName}</a></td>

					<td>${order.orderQtt}</td>
					<td>${order.unit}</td>
					<td>${order.compName}</td>
					<td>${order.submitDate}</td>
					<td>${order.orderDate}</td>
					<td>${order.stateContent}</td>
					
					<td><c:if
							test="${order.stateCd eq 'O001' and user.compCd eq order.compCd}">
							<form action="${contextPath}/order/delete.do">
								<input type="hidden" name="orderCd" value="${order.orderCd}">
								<input type="hidden" name="orderSeq" value="${order.orderSeq}">
								<input type="submit" value="주문취소" onclick="return delConfirm()">
							</form>
						</c:if></td>
			</c:if>

			<!-- 공급사 주문상세 화면 -->
			<c:if test="${fn:substring(user.compCd,0,3) eq 'SUP'}">
				<tr>
					<td><a href="#" target="_top" onclick="showItemInfo('${order.itemCd}')">${order.itemName}</a></td>
					<c:if test="${order.stateCd eq 'O004'}">
						<td><input type="text" id="storeQtt${order.orderSeq}"
							style="width: 30px;" value="${order.orderQtt}" min="0" readonly="readonly">&nbsp;/${order.orderQtt}</td>
					</c:if>
					
					<c:if test="${order.stateCd ne 'O004'}">
						<td><input type="hidden" id="storeQtt${order.orderSeq}" value="0">${order.orderQtt}</td>
					</c:if>

					<td>${order.unit}</td>
					<td>${order.compNameCli}</td>
					<td>${order.submitDate}</td>
					<td>${order.orderDate}</td>
					<td>${order.stateContent}</td>
					<td>
						<input type="hidden" id="orderCd${order.orderSeq}" value="${order.orderCd}">
						<input type="hidden" id="orderSeq${order.orderSeq}" value="${order.orderSeq}">
						<input type="hidden" id="prevStateCd${order.orderSeq}" value="${order.stateCd}">

						<select id="stateCd${order.orderSeq}">
							<option	value="${order.stateCd}">선택안함</option>
							<c:forEach var="state" items="${order.stateList}">
								<option value="${state.stateCd}">${state.stateContent}</option>
							</c:forEach>
					</select>
						<button type="button" onclick='return upConfirm("${order.orderSeq}")'>변경저장</button></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>

	<div style="text-align: center;">
      <a href="${contextPath}/order/list.do"> <input type="button"
         value="전체 목록"></a>

      <c:if test="${fn:substring(user.compCd,0,3) eq 'SUP'}">
         <form action="${contextPath}/order/upload.do" method="post">
            <input type="hidden" name="orderCd" value="${order.orderCd}">
            <input type="hidden" name="orderSeq" value="${order.orderSeq}">
            <input type="submit" value="내보내기" onclick="return outStoreCsv()">
         </form>
      </c:if>
   </div>


</body>
</html>