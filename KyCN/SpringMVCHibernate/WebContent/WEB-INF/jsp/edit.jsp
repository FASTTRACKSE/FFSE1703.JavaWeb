<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật thông tin</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script
	src="<c:url value="/resources/jquery/jquery-3.3.1.slim.min.js" />"></script>
<script src="<c:url value="/resources/popper/popper.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<h1 style="text-align: center;">Cập nhật thông tin</h1>
		<form:form action="/SpringMVCHibernate/update" method="post" enctype="multipart/form-data" modelAttribute="sinhvien" >
		<div>
		<form:input path="id"  />
		</div>
		<div class="form-group">
		<label>Mã sinh viên</label>
		<form:input path="masv" type="hidden" />
		</div>
			<div class="form-group">
				<label>Tên sinh viên</label>
				<form:input path="tensv" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="tensv"/>
			</div>
			<div class="form-group">
				<label>Tuổi</label>
				<form:input path="tuoisv" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="tuoisv"/>
			</div>
			<div class="form-group">
				<label>Email</label>
				<form:input path="email" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="email"/>
			</div>
			<div class="form-group">
				<label>Địa chỉ</label>
				<form:input path="diachi" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="diachi"/>
			</div>
			<div class="form-group">
				<label>Lớp học</label>
				<form:input path="lop" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="lop"/>
			</div>
			<div class="form-group">
				<label>Avatar</label>
				<input id="upload" type="file" class="form-control-file" name="file" />
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label>Old avatar</label> 
					<img style="width: 100px; height: 100px;"  src="<c:url value="/resources/upload/${sinhvien.avatar }" />" alt="Old avatar" class="form-control">
					<form:hidden path="avatar" />
					</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
	</div>
</body>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#image').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	$("#upload").change(function() {
		readURL(this);
	});
</script>
</html>