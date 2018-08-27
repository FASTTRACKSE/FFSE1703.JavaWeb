<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sinh viên</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="<c:url value="/resources/popper/popper.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
	<h1 style="text-align: center;" >Thêm sinh viên</h1>
		<form:form action="insert" method="POST" enctype="multipart/form-data">
			<div class="form-group">
				<label>Mã sinh viên:</label>
				<form:input class= "form-control" type="text" path="maSV"/> <br>
				<form:errors path="maSV" cssStyle="color: red" />
				<p style="color: red">${mess}</p> 
			</div>
			<div class="form-group">
				<label>Tên sinh viên</label>
				<form:input path="tenSV" cssClass="form-control"></form:input>
				<form:errors path="tenSV" cssClass="form-control"> </form:errors>
				<p style="color: red">${mess}</p> 
			</div>
			<div class="form-group">
				<label>Tuổi</label>
				<form:input path="tuoiSV" cssClass="form-control"></form:input>
				<form:errors path="tuoiSV" cssClass="form-control"> </form:errors>
				<p style="color: red">${mess}</p> 
			</div>
			<div class="form-group">
				<label>Email</label>
				<form:input path="email" cssClass="form-control"></form:input>
				<form:errors path="email" cssClass="form-control"> </form:errors>
			</div>
			<div class="form-group">
				<label>Địa chỉ</label>
				<form:input path="diaChi" cssClass="form-control"></form:input>
				<form:errors path="diaChi" cssClass="form-control"> </form:errors>
				<p style="color: red">${mess}</p> 
			</div>
			<div class="form-group">
				<label>Lớp học</label>
				<form:input path="lop" cssClass="form-control"></form:input>
				<form:errors path="lop" cssClass="form-control"> </form:errors>
				<p style="color: red">${mess}</p> 
			</div>
			
			<div class="form-group">
				<label>Avatar</label> <input id="upload" type="file"
					class="form-control-file" name="file">
			</div>
			<div class="form-group">
				<img id="image" style="width: 100px" alt="Image" src='#'>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
</html>