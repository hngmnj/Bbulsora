<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${contextPath}/resources/css/default_table.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
//중분류 옵션 변경 시 실행
function srchMinor() {
	$.ajax({
		type : "get",
		url : "${contextPath}/rest/searchMinor.do",
		dataType : "text",
		data : {middle:$('#middle').val()},
		success : function(data,status){
			let jsonObj = JSON.parse(data);
			let result = "소분류<select id='minor'><option value=''>선택안함</option>";
			for(let i=0; i<jsonObj.length; i++){
				result += "<option value='"+jsonObj[i].minor+"'>"+jsonObj[i].minor+"</option>";
			}
			result += "</select>&nbsp;&nbsp;";
			$('#minor_list').html(result);
		},
		error : function(data,status){
			alert("error "+status);
		},
	}); // ajax end
}// fn srchMinor end

//주문요청 대기 테이블 폼
const tableHeader = "<table><tr><th>품목코드</th><th>품목명</th><th>공급사명</th><th>수량</th><th>단위</th><th>관리</th></tr>";
let tableMap = new Map();
const tableFooter = "</table><br/><input type='button' value='주문요청' onclick='checkOrder()'>";

//주문요청 리스트에 품목 추가
function addItem(code) {
	$.ajax({
		type : "get",
		url : "${contextPath}/rest/selectItem.do",
		dataType : "text",
		data : {itemCd:code},
		success : function(data,status){
			let jsonObj = JSON.parse(data);
			let result = "<tr><td><a href='#' target='_top' onclick='showItemInfo(\""+jsonObj.itemCd+"\")'>"+jsonObj.itemCd+"</a></td>"
			+"<td>"+jsonObj.itemName+"</td><td>"+jsonObj.compName+"</td><td><input type='text' oninput='checkInput()' id='"+jsonObj.itemCd+"'></td><td>"+jsonObj.unit+"</td>"
			+"<td><input type='button' value='삭제' onclick='deleteItem(\""+jsonObj.itemCd+"\")'></td></tr>";
			tableMap.set(jsonObj.itemCd,result);
			changeOrderList();
		},
		error : function(data,status){
			alert("error "+status);
		},
	}); // ajax end
}

//주문요청 리스트에 품목 삭제
function deleteItem(key) {
	tableMap.delete(key);
	changeOrderList();
}

//주문요청 리스트 갱신
function changeOrderList() {
	let tableBody = "";
	let iterator = tableMap.values()
	for(let i=0; i<tableMap.size; i++){
		tableBody += iterator.next().value;
	}
	if(tableMap.size == 0){
		$('#order_list').html(tableHeader+tableBody+"</table>");
	}else {
		$('#order_list').html(tableHeader+tableBody+tableFooter);
	}
}

//아이템 상세
function showItemInfo(itemCd) {
	let topMargin = event.screenY - event.clientY + 10;
	let leftMargin = event.screenX - event.clientX;
    let url = "${contextPath}/item/readTop.do?itemCd="+itemCd;
    let name = "품목 상세정보";
    let option = "width = 500, height = 500, top = "+topMargin+", left = "+leftMargin+", location = no";
    window.open(url, name, option);
}



// 주문 요청 전 확인
function checkOrder() {

	if(confirm("요청확인")){
		let orderList = [];
		let order;
		let iterator = tableMap.keys();
		for(let i=0; i<tableMap.size; i++){
			let key = iterator.next().value;
			order = new Object();
			order.itemCd = key;
			order.orderQtt = $('#'+key).val();
			if(order.orderQtt==0 || order.orderQtt=="") {
				alert('주문 수량은 0이 될 수 없습니다.');
				return false;
			}
			orderList.push(order);
		}

 		$.ajax({
			type : "post",
			url : "${contextPath}/order/create.do",
			dataType : "text",
			contentType: "application/json",
			data : JSON.stringify(orderList),
			success : function(data,status){
				alert("주문요청완료");
				location.replace("${contextPath}/order/list.do");
			},
			error : function(data,status){
				alert("error "+status);
			},
		}); // ajax end
	}//if end 
	else {
		return false;
	}
}

