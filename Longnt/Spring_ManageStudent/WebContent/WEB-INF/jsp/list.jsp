<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		<div style="text-align: center;">
			<h1>Danh sách sinh viên</h1>
		</div>
		<div>
			<h3>
				<a href="forminsert">Thêm sinh viên</a>
			</h3>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Mã sinh viên</th>
					<th scope="col">Tên sinh viên</th>
					<th scope="col">Tuổi</th>
					<th scope="col">Địa chỉ</th>
					<th scope="col">Email</th>
					<th scope="col">Lớp học</th>
					<th scope="col">Image</th>
					<th scope="col">Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${list }">
					<tr>
						<th scope="row">${sv.maSV}</th>
						<td>${sv.tenSV }</td>
						<td>${sv.tuoiSV }</td>
						<td>${sv.diaChi }</td>
						<td>${sv.email }</td>
						<td>${sv.lop }</td>
						<td><img src="<c:url value="/resources/upload/${sv.avatar } " />"></td>
						<td><a href="formupdate/${sv.maSV}" class="btn btn-success">Sửa</a>
							<a href="delete/${sv.maSV}"
							onclick="return confirm('Bạn có muốn xóa sinh viên này?');"
							class="btn btn-danger">Xóa</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>


	</div>
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${pageId > 1 }">
				<li class="page-item"><a class="page-link" href="1">First</a></li>
				<li class="page-item"><a class="page-link" href="${pageId -1 }">${pageId -1 }</a></li>
			</c:if>
			
			<li class="page-item"><a class="page-link" href="${pageId }">${pageId }</a></li>
			
			<c:if test="${pageId < totalPage}">
				<li class="page-item"><a class="page-link" href="${pageId +1 }">${pageId +1 }</a></li>
				<li class="page-item"><a class="page-link" href="${totalPage }">Last</a></li>
			</c:if>
		</ul>
	</nav>

	<script>
		function canhbao() {
			return confirm("Bạn Có Chắc Muốn Xóa Không?");
		}
	</script>
</body>
</html>