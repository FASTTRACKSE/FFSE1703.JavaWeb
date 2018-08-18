<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center">Sửa sinh viên</h2>
		<form:form class="form-horizontal" action="/SingVienSpringMVC/editsave" method="POST">
			<div class= "form-group">
				<label>Mã Sinh Viên:</label>
				<form:input class= "form-control" type="text" path="maSv"/> <br>
			</div>
			<div class= "form-group">
				<label>Họ tên:</label>
				<form:input class= "form-control" type="text" path="ten"/> <br>
			</div>
			<div class= "form-group">
				<label>Năm sinh:</label>
				<form:input class= "form-control" type="number" path="namSinh"/> <br>
			</div>
			<div class= "form-group">
				<label>Email:</label>
				<form:input class= "form-control" type="text" path="email"/> <br>
			</div>
			<div class= "form-group">
				<label>Điện thoại:</label>
				<form:input class= "form-control" type="number" path="sdt"/> <br>
			</div>
			<div class= "form-group">
				<label>Địa Chỉ:</label>
				<form:input class= "form-control" type="text" path="diaChi"/> <br>
			</div>
			<div class= "form-group">
				<label>Mã lớp:</label>
				<form:select path="lop" class= "form-control">
					<form:option value="FFSE1701">FFSE1701</form:option>
					<form:option value="FFSE1702">FFSE1702</form:option>
					<form:option value="FFSE1703">FFSE1703</form:option>
					<form:option value="FFSE1704">FFSE1704</form:option>
				</form:select>
			</div>
			<input class= "btn btn-success" type="submit" value="Lưu" />
		</form:form>
	</div>
</body>
</html>