<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Student</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
</head>
<body>
	<h1>Edit Student</h1>
	<form:form method="POST" action="/CRUDSinhVien/editsave" enctype="multipart/form-data">
		<table class="table table-sm">
			<tr>
				<td></td>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td>MaSV :</td>
				<td><form:input path="maSV" /></td>
			</tr>
			<tr>
				<td>TenSV :</td>
				<td><form:input path="tenSV" /></td>
				
			</tr>
			<tr>
				<td>NamSinh :</td>
				<td><form:input path="namSinh" /></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>DiaChi :</td>
				<td><form:input path="diaChi" /></td>
			</tr>
			<tr>
				<td>LopHoc :</td>
				<td><form:input path="lopHoc" /></td>
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
				<td><input class="btn btn-success" type="submit" value="Edit Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>