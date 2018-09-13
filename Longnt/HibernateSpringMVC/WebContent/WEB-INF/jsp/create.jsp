<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sinh viên</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="<c:url value="/resources/popper/popper.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
	<h1 style="text-align: center;" ><spring:message code="addsv" /></h1>
			<form:form action="create" method="POST" enctype="multipart/form-data" modelAttribute="student">
			<div class="form-group">
				<label><spring:message code="updateMSV" /></label>
				<form:input class= "form-control" type="text" path="masv"/>
				<form:errors style="color:red" path="masv"/>
			</div>
			<div class="form-group">
				<label><spring:message code="updatetSV" /></label>
				<form:input path="tensv" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="tensv"/>
			</div>
			<div class="form-group">
				<label><spring:message code="updatetSV" /></label>
				<form:input path="tuoisv" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="tuoisv"/>
			</div>
			<div class="form-group">
				<label><spring:message code="updateE" /></label>
				<form:input path="email" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="email"/>
			</div>
			<div class="form-group">
				<label><spring:message code="updateDC" /></label>
				<form:input path="diachi" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="diachi"/>
			</div>
			<div class="form-group">
				<label><spring:message code="updateL" /></label>
				<form:input path="lop" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="lop"/>
			</div>
			<div class="form-group">
				<label>Avatar</label> <input id="upload" type="file"
					class="form-control-file" name="file">
			</div>
			<div class="form-group">
				<img id="image" style="width: 100px; height:100px" alt="Image" src='#'>
			</div>
			<button type="submit" class="btn btn-primary"><spring:message code="luu" /></button>
		</form:form>
	</div>
</body>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#image').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	$("#upload").change(function() {
		readURL(this);
	});
</script>
</html>