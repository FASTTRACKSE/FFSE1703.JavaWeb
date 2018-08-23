<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>EDIT</title>
<style type="text/css">
body {
	background-color:black;
}
</style>
</head>
<body>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<h1>꧁༺🅴🅳🅸🆃 🅴🅼🅿🅻🅾🆈🅴🅴༻꧂</h1>

	<form:form method="POST" action="/SpringCRUD/editsave">
		<form:hidden path="id" />
		<div class="form-group">
			<form:input path="name" cssClass="form-control" placeholder="NAME"></form:input>
		</div>
		<div class="form-group">
			<form:input path="address" cssClass="form-control"
				placeholder="ADDRESS"></form:input>
		</div>
		<div class="form-group">
			<form:input path="email" cssClass="form-control" placeholder="EMAIL"></form:input>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
			<button><a href="/SpringCRUD/">HOME</a></button>
		
	</form:form>
</body>
</html>