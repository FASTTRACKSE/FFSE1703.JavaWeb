<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${lang}" />
<fmt:setBundle basename="javaweb.resources.${lang}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Edit Student</title>
</head>
<body>
	<div class="container">
		<h2 style="text-align: center;"><fmt:message key="title_up"/></h2>
		<form action="update?lang=${lang}" method="post" name="myForm">
			<div class="form-group">
				<label><fmt:message key="code"/></label> <input type="text" class="form-control"
					name="code" placeholder="Mã sinh viên"
					value="<c:out value='${Student.code}' />">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1"><fmt:message key="name"/></label> <input type="text"
					class="form-control" name="name" placeholder="Tên sinh viên"
					value="<c:out value='${Student.name}' />">
			</div>

			<div class="form-group">
				<label for="exampleInputPassword1"><fmt:message key="age"/></label> <input type="text"
					class="form-control" name="age" placeholder="Tuổi sinh viên"
					value="<c:out value='${Student.age}' />">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1"><fmt:message key="class"/></label> <input type="text"
					class="form-control" name="class" placeholder="Lớp sinh viên"
					value="<c:out value='${Student.classSt}' />">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1"><fmt:message key="sex"/></label> <br> <input
					type="radio" name="sex" id="Nam" value="Nam" checked="checked">Nam<br> <input
					type="radio" name="sex" id="Nu" value="Nữ">Nữ
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1"><fmt:message key="country"/></label> <input
					type="text" class="form-control" name="country"
					placeholder="Quê quán sinh viên"
					value="<c:out value='${Student.country}' />">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">lp1</label> <input
					type="number" class="form-control" name="lp1"
					placeholder="Điểm lp1 sinh viên"
					value="<c:out value='${Student.lp1}' />">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">lp2</label> <input
					type="text" class="form-control" name="lp2"
					placeholder="Điểm lp2 sinh viên"
					value="<c:out value='${Student.lp2}' />">
			</div>

			<button type="submit" class="btn btn-primary"><fmt:message key="submit"/></button>

		</form>
	</div>
</body>

</html>