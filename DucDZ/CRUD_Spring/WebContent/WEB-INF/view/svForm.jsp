<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add New Student</h1>
	<form:form method="post" action="save">
		<table>
			<tr>
				<td>ID :</td>
				<td><form:input path="ma_sv" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="ho_ten" /></td>
			</tr>
			<tr>
				<td>Date :</td>
				<td><form:input path="nam_sinh" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:input path="dia_chi" /></td>
			</tr>
			<tr>
				<td>Class :</td>
				<td><form:input path="lop_hoc" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
	<a href="/CRUD_Spring/">Back Home</a>
</body>
</html>