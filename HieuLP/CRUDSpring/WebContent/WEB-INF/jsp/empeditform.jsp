<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sinh Viên</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>
<body>
	<h1>Sửa Sinh Viên</h1>
	<form:form method="POST" action="/CRUDSpring/editsave" enctype="multipart/form-data">
		<table class="table table-sm">
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>Tên :</td>
				<td><form:input path="ten" /></td>
			</tr>
			<tr>
				<td>Tuổi :</td>
				<td><form:input path="tuoi" /></td>
			</tr>
			<tr>
				<td>Lớp :</td>
				<td><form:input path="lop" /></td>
			</tr>
			<tr>
				<td>Địa chỉ :</td>
				<td><form:input path="diachi" /></td>
			</tr>
		
			<tr>
			<td>Ảnh cũ</td>
			<td><img style="width: 100px" src="<c:url value="/resources/upload/${command.avatar }" />">
			</td>
				<tr>
				<td>Ảnh:</td>
				<td><input type="file" name="file" /></td>
				<td><form:hidden path="avatar" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input class="btn btn-success" type="submit" value="Lưu" /> <a>&ensp;&ensp;</a> 
				<a class="btn btn-success" href="/CRUDSpring/viewemp/1">Quay lại</a></td>

			</tr>
		</table>
	</form:form>
</body>
</html>