<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<center>
		<h1>Students Management</h1>
	</center>
	<div align="center">
		<table border="2" width="70%" cellpadding="2">
			<tr>
				<th>ID</th>
				<th>MaSV</th>
				<th>Name</th>
				<th>Class</th>
				<th>Email</th>
				<th>Address</th>
				<th>Age</th>
				<th>Author</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach var="emp" items="${list}">
				<tr>
					<td>${emp.id}</td>
					<td>${emp.masv}</td>
					<td>${emp.name}</td>
					<td>${emp.lop}</td>
					<td>${emp.email}</td>
					<td>${emp.address}</td>
					<td>${emp.age}</td>
					<td>${emp.author}</td>
					<td><a href="editemp/${emp.id}" class="btn btn-success">Edit</a></td>
					<td onclick='return canhbao()'><a href="deleteemp/${emp.id}" class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />		<a href="empform">Add New Students</a>
	</div>
	<script>
		function canhbao() {
			return confirm("Bạn Có Chắc Muốn Xóa Không?");
		}
	</script>
</body>
</html>
