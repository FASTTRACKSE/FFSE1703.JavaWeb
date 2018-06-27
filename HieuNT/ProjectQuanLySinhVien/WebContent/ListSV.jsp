<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DANH SÁCH SINH VIÊN</title>
</head>
<style>
body {
	margin: 0;
	font-family: fantasy;
	background: url(IMAGE/p.jpg) no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
	color: white;
}
</style>
<body background="ME/p.jpg">
	<center>
		<h1>QUẢN LÝ SINH VIÊN</h1>
		<h2>
			<a href="/ProjectQuanLySinhVien/ListSVController/new">ADD SINH
				VIÊN</a> &nbsp;&nbsp;&nbsp;
		</h2>


	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption>DANH SÁCH SINH VIÊN</caption>
			<tr>
				<th>MÃ SINH VIÊN</th>
				<th>TÊN</th>
				<th>GIỚI TÍNH</th>
				<th>TUỔI</th>
				<th>LỚP</th>
				<th>ĐỊA CHỈ</th>
				<th>ẢNH</th>
				<th>ACTIONS</th>

			</tr>
			<c:forEach var="SV" items="${SinhVien}">
				<tr>
					<td><c:out value="${SV.maSV}" /></td>
					<td><c:out value="${SV.name}" /></td>
					<td><c:out value="${SV.sex}" /></td>
					<td><c:out value="${SV.age}" /></td>
					<td><c:out value="${SV.cls}" /></td>
					<td><c:out value="${SV.dress}" /></td>
					<td><c:out value="${SV.photo}" /></td>

					<td><img src="ME/p.jpg"></td>



					<td><a
						href="/ProjectQuanLySinhVien/ListSVController/edit?maSV=<c:out value='${SV.maSV}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/ProjectQuanLySinhVien/ListSVController/delete?maSV=<c:out value='${SV.maSV}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>

		</table>
		<%
			String totalPage = request.getAttribute("SoTrang").toString();
			int trang = Integer.parseInt(totalPage);
			for (int i = 1; i <= trang; i++) {
				out.print("<a href='/ProjectQuanLySinhVien/ListSVController/phanTrang?page=" + i + "'>" + ' ' + i + ' '
						+ "</a>");
			}
		%>
	</div>
</body>
</html>