<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=TF-8">
<title >Sinh Viên</title>
</head>
<body>
	<h1 style="margin-left: 600px; color: red">Sinh Viên</h1>
	<table style="margin-left: 150px;" border="5" width="80%" cellpadding="2">
		<tr style="color:blue;">
		
			<th>Tên</th>
			<th>Tuổi</th>
			<th>Lớp</th>
			<th>Địa chỉ</th>
			<th>Chức năng</th>
			
		</tr>
		<c:forEach var="emp" items="${list}">
			<tr style="color:maroon;">
		
				<td>${emp.ten}</td>
				<td>${emp.tuoi}</td>
				<td>${emp.lop}</td>
				<td>${emp.diachi}</td>
				<td ><a href="/CRUDSpring/editemp/${emp.id}">Sửa </a> <a>&ensp;&ensp;</a>  <a href="/CRUDSpring/deleteemp/${emp.id}">Xóa</a> </td>
				
			</tr>
		</c:forEach>
	</table>
	<br />
	<center>
		<c:if test="${pageid > 1}">
			<a href="/CRUDSpring/viewemp/1" style="color:lime ;">Trang đầu</a>
		</c:if>
		<c:if test="${pageid > 1}">
			<a style="color:red ;" href="/CRUDSpring/viewemp/${pageid-1}">${pageid-1}</a>
		</c:if>
		<a style="color:red ;" href="/CRUDSpring/viewemp/${pageid}">${pageid}</a>
		<c:if test="${pageid < pagetotal}">
			<a style="color:red ;" href="/CRUDSpring/viewemp/${pageid+1}">${pageid+1}</a>
		</c:if>
		<c:if test="${pageid < pagetotal}">
			<a href="/CRUDSpring/viewemp/${pagetotal}"style="color:lime ;">Trang cuối</a>
		</c:if>

	</center>

	<a href="/CRUDSpring/empform">Thêm Sinh Viên</a>
</body>
</html>