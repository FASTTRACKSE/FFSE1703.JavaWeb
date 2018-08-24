<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student List</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>
<body>
	<h1>Student List</h1>
	<table class="table" >
	
		<tr>
			<th scope="col">Id</th>
			<th scope="col">Mã Sinh Viên</th>
			<th>Tên Sinh Viên</th>
			<th>Năm Sinh</th>
			<th>Email</th>
			<th>Địa Chỉ</th>
			<th>Lớp Học</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="emp" items="${listsv}">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.maSV}</td>
				<td>${emp.tenSV}</td>
				<td>${emp.namSinh}</td>
				<td>${emp.email}</td>
				<td>${emp.diaChi}</td>
				<td>${emp.lopHoc}</td>
				<td><img style="width: 100px" src="<c:url value="/resources/upload/${emp.avatar }" />">
				<td><a href="/CRUDSinhVien/editemp/${emp.id}">Edit</a></td>
				<td><a href="/CRUDSinhVien/deleteemp/${emp.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<center>
	<c:if test="${pageid > 1}"><a href="/CRUDSinhVien/viewemp/1">First</a></c:if>
	<c:if test="${pageid > 1}"><a href="/CRUDSinhVien/viewemp/${pageid-1}">${pageid-1}</a></c:if>
	<a href="/CRUDSinhVien/viewemp/${pageid}">${pageid}</a>
	<c:if test="${pageid < pagetotal}"><a href="/CRUDSinhVien/viewemp/${pageid+1}">${pageid+1}</a></c:if>
	<c:if test="${pageid < pagetotal}"><a href="/CRUDSinhVien/viewemp/${pagetotal}">Last</a></c:if>
	
	</center>
	<a href="/CRUDSinhVien/empform">Add New Student</a>
</body>
</html>