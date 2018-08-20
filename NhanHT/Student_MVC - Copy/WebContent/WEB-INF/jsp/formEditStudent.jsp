<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<h1>Edit Student</h1>

	<form:form method="POST" action="/Student_MVC/edit">
		<form:hidden path="id" />
		<div class="form-group">
			<label>Mã Sinh Viên</label>
			<form:input path="maSv" class="form-control" />
		</div>
		<div class="form-group">
			<label>Tên Sinh Viên</label>
			<form:input path="tenSv" class="form-control" />
		</div>
		<div class="form-group">
			<label>Năm Sinh</label>
			<form:input path="namSinh" class="form-control" />
		</div>
		<div class="form-group">
			<label>Email</label>
			<form:input path="email" class="form-control" />
		</div>
		<div class="form-group">
			<label>Địa Chỉ</label>
			<form:input path="diaChi" class="form-control" />
		</div>
		<div class="form-group">
			<label>Lớp Học</label>
			<form:input path="lopHoc" class="form-control" />
		</div>
		<div class="form-group">
			<td><input class="btn btn-success" type="submit"
				value="Edit Save" />
		</div>
	</form:form>
</body>