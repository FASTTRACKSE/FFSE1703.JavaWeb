<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh Sách Sinh Viên</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<h1>Sinh Viên</h1>
	<table border="2" width="70%" cellpadding="2"
		class="table table-striped table-hover table-bordered tableUpdated">
		<tr>
			<th>Mã Sinh Viên</th>
			<th>Tên Sinh Viên</th>
			<th>Năm Sinh</th>
			<th>Email</th>
			<th>Địa Chỉ</th>
			<th>Lớp Học</th>
			<th>Chức Năng</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr>
				<td>${emp.maSv}</td>
				<td>${emp.tenSv}</td>
				<td>${emp.namSinh}</td>
				<td>${emp.email}</td>
				<td>${emp.diaChi}</td>
				<td>${emp.lopHoc}</td>
				<td><a href="edit/${emp.id}" class="btn btn-danger">Edit</a>
				<a href="delete/${emp.id}" class="btn btn-primary"  onclick="return confirm('Bạn có muốn xóa sinh viên này?');">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="formStudent" class="btn btn-success btnSpace">Add New Student</a>

</body>
</html>