<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sinh Viên</title>
</head>
<body>

	<h1>Thêm Sinh Viên</h1>
	<form:form method="post" action="save">
		<table>
			<tr>
				<td>Name :</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td>Class :</td>
				<td><form:input path="lop" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" href="CRUDSpring/viewemp/1" value="Lưu" /> <a>&ensp;&ensp;</a> <a>&ensp;&ensp;</a> <a href="viewemp/1"  type="submit" >Quay lại</a></td>
				
				

			</tr>

		</table>
	</form:form>



</body>
</html>