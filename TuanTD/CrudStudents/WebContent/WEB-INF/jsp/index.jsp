<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Spring CRUD Example</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
					<td><a href="/CrudStudents/editemp/${emp.id}" class="btn btn-success">Edit</a></td>
					<td onclick='return canhbao()'><a href="/CrudStudents/deleteemp/${emp.id}" class="btn btn-danger">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br />		<a href="/CrudStudents/empform">Add New Students</a>
	</div>
	<br/>   

   <div class="container">                 
   <p>${totalPage}</p>

<c:if test="${pageIndex > 1}">
	<a href="1">first</a>
	<a href="${pageIndex - 1}"> <button class="btn btn-default">${pageIndex - 1}</button></a>
</c:if>

<a href="${pageIndex}"><button class="btn btn-success">${pageIndex}</button></a>

<c:if test="${pageIndex < totalPage}">
	<a href="${pageIndex + 1}"><button class="btn btn-default">${pageIndex + 1}</button></a>
	<a href="${totalPage}">last</a>
</c:if>

</div>
	<script>
		function canhbao() {
			return confirm("Bạn Có Chắc Muốn Xóa Không?");
		}
	</script>
</body>
</html>


