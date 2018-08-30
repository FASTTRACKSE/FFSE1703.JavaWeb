<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=TF-8">
<title >Sinh Viên</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>

<body>
	<h1 style="margin-left: 600px; ">Sinh Viên</h1>
	<table style="width: 60% ; margin-left: 300px" class="table table-bordered">
		<tr >
		
			<th>Tên</th>
			<th>Tuổi</th>
			<th>Lớp</th>
			<th>Địa chỉ</th>
			<th style="width: 25%">Ảnh</th>
			<th>Chức năng</th>
			
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr >
		
				<td>${emp.ten}</td>
				<td>${emp.tuoi}</td>
				<td>${emp.lop}</td>
				<td>${emp.diachi}</td>
				<td><img style="width: 100px" src="<c:url value="/resources/upload/${emp.avatar }" />">
				<td ><a class="btn btn-success" href="/CRUDSpring/editemp/${emp.id}">Sửa </a> <a>&ensp;&ensp;</a>  <a class="btn btn-danger" href="/CRUDSpring/deleteemp/${emp.id}">Xóa</a> </td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<center>
		<c:if test="${pageid > 1}">
			<a href="/CRUDSpring/viewemp/1" >Trang đầu</a>
		</c:if>
		<c:if test="${pageid > 1}">
			<a href="/CRUDSpring/viewemp/${pageid-1}">${pageid-1}</a>
		</c:if>
		<a  href="/CRUDSpring/viewemp/${pageid}">${pageid}</a>
		<c:if test="${pageid < pagetotal}">
			<a  href="/CRUDSpring/viewemp/${pageid+1}">${pageid+1}</a>
		</c:if>
		<c:if test="${pageid < pagetotal}">
			<a href="/CRUDSpring/viewemp/${pagetotal}"">Trang cuối</a>
		</c:if>

	</center>

	<a style="margin-left: 200px" class="btn btn-success" href="/CRUDSpring/empform">Thêm Sinh Viên</a>
</body>
</html>