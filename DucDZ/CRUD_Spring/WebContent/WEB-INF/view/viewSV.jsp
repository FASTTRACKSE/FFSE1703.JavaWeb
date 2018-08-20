<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"
	xmlns:ui="http://xmlns.jcp.org/jsf/facelets"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:f="http://xmlns.jcp.org/jsf/core">
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
				<td><a href="/CRUD_Spring/editForm/${sv.ma_sv}">Edit</a></td>
				<td><a href="/CRUD_Spring/deleteSV/${sv.ma_sv}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<center>
	<c:if test="${pageid > 1}"><a href="/CRUD_Spring/viewSV/1">First</a></c:if>
	<c:if test="${pageid > 1}"><a href="/CRUD_Spring/viewSV/${pageid-1}">${pageid-1}</a></c:if>
	<a href="/CRUD_Spring/viewSV/${pageid}">${pageid}</a>
	<c:if test="${pageid < pagetotal}"><a href="/CRUD_Spring/viewSV/${pageid+1}">${pageid+1}</a></c:if>
	<c:if test="${pageid < pagetotal}"><a href="/CRUD_Spring/viewSV/${pagetotal}">Last</a></c:if>
	
	</center>
	<a href="/CRUD_Spring/svForm">Add New Student</a>
	<a href="/CRUD_Spring/">Back Home</a>
</body>
</html>