//사용자 입력오류 방지
function checkInput() {
	let inputText = event.target.value;
	let modText = inputText.replaceAll(/[^0-9]/g,"");
	if(inputText != modText){
		alert("숫자만 입력 가능합니다.");
		event.target.value = modText;
	}
}// input event end

$(document).ready(function(){
	//대분류 옵션 변경 시 실행
	$('#major').on('change',function(){
		$.ajax({
			type : "get",
			url : "${contextPath}/rest/searchMiddle.do",
			dataType : "text",
			data : {major:$('#major').val()},
			success : function(data,status){
				let jsonObj = JSON.parse(data);
				let result = "중분류<select id='middle' onchange='srchMinor()'><option value=''>선택안함</option>";
				for(let i=0; i<jsonObj.length; i++){
					result += "<option value='"+jsonObj[i].middle+"'>"+jsonObj[i].middle+"</option>";
				}
				result += "</select>&nbsp;&nbsp;";
				$('#middle_list').html(result);
			},
			error : function(data,status){
				alert("error "+status);
			},
		}); // ajax end
	});//major end
	
	//검색 버튼 클릭 시 실행
	$('#btn_srchItem').on('click',function(){
		$.ajax({
			type : "get",
			url : "${contextPath}/rest/searchItem.do",
			dataType : "text",
			data : {major:$('#major').val(), middle:$('#middle').val(), minor:$('#minor').val(), searchText:$('#searchText').val()},
			success : function(data,status){
				let jsonObj = JSON.parse(data);
				let result = "<table><tr><th>품목코드</th><th>품목명</th><th>공급사명</th><th>관리</th></tr>";
				for(let i=0; i<jsonObj.length; i++){
					result += "<tr><td><a href='#' target='_top' onclick='showItemInfo(\""+jsonObj[i].itemCd+"\")'>"+jsonObj[i].itemCd+"</a></td>"
					+"<td>"+jsonObj[i].itemName+"</td><td>"+jsonObj[i].compName+"</td>"
					+"<td><input type='button' value='등록' onclick='addItem(\""+jsonObj[i].itemCd+"\")'></td></tr>";
				}
				result += "</table>";
				$('#search_result').html(result);
			},
			error : function(data,status){
				alert("error "+status);
			},
		}); // ajax end
	});//btn_srchItem end
		
});//document end

</script>
<title>주문등록</title>
</head>
<body>
<h1 align = "center">[주문 작성]</h1>
</br>
</br>
	<div id="order_sub_menu" style="text-align: center; height: 50px">
		대분류<select id="major"><option value="">선택안함</option>
			<c:forEach var="item" items="${itemList}">
				<option value="${item.major}">${item.major}</option>
			</c:forEach></select>&nbsp;&nbsp;
			
		<span id="middle_list">
			중분류<select id='middle'><option value="">선택안함</option></select>&nbsp;&nbsp;
		</span> 
			
		<span id="minor_list">
			소분류<select id='minor'><option value="">선택안함</option></select>&nbsp;&nbsp;
		</span> <input type="text" id="searchText">&nbsp;
		
		<input type="button" value="검색" id="btn_srchItem">
	</div>

	<div id="search_result" style="overflow: auto; height: 250px">
		<table>
			<tr>
				<th>품목코드</th>
				<th>품목명</th>
				<th>공급사명</th>
				<th>관리</th>
			</tr>
		</table>
	</div>
	<br />

	<div id="order_list"
		style="overflow: auto; text-align: center; height: 250px">
		<table>
			<tr>
				<th>품목코드</th>
				<th>품목명</th>
				<th>공급사명</th>
				<th>수량</th>
				<th>단위</th>
				<th>관리</th>
			</tr>
		</table>
	</div>

</body>
</html>