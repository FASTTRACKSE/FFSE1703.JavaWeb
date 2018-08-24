<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Fastrack SE</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 style="text-align: center;">Chỉnh sửa sinh viên</h1>
		<form:form method="post" action="/CrudSpring/editStudent">
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Code:</label>
				<div class="col-sm-10">
					<form:input path="code" class="form-control" id="email"
						readonly="true" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Name:</label>
				<div class="col-sm-10">
					<form:errors path="name" cssClass="error" />
					<form:input path="name" class="form-control" id="email" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">BirthYear:</label>
				<div class="col-sm-10">
					<form:errors path="birthYear" cssClass="error" />
					<form:input path="birthYear" class="form-control" id="email" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Email:</label>
				<div class="col-sm-10">
					<form:errors path="email" cssClass="error" />
					<form:input path="email" class="form-control" id="email" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">Address:</label>
				<div class="col-sm-10">
					<form:errors path="address" cssClass="error" />
					<form:input path="address" class="form-control" id="email" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="email">Class:</label>
				<div class="col-sm-10">
					<form:errors path="classSv" cssClass="error" />
					<form:select path="classSv">
						<form:option value="" label="select" />
						<form:option value="FFSE1701" label="FFSE1701" />
						<form:option value="FFSE1702" label="FFSE1702" />
						<form:option value="FFSE1703" label="FFSE1703" />
						<form:option value="FFSE1704" label="FFSE1704" />
					</form:select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" value="Save" />
				</div>
			</div>
		</form:form>
	</div>

</body>
</html>