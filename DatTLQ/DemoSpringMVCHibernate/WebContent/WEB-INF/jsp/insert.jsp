<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Thêm Sinh Viên</h1>
	<form:form method="post" action="DemoSpringMVCHibernate/add">
		<table>
			<tr>
				<td>Tên SV :</td>
				<td><form:input path="tenSV" /></td>
				<td>
				<form:errors path="tenSV" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Năm Sinh :</td>
				<td><form:input path="namSinh" /></td>
				<td>
				<form:errors path="namSinh" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><form:input path="email" /></td>
				<td>
				<form:errors path="email" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Địa Chỉ :</td>
				<td><form:input path="diaChi" /></td>
				<td>
				<form:errors path="diaChi" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td>Lớp Học :</td>
				<td><form:input path="lopHoc" /></td>
				<td>
				<form:errors path="lopHoc" cssStyle="color:red"></form:errors>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>