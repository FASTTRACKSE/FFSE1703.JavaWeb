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
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center">Thêm sinh viên</h2>
		<form:form class="form-horizontal" action="/SpringCRUDHibernate/addSave"
			enctype="multipart/form-data" modelAttribute="command">
			<div class="form-group">
				<label>Mã sinh viên:</label>
				<form:input class="form-control" type="text" path="maSv" />
				<br>
				<form:errors path="maSv" cssStyle="color: red" />
				<p style="color: red">${mess}</p>
			</div>
			<div class="form-group">
				<label>Họ tên:</label>
				<form:input class="form-control" type="text" path="hoTen" />
				<br>
				<form:errors path="hoTen" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label>Năm sinh:</label>
				<form:input class="form-control" type="number" path="namSinh" />
				<br>
				<form:errors path="namSinh" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label>Quê quán:</label>
				<form:input class="form-control" type="text" path="queQuan" />
				<br>
				<form:errors path="queQuan" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label>Email:</label>
				<form:input class="form-control" type="text" path="email" />
				<br>
				<form:errors path="email" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label>Điện thoại:</label>
				<form:input class="form-control" type="number" path="dienThoai" />
				<br>
				<form:errors path="dienThoai" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label>Mã lớp:</label>
				<form:select path="maLop" class="form-control">
					<form:option value="FFSE1701">FFSE1701</form:option>
					<form:option value="FFSE1702">FFSE1702</form:option>
					<form:option value="FFSE1703">FFSE1703</form:option>
					<form:option value="FFSE1704">FFSE1704</form:option>
				</form:select>
			</div>
			<div class="form-group">
				<label>Hình Ảnh:</label> 
				<input id="imgUrl" class="form-control"
					type="file" name="file" /> <br> 
					<img id="img" src="#" alt="your image" width="100" height="150" />
				<form:errors path="hinhAnh" cssStyle="color: red" />

			</div>
			<input class="btn btn-success" type="submit" value="Lưu" />
		</form:form>
	</div>

	<script type="text/javascript">
		function readURL(input) {

			if (input.files && input.files[0]) {
				var reader = new FileReader();

				reader.onload = function(e) {
					$('#img').attr('src', e.target.result);
				}

				reader.readAsDataURL(input.files[0]);
			}
		}

		$("#imgUrl").change(function() {
			readURL(this);
		});
	</script>
</body>
</html>