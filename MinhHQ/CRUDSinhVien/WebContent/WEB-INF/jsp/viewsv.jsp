<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student List</title>
</head>
<body>
	<h1>Student List</h1>
	<table border="2" width="70%" cellpadding="2">
		<tr>
			<th>Id</th>
			<th>MaSV</th>
			<th>TenSV</th>
			<th>NamSinh</th>
			<th>Email</th>
			<th>DiaChi</th>
			<th>LopHoc</th>
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
				<td><a href="/CRUDSinhVien/editemp/${emp.id}">Edit</a></td>
				<td><a href="/CRUDSinhVien/deleteemp/${emp.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<center>
	<c:if test="${pageid > 1}"><a href="/CRUDSinhVien/viewsv/1">First</a></c:if>
	<c:if test="${pageid > 1}"><a href="/CRUDSinhVien/viewsv/${pageid-1}">${pageid-1}</a></c:if>
	<a href="/CRUDSinhVien/viewsv/${pageid}">${pageid}</a>
	<c:if test="${pageid < pagetotal}"><a href="/CRUDSinhVien/viewsv/${pageid+1}">${pageid+1}</a></c:if>
	<c:if test="${pageid < pagetotal}"><a href="/CRUDSinhVien/viewsv/${pagetotal}">Last</a></c:if>	
	</center>
	<a href="/CRUDSinhVien/empform">Add New Student</a>
	<a href="/CRUDSinhVien/">Back Home</a>
</body>
</html>