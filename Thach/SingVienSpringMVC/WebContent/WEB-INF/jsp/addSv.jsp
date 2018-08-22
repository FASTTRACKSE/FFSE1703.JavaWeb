<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.btnWidth {
	width: 80px;
}
</style>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center">Thêm sinh viên</h2>
		<form:form class="form-horizontal" action="/SingVienSpringMVC/addSave"
			modelAttribute="command">
			<div class="form-group">
				<label>Mã sinh viên:</label>
				<form:input class="form-control" type="text" path="maSv" />
				<form:errors path="maSv" cssStyle="color: red" />
				<p style="color: red">${mess}</p> 
			</div>
			<div class="form-group">
				<label>Họ tên:</label>
				<form:input class="form-control" type="text" path="ten" />
				<form:errors path="ten" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label>Năm Sinh:</label>
				<form:input class="form-control" type="number" path="namSinh" />
				<form:errors path="namSinh" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label>Email:</label>
				<form:input class="form-control" type="text" path="email" />
				<form:errors path="email" cssStyle="color: red" /> 
			</div>
			<div class="form-group">
				<label>Điện thoại:</label>
				<form:input class="form-control" type="number" path="sdt" />
				<form:errors path="sdt" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label>Địa Chỉ:</label>
				<form:input class="form-control" type="text" path="diaChi" />
				<form:errors path="diaChi" cssStyle="color: red" /> 
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
			<div class="form-group">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<div class="col-sm-2">
						<input class="btn btn-success" type="submit" value="Lưu" />
					</div>
					<div class="col-sm-1"></div>
					<div class="col-sm-2">
						
					</div>
				</div>
			</div>
		</form:form>
		<a href="/SingVienSpringMVC/"><button class="btn btn-primary" />Quay lại danh sách</button></a>
	</div>
</body>
</html>