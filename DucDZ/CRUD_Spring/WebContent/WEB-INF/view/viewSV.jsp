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
	<h1>Student List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Date</th>
			<th>Email</th>
			<th>Address</th>
			<th>Class</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="sv" items="${listsv}">
			<tr>
				<td>${sv.ma_sv}</td>
				<td>${sv.ho_ten}</td>
				<td>${sv.nam_sinh}</td>
				<td>${sv.email}</td>
				<td>${sv.dia_chi}</td>
				<td>${sv.lop_hoc}</td>
				<td><a href="editForm/${sv.ma_sv}">Edit</a></td>
				<td><a href="deleteSV/${sv.ma_sv}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="svForm">Add New Student</a>
	<a href="/CRUD_Spring/">Back Home</a>
</body>
</html>