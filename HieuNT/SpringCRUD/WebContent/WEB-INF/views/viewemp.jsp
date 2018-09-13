<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:h="http://xmlns.jcp.org/jsf/html"
	xmlns:f="http://xmlns.jcp.org/jsf/core">
<head>
<meta>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>View List</title>
</head>
<style>


.color {
	background-color: #F08080
}
</style>
<body background="<c:url value='/resources/image/jisoo-1.jpg' />">


	<h1 style="color: pink;">꧁༺🅴🅼🅿🅻🅾🆈🅴🅴🆂 🅻🅸🆂🆃༻꧂</h1>
	<table width="70%" cellpadding="2" class="table">
		<tr class="color">
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Email</th>
			<th>Avatar</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr class="color">
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.address}</td>
				<td>${emp.email}</td>
				<td><img alt="image" style="width: 310px"
					src='<c:url value="/image/${emp.nameFile}"></c:url>'></td>
				<td><a href="/SpringCRUD/editemp/${emp.id}"
					class="btn btn-primary">Edit</a></td>
				<td><a href="/SpringCRUD/deleteemp/${emp.id}"
					class="btn btn-primary"
					onclick="if (!confirm('Are you sure you want to delete this student?')) return false">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<center>
		<c:if test="${pageid>1}">
			<a href="/SpringCRUD/viewemp/1">FIRST</a>
		</c:if>

		<c:if test="${pageid > 1}">
			<a href="/SpringCRUD/viewemp/${pageid-1}">${pageid-1}</a>
		</c:if>

		<a href="/SpringCRUD/viewemp/${pageid}">${pageid}</a>

		<c:if test="${pageid < pagetotal}">
			<a href="/SpringCRUD/viewemp/${pageid+1}">${pageid+1}</a>
		</c:if>

		<c:if test="${pageid<pagetotal}">
			<a href="/SpringCRUD/viewemp/${pagetotal}">LAST</a>
		</c:if>
	</center>
	<br />
	<a href="/SpringCRUD/empform">꧁༺🅰🅳🅳 🅽🅴🆆 🅴🅼🅿🅻🅾🆈🅴🅴༻꧂</a>
</body>
</html>