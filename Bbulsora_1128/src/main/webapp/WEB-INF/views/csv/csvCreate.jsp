<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Company Info</title>
</head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
<script src="https://malsup.github.io/jquery.form.js"></script> 
<script type="text/javascript">
	
	function checkFileType(filepath) {
		var fileFormat = filepath.split(".");
		if(fileFormat.indexOf("csv") > -1) {
			return true;
		} else {
			return false;
		}
	}
	function check() {
		var file = $("#csvFile").val();
		if(file == "" || file == null) {
			alert("파일을 선택하세요");
			return false;
		} else if(!checkFileType(file)) {
			alert("지원하지 않는 파일형식입니다")
			return false;
		}
		if(confirm("업로드 하시겠습니까?")) {
			var options = {
					success : function(data) {
						console.log(data);
						alert("업로드 성공");
						location.replace("${contextPath}/csv/list.do");
					},
				type : "POST"	
			};
			console.log(options)
			$("#csvUploadForm").ajaxSubmit(options);
			
		}
	}
</script>
<body>
<form id="csvUploadForm" action="create.do" name="csvUploadForm" enctype="multipart/form-data" method="post">
	<div class="contents">
	<div>첨부파일은 하나만 등록 가능합니다.</div>
	
	<dl class="vm_name">
		<dt class="down w90">첨부파일</dt>
		<dd><input id="csvFile" type="file" name="csvFile" /></dd>
	</dl>
	</div>
	<div class="bottom">
		<button type="button" id="addCsvImportBtn" class="btn" onclick="check()"><span>추가</span></button>
	</div>
</form>
</body>
</html>