<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<h1>Edit Employee</h1>
<form:form method="POST" action="/CrudStudents/editsave">
	<table>
		<tr>
			<td></td>
			<td><form:hidden path="id" /></td>
		</tr>
		<tr>
			<td>Masv :</td>
			<td><form:input path="masv" /></td>
		</tr>
		<tr>
			<td>Name :</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Class:</td>
			<td><form:input path="lop" /></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Address:</td>
			<td><form:input path="address" /></td>
		</tr>
		<tr>
			<td>Age :</td>
			<td><form:input path="age" /></td>
		</tr>
		<tr>
			<td>Author :</td>
			<td><form:input path="author" /></td>
		</tr>

		<tr>
			<td></td>
			<td><input type="submit" value="Edit Save" class="btn btn-success"/></td>
			<td><a class="nav-link"
					href="http://localhost:8080/CrudStudents/viewemp"> <i
						class="fa fa-fw fa-area-chart"></i> <span class="nav-link-text">Back</span>
				</a></td>
			
		</tr>
	</table>
</form:form>
</body>
</html>

