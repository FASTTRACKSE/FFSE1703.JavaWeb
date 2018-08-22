<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h1>Add New Student</h1>
	<form:form method="post" action="save" modelAttribute="command"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID :</td>
				<td><form:input path="ma_sv" /> <form:errors path="ma_sv"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input path="ho_ten" /> <form:errors path="ho_ten"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Date :</td>
				<td><form:input path="nam_sinh" /> <form:errors
						path="nam_sinh" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /> <form:errors path="email"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:input path="dia_chi" /> <form:errors path="dia_chi"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>Class :</td>
				<td><form:input path="lop_hoc" /> <form:errors path="lop_hoc"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td>File:</td>
				<td><form:input type="file" path="myImage" />
				</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:input path="" type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
	<a href="/CRUD_Spring/">Back Home</a>
</body>
</html>