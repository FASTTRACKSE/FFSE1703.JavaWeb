<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=TF-8">
<title >Sinh Viên</title>
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h1  color: blue">Sinh Viên</h1>
	<table  border="2" width="80%" cellpadding="2">
		<tr style="color:blue;">
		
			<th>Name</th>
			<th>Address</th>
			<th>Class</th>
			<th>Action</th>
			
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr style="color:maroon;">
		
				<td>${emp.name}</td>
				<td>${emp.address}</td>
				<td>${emp.lop}</td>
				<td ><a href="/SpringMvcCrudExample/editemp/${emp.id}">edit </a> <a>&ensp;&ensp;</a>  <a href="/SpringMvcCrudExample/deleteemp/${emp.id}">delete</a> </td>
				
			</tr>
		</c:forEach>
	</table>
	<br />
	<center>
		<c:if test="${pageid > 1}">
			<a href="/SpringMvcCrudExample/viewemp/1" style="color:lime ;">Trang đầu</a>
		</c:if>
		<c:if test="${pageid > 1}">
			<a style="color:red ;" href="/SpringMvcCrudExample/viewemp/${pageid-1}">${pageid-1}</a>
		</c:if>
		<a style="color:red ;" href="/SpringMvcCrudExample/viewemp/${pageid}">${pageid}</a>
		<c:if test="${pageid < pagetotal}">
			<a style="color:red ;" href="/SpringMvcCrudExample/viewemp/${pageid+1}">${pageid+1}</a>
		</c:if>
		<c:if test="${pageid < pagetotal}">
			<a href="/SpringMvcCrudExample/viewemp/${pagetotal}"style="color:lime ;">Trang cuối</a>
		</c:if>

	</center>

	<a href="/SpringMvcCrudExample/empform">Thêm Sinh Viên</a>
</body>
</html>