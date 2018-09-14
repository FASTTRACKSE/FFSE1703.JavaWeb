<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script
	src="<c:url value="/resources/jquery/jquery-3.3.1.slim.min.js" />"></script>
<script src="<c:url value="/resources/popper/popper.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<form:form action="/Hibernate_Pagination/update" method="POST"
			enctype="multipart/form-data">
			<form:hidden path="id" />
			<div class="form-group">
				<label><spring:message code="id" /></label>
				<form:input path="ho_ten" cssClass="form-control"></form:input>
				<form:errors path="ho_ten" cssClass="invalid-feedback d-block" />
			</div>
			<div class="form-group">
				<label><spring:message code="nam_sinh" /></label>
				<form:input path="nam_sinh" cssClass="form-control"></form:input>
				<form:errors path="nam_sinh" cssClass="invalid-feedback d-block" />
			</div>
			<div class="form-group">
				<label><spring:message code="email" /></label>
				<form:input path="email" cssClass="form-control"></form:input>
				<form:errors path="email" cssClass="invalid-feedback d-block" />
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
				<spring:message code="save" />
			</button>
			<a href="<c:url value ="/"/>" class="btn btn-primary"><spring:message
					code="back" /></a>
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
