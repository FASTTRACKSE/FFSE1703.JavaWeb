<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Danh sách Sinh Viên</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container"> 
	<h2 style="text-align: center">Danh sách sinh viên</h2>
	<a href="addSv"><button class = "btn btn-success">Thêm sinh viên</button></a>
<table class="table table-hover">
	<tr>
		<th>Mã sv</th>
		<th>Họ tên</th>
		<th>Năm Sinh</th>
		<th>Quê Quán</th>
		<th>Email</th>
		<th>Điện Thoại</th>
		<th>Mã Lớp</th>
		<th>Chức năng</th>
	</tr>
	<c:forEach var = "x" items="${listSinhVien}"> 
		<tr>
			<td>${x.maSv}</td>
			<td>${x.hoTen}</td>
			<td>${x.namSinh}</td>
			<td>${x.queQuan}</td>
			<td>${x.email}</td>
			<td>${x.dienThoai}</td>
			<td>${x.maLop}</td>
			<td>
				<a href="editSv/${x.maSv}"><button class="btn btn-warning">Sửa</button></a>
								&nbsp; &nbsp;
				<a href="deleteSv/${x.maSv}"><button class="btn btn-danger" onclick="if (!confirm('Bạn có muốn xóa sinh viên này không?')) return false">Xóa</button></a>
			</td>
		</tr>
	</c:forEach>	
</table>
<p>${totalPage}</p>

<c:if test="${pageIndex > 1}">
	<a href="1">first</a>
	<a href="${pageIndex - 1}"> <button class="btn btn-default">${pageIndex - 1}</button></a>
</c:if>

<a href="${pageIndex}"><button class="btn btn-success">${pageIndex}</button></a>

<c:if test="${pageIndex < totalPage}">
	<a href="${pageIndex + 1}"><button class="btn btn-default">${pageIndex + 1}</button></a>
	<a href="${totalPage}">last</a>
</c:if>

</div>

		
</body>
</html>