<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật thông tin sinh viên</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 style="text-align: center;">Cập nhật thông tin</h1>
		<form:form action="/Spring_MVCHibernate/update" method="post"
			enctype="multipart/form-data" modelAttribute="student">
			<div>
				<form:input path="id" type="hidden" />
			</div>
			<div class="form-group">
				<label>Mã sinh viên</label>
				<form:input path="Masv" />
			</div>
			<div class="form-group">
				<label>Tên sinh viên</label>
				<form:input path="name" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="name" />
			</div>
			<div class="form-group">
				<label>Tuổi</label>
				<form:input path="age" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="age" />
			</div>
			<div class="form-group">
				<label>Email</label>
				<form:input path="email" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="email" />
			</div>
			<div class="form-group">
				<label>Địa chỉ</label>
				<form:input path="address" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="address" />
			</div>
			<div class="form-group">
				<label><spring:message code="lop" />Lớp Học</label>
				<form:select path="lop" cssClass="form-control">
					<form:option value="">
						<spring:message code="chonlop" />
					</form:option>
					<form:option value="FFSE1701">FFSE1701</form:option>
					<form:option value="FFSE1701">FFSE1702</form:option>
					<form:option value="FFSE1703">FFSE1703</form:option>
					<form:option value="FFSE1704">FFSE1704</form:option>
					<form:option value="FFSE1801">FFSE1801</form:option>
					<form:option value="FFSE1801">FFSE1801</form:option>
					<form:option value="FFSE1803">FFSE1803</form:option>
				</form:select>
				<form:errors path="lop" cssClass="invalid-feedback d-block" />
			</div>
			<div class="form-group">
				<label>giới Tính</label>
				<form:input path="author" cssClass="form-control"></form:input>
				<form:errors style="color:red" path="author" />
			</div>
			<div class="form-group">
				<label>Avatar</label> <input id="upload" type="file"
					class="form-control-file" name="file" />
			</div>
			<div class="row">
				<div class="form-group col-md-4">
					<label>Old avatar</label> <img style="width: 100px; height: 100px;"
						src="<c:url value="/resources/upload/${student.img }" />"
						alt="Old avatar" class="form-control">
					<form:hidden path="img" />
				</div>
				<div class="form-group col-md-4">
					<label>New avatar</label> <img alt="New avatar" src="New avatar"
						class="form=control" id="image">
				</div>
			</div>
			<div class="container">
				<button type="submit" class="btn btn-primary">Submit</button>
				<a href="/Spring_Hibernate/list" class="btn btn-info"
					role="button">Back</a>
			</div>
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