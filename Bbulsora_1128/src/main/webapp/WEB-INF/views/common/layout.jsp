<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${contextPath}/resources/css/refer_color.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/resources/css/refer_a.css" type="text/css">
<link rel="stylesheet" href="${contextPath}/resources/css/refer_table.css" type="text/css">
<style type="text/css">
body {
	margin: 0px; 
}
#container {
  width: 100%;
  margin: 0px auto;
  text-align:left;
  border: 0px solid #bcbcbc;
}
#header {
  padding: 0px;
  margin-bottom: 0px;
}
#ali_right{
	float:right;
}
#content {
  width: 100%;
  margin-top: 10%;
  padding: 0px;
  border: 0px solid #bcbcbc;
}
#footer {
  clear: both;
  padding: 5px;
  border: 0px solid #bcbcbc;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

const loginCheck = function(){
	if (${user eq null}) {
		location.href = "${contextPath}";
	}
}
window.onpageshow = function(event) {
	if (event.persisted || (window.performance && window.performance.navigation.type == 2)) {
		location.reload();
	}
}

</script>
<title><tiles:insertAttribute name="title" /></title>
</head>
<body onload="loginCheck()">
   <div id="container">
     <div id="header" class="main_color">
        <tiles:insertAttribute name="header"/>
     </div>
     <div style="height: 600px; width: 100%; overflow: auto;" id="content" >
         <tiles:insertAttribute name="body"/>
     </div>
     <div id="footer" class="dim1">
         <tiles:insertAttribute name="footer"/>
     </div>
   </div>
</body>
</html>