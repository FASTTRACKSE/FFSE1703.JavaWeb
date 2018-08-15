<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa Sinh Viên</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center">Sửa sinh viên</h2>
		<form:form class="form-horizontal" action="/SpringCRUD/editsave" method="POST">
			<div class= "form-group">
				<label>Mã Sinh Viên:</label>
				<form:input class= "form-control" type="text" path="maSv"/> <br>
			</div>
			<div class= "form-group">
				<label>Họ tên:</label>
				<form:input class= "form-control" type="text" path="hoTen"/> <br>
			</div>
			<div class= "form-group">
				<label>Năm sinh:</label>
				<form:input class= "form-control" type="number" path="namSinh"/> <br>
			</div>
			<div class= "form-group">
				<label>Quê quán:</label>
				<form:input class= "form-control" type="text" path="queQuan"/> <br>
			</div>
			<div class= "form-group">
				<label>Email:</label>
				<form:input class= "form-control" type="text" path="email"/> <br>
			</div>
			<div class= "form-group">
				<label>Điện thoại:</label>
				<form:input class= "form-control" type="number" path="dienThoai"/> <br>
			</div>
			<div class= "form-group">
				<label>Mã lớp:</label>
				<form:input class= "form-control" type="text" path="maLop"/> <br>
			</div>
			<input class= "btn btn-success" type="submit" value="Lưu" />
		</form:form>
	</div>
</body>
</html>