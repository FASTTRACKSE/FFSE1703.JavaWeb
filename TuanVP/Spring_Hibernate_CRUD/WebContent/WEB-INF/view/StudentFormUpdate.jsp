<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="title3" /></title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script
	src="<c:url value="/resources/jquery/jquery-3.3.1.slim.min.js" />"></script>
<script src="<c:url value="/resources/popper/popper.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<h1 style="text-align: center;">
			<spring:message code="title3" />
		</h1>
		<form:form action="/Spring_Hibernate_CRUD/update" method="POST"
			enctype="multipart/form-data">
			<form:hidden path="maSV" />
			<div class="form-group">
				<label><spring:message code="tensv" /></label>
				<form:input path="tenSV" cssClass="form-control"></form:input>
				<form:errors path="tenSV" cssClass="invalid-feedback d-block" />
			</div>
			<div class="form-group">
				<label><spring:message code="namsinh" /></label>
				<form:input path="namSinh" cssClass="form-control"></form:input>
				<form:errors path="namSinh" cssClass="invalid-feedback d-block" />
			</div>
			<div class="form-group">
				<label><spring:message code="email" /></label>
				<form:input path="email" cssClass="form-control"></form:input>
				<form:errors path="email" cssClass="invalid-feedback d-block" />
			</div>
			<div class="form-group">
				<label><spring:message code="diachi" /></label>
				<form:input path="diaChi" cssClass="form-control"></form:input>
				<form:errors path="diaChi" cssClass="invalid-feedback d-block" />
			</div>
			<div class="form-group">
				<label><spring:message code="lophoc" /></label>
				<form:select path="lopHoc" cssClass="form-control">
					<form:option value="">
						<spring:message code="chonlop" />
					</form:option>
					<form:option value="FFSE1701">FFSE1701</form:option>
					<form:option value="FFSE1701">FFSE1702</form:option>
					<form:option value="FFSE1703">FFSE1703</form:option>
					<form:option value="FFSE1704">FFSE1704</form:option>
					<form:option value="FFSE1801">FFSE1801</form:option>
					<form:option value="FFSE1801">FFSE1801</form:option>
					<form:option value="FFSE1803">FFSE1803</form:option>
				</form:select>
				<form:errors path="lopHoc" cssClass="invalid-feedback d-block" />
			</div>
			<div class="form-group">
				<label>Avatar</label> <input id="upload" type="file"
					class="form-control-file" name="file" />
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label>Old avatar</label> <img
						src="<c:url value="/resources/upload/${command.avatar }" />"
						alt="Old avatar" class="form-control">
					<form:hidden path="avatar" />
				</div>
				<div class="form-group col-md-4">
					<label>New avatar</label> <img id="image" src="#" alt="New avatar"
						class="form-control">
				</div>
			</div>
			<button type="submit" class="btn btn-success">
				<spring:message code="luu" />
			</button>
			<a href="<c:url value ="/"/>" class="btn btn-primary"><spring:message
					code="trove" /></a>
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