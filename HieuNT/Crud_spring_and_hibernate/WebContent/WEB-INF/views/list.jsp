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
body {
	background-color:black;
}
.color {
	background-color: #F08080
}
</style>
<body>


	<h1 style="color: pink;">꧁༺🅴🅼🅿🅻🅾🆈🅴🅴🆂 🅻🅸🆂🆃༻꧂</h1>
	<table width="70%" cellpadding="2" class="table">
		<tr class="color">
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Avatar</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="entities" items="${list}">
			<tr class="color">
				<td>${entities.id}</td>
				<td>${entities.name}</td>
				<td>${entities.email}</td>
				<td>${entities.address}</td>
				<td><img alt="image" style="width: 310px"
					src='<c:url value="/image/${entities.nameFile}"></c:url>'></td>
				<td><a href="/Crud_spring_and_hibernate/getID/${entities.id}"
					class="btn btn-primary">Edit</a></td>
				<td><a href="/Crud_spring_and_hibernate/delete/${entities.id}"
					class="btn btn-primary"
					onclick="if (!confirm('Are you sure you want to delete this student?')) return false">Delete</a></td>
			</tr>
		</c:forEach>
			<center>
		<c:if test="${page >1}">
			<a href="/Crud_spring_and_hibernate/list/1">FIRST</a>
		</c:if>

		<c:if test="${page > 1}">
			<a href="/Crud_spring_and_hibernate/list/${page-1}">${page-1}</a>
		</c:if>

		<a href="/Crud_spring_and_hibernate/list/${page}">${page}</a>

		<c:if test="${page < total}">
			<a href="/Crud_spring_and_hibernate/list/${page+1}">${page+1}</a>
		</c:if>

		<c:if test="${page < total}">
			<a href="/Crud_spring_and_hibernate/list/${total}">LAST</a>
		</c:if>
	</center>
	</table>

	<br />
	<a href="/Crud_spring_and_hibernate/showForm">꧁༺🅰🅳🅳 🅽🅴🆆 🅴🅼🅿🅻🅾🆈🅴🅴༻꧂</a>
</body>
</html>