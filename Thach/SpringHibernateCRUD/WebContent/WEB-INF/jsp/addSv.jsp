<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<style type="text/css">
.btnWidth {
	width: 80px;
}
</style>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center"><spring:message code="add" /></h2>
		<form:form class="form-horizontal" action="/SpringHibernateCRUD/addSave"
			enctype="multipart/form-data" modelAttribute="command">
			<div class="form-group">
				<label><spring:message code="codestudent" />:</label>
				<form:input class="form-control" type="text" path="maSv" />
				<form:errors path="maSv" cssStyle="color: red" />
				<p style="color: red">${mess}</p>
			</div>
			<div class="form-group">
				<label><spring:message code="fullname" />:</label>
				<form:input class="form-control" type="text" path="ten" />
				<form:errors path="ten" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label><spring:message code="birthyear" />:</label>
				<form:input class="form-control" type="number" path="namSinh" />
				<form:errors path="namSinh" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label><spring:message code="email" />:</label>
				<form:input class="form-control" type="text" path="email" />
				<form:errors path="email" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label><spring:message code="phone" />:</label>
				<form:input class="form-control" type="number" path="sdt" />
				<form:errors path="sdt" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label><spring:message code="address" />:</label>
				<form:input class="form-control" type="text" path="diaChi" />
				<form:errors path="diaChi" cssStyle="color: red" />
			</div>
			<div class="form-group">
				<label><spring:message code="class" />:</label>
				<form:select path="lop" class="form-control">
					<form:option value="FFSE1701">FFSE1701</form:option>
					<form:option value="FFSE1702">FFSE1702</form:option>
					<form:option value="FFSE1703">FFSE1703</form:option>
					<form:option value="FFSE1704">FFSE1704</form:option>
				</form:select>
				<div class="form-group">
					<label><spring:message code="avatar" />:</label> <input id="imgUrl" class="form-control"
						type="file" name="file"></input> <img id="img" src="#"
						alt="your image" width="100" height="150" />
					<form:errors path="hinhAnh" cssStyle="color: red" />
				</div>
			</div>
			<div class="form-group">

				<div class="col-sm-4">
					<div>
						<input class="btn btn-success" type="submit" value="<spring:message code="save" />" />
					</div>
				</div>
			</div>
		</form:form>
		<a href="/SpringHibernateCRUD/"><button class="btn btn-primary"><spring:message code="liststudent" /></button></a>
		<script>
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
	</div>

</body>
</html>