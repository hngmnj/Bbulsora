<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Location</title>

<link rel="stylesheet" href="${contextPath}/resources/css/location_map.css" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function updateQtt(locArea) {
   if(confirm("이 지역에 배치하시겠습니까?")) {
      $.ajax({
         type : "post",
         url : "${contextPath}/store/updateArea.do",
         dataType : "text",
         data : {orderCd:$('#orderCd').val(), storeSeq:$('#storeSeq').val(), locArea:locArea},
         success : function(data,status){
            alert(locArea+"에 배치 완료");
            window.close();
         },
         error : function(data,status){
            alert(locArea+"에 배치 실패");
         }
      });
   }
   else {
      return false;
   }
}

</script>
</head>
<body>
<input type="hidden" id="storeSeq" value="${store.storeSeq}">
<input type="hidden" id="storeQtt" value="${store.storeQtt}">
<input type="hidden" id="orderCd" value="${store.orderCd}">
<table>
   <tr><td id="${location[0].locQtt/location[0].maxQtt ge 0.8 ? 'limit-space' : (location[0].locQtt/location[0].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=3 rowspan=3><a href="#" onclick='updateQtt("${location[0].locArea}")'>${location[0].locArea}</a><br/>${location[0].locQtt}/${location[0].maxQtt}</td><td></td><td></td><td id="${location[14].locQtt/location[14].maxQtt ge 0.8 ? 'limit-space' : (location[14].locQtt/location[14].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=3><a href="#" onclick='updateQtt("${location[14].locArea}")'>${location[14].locArea}</a><br/>${location[14].locQtt}/${location[14].maxQtt}</td><td></td><td id="${location[13].locQtt/location[13].maxQtt ge 0.8 ? 'limit-space' : (location[13].locQtt/location[13].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=3><a href="#" onclick='updateQtt("${location[13].locArea}")'>${location[13].locArea}</a><br/>${location[13].locQtt}/${location[13].maxQtt}</td><td></td><td id="prohibit-space" colspan=2 rowspan=3>비품<br/>보관<br/>공간</td><td></td><td id="${location[12].locQtt/location[12].maxQtt ge 0.8 ? 'limit-space' : (location[12].locQtt/location[12].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=3><a href="#" onclick='updateQtt("${location[12].locArea}")'>${location[12].locArea}</a><br/>${location[12].locQtt}/${location[12].maxQtt}</td><td></td><td id="${location[11].locQtt/location[11].maxQtt ge 0.8 ? 'limit-space' : (location[11].locQtt/location[11].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=3><a href="#" onclick='updateQtt("${location[11].locArea}")'>${location[11].locArea}</a><br/>${location[11].locQtt}/${location[11].maxQtt}</td><td></td><td id="${location[10].locQtt/location[10].maxQtt ge 0.8 ? 'limit-space' : (location[10].locQtt/location[10].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=3><a href="#" onclick='updateQtt("${location[10].locArea}")'>${location[10].locArea}</a><br/>${location[10].locQtt}/${location[10].maxQtt}</td><td></td><td id="${location[9].locQtt/location[9].maxQtt ge 0.8 ? 'limit-space' : (location[9].locQtt/location[9].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=3 rowspan=2><a href="#" onclick='updateQtt("${location[9].locArea}")'>${location[9].locArea}</a><br/>${location[9].locQtt}/${location[9].maxQtt}</td></tr>
   <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
   <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
   <tr><td>출</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td id="${location[8].locQtt/location[8].maxQtt ge 0.8 ? 'limit-space' : (location[8].locQtt/location[8].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=3 rowspan=2><a href="#" onclick='updateQtt("${location[8].locArea}")'>${location[8].locArea}</a><br/>${location[8].locQtt}/${location[8].maxQtt}</td></tr>
   <tr><td>구</td><td></td><td></td><td></td><td id="${location[15].locQtt/location[15].maxQtt ge 0.8 ? 'limit-space' : (location[15].locQtt/location[15].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=2><a href="#" onclick='updateQtt("${location[15].locArea}")'>${location[15].locArea}</a><br/>${location[15].locQtt}/${location[15].maxQtt}</td><td id="${location[17].locQtt/location[17].maxQtt ge 0.8 ? 'limit-space' : (location[17].locQtt/location[17].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=2><a href="#" onclick='updateQtt("${location[17].locArea}")'>${location[17].locArea}</a><br/>${location[17].locQtt}/${location[17].maxQtt}</td><td></td><td id="${location[19].locQtt/location[19].maxQtt ge 0.8 ? 'limit-space' : (location[19].locQtt/location[19].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=2><a href="#" onclick='updateQtt("${location[19].locArea}")'>${location[19].locArea}</a><br/>${location[19].locQtt}/${location[19].maxQtt}</td><td id="${location[21].locQtt/location[21].maxQtt ge 0.8 ? 'limit-space' : (location[21].locQtt/location[21].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=2><a href="#" onclick='updateQtt("${location[21].locArea}")'>${location[21].locArea}</a><br/>${location[21].locQtt}/${location[21].maxQtt}</td><td></td><td id="${location[23].locQtt/location[23].maxQtt ge 0.8 ? 'limit-space' : (location[23].locQtt/location[23].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[23].locArea}")'>${location[23].locArea}</a></span><div id="content"><p>${location[23].locQtt}/${location[23].maxQtt}</p></div></div></td><td id="${location[28].locQtt/location[28].maxQtt ge 0.8 ? 'limit-space' : (location[28].locQtt/location[28].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[28].locArea}")'>${location[28].locArea}</a></span><div id="content"><p>${location[28].locQtt}/${location[28].maxQtt}</p></div></div></td><td></td><td id="${location[33].locQtt/location[33].maxQtt ge 0.8 ? 'limit-space' : (location[33].locQtt/location[33].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[33].locArea}")'>${location[33].locArea}</a></span><div id="content"><p>${location[33].locQtt}/${location[33].maxQtt}</p></div></div></td><td id="${location[38].locQtt/location[38].maxQtt ge 0.8 ? 'limit-space' : (location[38].locQtt/location[38].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[38].locArea}")'>${location[38].locArea}</a></span><div id="content"><p>${location[38].locQtt}/${location[38].maxQtt}</p></div></div></td><td id="${location[43].locQtt/location[43].maxQtt ge 0.8 ? 'limit-space' : (location[43].locQtt/location[43].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[43].locArea}")'>${location[43].locArea}</a></span><div id="content"><p>${location[43].locQtt}/${location[43].maxQtt}</p></div></div></td><td></td></tr>
   <tr><td id="${location[1].locQtt/location[1].maxQtt ge 0.8 ? 'limit-space' : (location[1].locQtt/location[1].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=3 rowspan=3><a href="#" onclick='updateQtt("${location[1].locArea}")'>${location[1].locArea}</a><br/>${location[1].locQtt}/${location[1].maxQtt}</td><td></td><td></td><td></td><td id="${location[24].locQtt/location[24].maxQtt ge 0.8 ? 'limit-space' : (location[24].locQtt/location[24].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[24].locArea}")'>${location[24].locArea}</a></span><div id="content"><p>${location[24].locQtt}/${location[24].maxQtt}</p></div></div></td><td id="${location[29].locQtt/location[29].maxQtt ge 0.8 ? 'limit-space' : (location[29].locQtt/location[29].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[29].locArea}")'>${location[29].locArea}</a></span><div id="content"><p>${location[29].locQtt}/${location[29].maxQtt}</p></div></div></td><td></td><td id="${location[34].locQtt/location[34].maxQtt ge 0.8 ? 'limit-space' : (location[34].locQtt/location[34].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[34].locArea}")'>${location[34].locArea}</a></span><div id="content"><p>${location[34].locQtt}/${location[34].maxQtt}</p></div></div></td><td id="${location[39].locQtt/location[39].maxQtt ge 0.8 ? 'limit-space' : (location[39].locQtt/location[39].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[39].locArea}")'>${location[39].locArea}</a></span><div id="content"><p>${location[39].locQtt}/${location[39].maxQtt}</p></div></div></td><td id="${location[44].locQtt/location[44].maxQtt ge 0.8 ? 'limit-space' : (location[44].locQtt/location[44].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[44].locArea}")'>${location[44].locArea}</a></span><div id="content"><p>${location[44].locQtt}/${location[44].maxQtt}</p></div></div></td><td></td><td></td><td></td><td></td></tr>
   <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td id="${location[25].locQtt/location[25].maxQtt ge 0.8 ? 'limit-space' : (location[25].locQtt/location[25].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[25].locArea}")'>${location[25].locArea}</a></span><div id="content"><p>${location[25].locQtt}/${location[25].maxQtt}</p></div></div></td><td id="${location[30].locQtt/location[30].maxQtt ge 0.8 ? 'limit-space' : (location[30].locQtt/location[30].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[30].locArea}")'>${location[30].locArea}</a></span><div id="content"><p>${location[30].locQtt}/${location[30].maxQtt}</p></div></div></td><td></td><td id="${location[35].locQtt/location[35].maxQtt ge 0.8 ? 'limit-space' : (location[35].locQtt/location[35].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[35].locArea}")'>${location[35].locArea}</a></span><div id="content"><p>${location[35].locQtt}/${location[35].maxQtt}</p></div></div></td><td id="${location[40].locQtt/location[40].maxQtt ge 0.8 ? 'limit-space' : (location[40].locQtt/location[40].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[40].locArea}")'>${location[40].locArea}</a></span><div id="content"><p>${location[40].locQtt}/${location[40].maxQtt}</p></div></div></td><td id="${location[45].locQtt/location[45].maxQtt ge 0.8 ? 'limit-space' : (location[45].locQtt/location[45].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[45].locArea}")'>${location[45].locArea}</a></span><div id="content"><p>${location[45].locQtt}/${location[45].maxQtt}</p></div></div></td><td></td><td id="${location[7].locQtt/location[7].maxQtt ge 0.8 ? 'limit-space' : (location[7].locQtt/location[7].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=3 rowspan=2><a href="#" onclick='updateQtt("${location[7].locArea}")'>${location[7].locArea}</a><br/>${location[7].locQtt}/${location[7].maxQtt}</td></tr>
   <tr><td></td><td id="${location[16].locQtt/location[16].maxQtt ge 0.8 ? 'limit-space' : (location[16].locQtt/location[16].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=2><a href="#" onclick='updateQtt("${location[16].locArea}")'>${location[16].locArea}</a><br/>${location[16].locQtt}/${location[16].maxQtt}</td><td id="${location[18].locQtt/location[18].maxQtt ge 0.8 ? 'limit-space' : (location[18].locQtt/location[18].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=2><a href="#" onclick='updateQtt("${location[18].locArea}")'>${location[18].locArea}</a><br/>${location[18].locQtt}/${location[18].maxQtt}</td><td></td><td id="${location[20].locQtt/location[20].maxQtt ge 0.8 ? 'limit-space' : (location[20].locQtt/location[20].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=2><a href="#" onclick='updateQtt("${location[20].locArea}")'>${location[20].locArea}</a><br/>${location[20].locQtt}/${location[20].maxQtt}</td><td id="${location[22].locQtt/location[22].maxQtt ge 0.8 ? 'limit-space' : (location[22].locQtt/location[22].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2 rowspan=2><a href="#" onclick='updateQtt("${location[22].locArea}")'>${location[22].locArea}</a><br/>${location[22].locQtt}/${location[22].maxQtt}</td><td></td><td id="${location[26].locQtt/location[26].maxQtt ge 0.8 ? 'limit-space' : (location[26].locQtt/location[26].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[26].locArea}")'>${location[26].locArea}</a></span><div id="content"><p>${location[26].locQtt}/${location[26].maxQtt}</p></div></div></td><td id="${location[31].locQtt/location[31].maxQtt ge 0.8 ? 'limit-space' : (location[31].locQtt/location[31].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[31].locArea}")'>${location[31].locArea}</a></span><div id="content"><p>${location[31].locQtt}/${location[31].maxQtt}</p></div></div></td><td></td><td id="${location[36].locQtt/location[36].maxQtt ge 0.8 ? 'limit-space' : (location[36].locQtt/location[36].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[36].locArea}")'>${location[36].locArea}</a></span><div id="content"><p>${location[36].locQtt}/${location[36].maxQtt}</p></div></div></td><td id="${location[41].locQtt/location[41].maxQtt ge 0.8 ? 'limit-space' : (location[41].locQtt/location[41].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[41].locArea}")'>${location[41].locArea}</a></span><div id="content"><p>${location[41].locQtt}/${location[41].maxQtt}</p></div></div></td><td id="${location[46].locQtt/location[46].maxQtt ge 0.8 ? 'limit-space' : (location[46].locQtt/location[46].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[46].locArea}")'>${location[46].locArea}</a></span><div id="content"><p>${location[46].locQtt}/${location[46].maxQtt}</p></div></div></td><td></td></tr>
   <tr><td></td><td></td><td></td><td></td><td></td><td></td><td id="${location[27].locQtt/location[27].maxQtt ge 0.8 ? 'limit-space' : (location[27].locQtt/location[27].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[27].locArea}")'>${location[27].locArea}</a></span><div id="content"><p>${location[27].locQtt}/${location[27].maxQtt}</p></div></div></td><td id="${location[32].locQtt/location[32].maxQtt ge 0.8 ? 'limit-space' : (location[32].locQtt/location[32].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=2><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[32].locArea}")'>${location[32].locArea}</a></span><div id="content"><p>${location[32].locQtt}/${location[32].maxQtt}</p></div></div></td><td></td><td id="${location[37].locQtt/location[37].maxQtt ge 0.8 ? 'limit-space' : (location[37].locQtt/location[37].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[37].locArea}")'>${location[37].locArea}</a></span><div id="content"><p>${location[37].locQtt}/${location[37].maxQtt}</p></div></div></td><td id="${location[42].locQtt/location[42].maxQtt ge 0.8 ? 'limit-space' : (location[42].locQtt/location[42].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[42].locArea}")'>${location[42].locArea}</a></span><div id="content"><p>${location[42].locQtt}/${location[42].maxQtt}</p></div></div></td><td id="${location[47].locQtt/location[47].maxQtt ge 0.8 ? 'limit-space' : (location[47].locQtt/location[47].maxQtt ge 0.5 ? 'warn-space' : 'space')}"><div id="dropdown"><span><a href="#" onclick='updateQtt("${location[47].locArea}")'>${location[47].locArea}</a></span><div id="content"><p>${location[47].locQtt}/${location[47].maxQtt}</p></div></div></td><td></td><td></td><td></td><td></td></tr>
   <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td id="${location[6].locQtt/location[6].maxQtt ge 0.8 ? 'limit-space' : (location[6].locQtt/location[6].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=3 rowspan=2><a href="#" onclick='updateQtt("${location[6].locArea}")'>${location[6].locArea}</a><br/>${location[6].locQtt}/${location[6].maxQtt}</tr>
   <tr><td id="prohibit-space" colspan=2 rowspan=3>작업자<br/>휴게실</td><td></td><td id="${location[2].locQtt/location[2].maxQtt ge 0.8 ? 'limit-space' : (location[2].locQtt/location[2].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=3 rowspan=3><a href="#" onclick='updateQtt("${location[2].locArea}")'>${location[2].locArea}</a><br/>${location[2].locQtt}/${location[2].maxQtt}</td><td></td><td></td><td id="${location[3].locQtt/location[3].maxQtt ge 0.8 ? 'limit-space' : (location[3].locQtt/location[3].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=3 rowspan=3><a href="#" onclick='updateQtt("${location[3].locArea}")'>${location[3].locArea}</a><br/>${location[3].locQtt}/${location[3].maxQtt}</td><td></td><td></td><td id="${location[4].locQtt/location[4].maxQtt ge 0.8 ? 'limit-space' : (location[4].locQtt/location[4].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=3 rowspan=3><a href="#" onclick='updateQtt("${location[4].locArea}")'>${location[4].locArea}</a><br/>${location[4].locQtt}/${location[4].maxQtt}</td><td></td><td></td><td id="${location[5].locQtt/location[5].maxQtt ge 0.8 ? 'limit-space' : (location[5].locQtt/location[5].maxQtt ge 0.5 ? 'warn-space' : 'space')}" colspan=3 rowspan=3><a href="#" onclick='updateQtt("${location[5].locArea}")'>${location[5].locArea}</a><br/>${location[5].locQtt}/${location[5].maxQtt}</td><td></td><td></td></tr>
   <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>
   <tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td id="prohibit-space" colspan=3>비품보관공간</td></tr>
</table>
</body>
</html>