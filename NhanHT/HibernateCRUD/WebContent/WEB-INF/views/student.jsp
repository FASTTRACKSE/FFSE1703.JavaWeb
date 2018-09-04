<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<html>
<head>
<title>Student Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body  class="container">
	<h1>Student</h1>
	<br>
	<c:if test="${!empty listStudent}">
		<table width="70%" cellpadding="2" class="table table-hover" >
		<thead>
			<tr>
				<th>Mã Sinh Viên</th>
				<th>Tên Sinh Viên</th>
				<th>Năm Sinh</th>
				<th>Email</th>
				<th>Địa Chỉ</th>
				<th>Lớp Học</th>
				<th>Avatar</th>
				<th>Chức Năng</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${listStudent}">
				<tr>
					<td>${emp.maSv}</td>
					<td>${emp.tenSv}</td>
					<td>${emp.namSinh}</td>
					<td>${emp.email}</td>
					<td>${emp.diaChi}</td>
					<td>${emp.lopHoc}</td>
					<td><img style="width: 80px;" src='<c:url value = "/resources/${emp.avatar }" ></c:url>' alt="image"></td>
					<td><a href="edit/${emp.id}" class="btn btn-danger">Edit</a> <a
						href="remove/${emp.id}" class="btn btn-primary"
						onclick="return confirm('Bạn có muốn xóa sinh viên này?');">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>
		<a href="/HibernateCRUD/add" class="btn btn-success btnSpace">Add
		New Student</a>
		<p style="color: red">Page ${page}</p>
	<ul class="pagination">
		<c:if test="${page > 1}">
			<li><a href="/HibernateCRUD/1">Trang Đầu</a></li>
			<li><a href="/HibernateCRUD/${page-1}">${page-1}</a></li>
		</c:if>
		<li><a style="color: black;" href="">${page}</a></li>
		<c:if test="${page < total}">
			<li><a href="/HibernateCRUD/${page+1}">${page+1}</a></li>
			<li><a href="/HibernateCRUD/${total}">Trang Cuối</a></li>
		</c:if>
		
</body>
</html>