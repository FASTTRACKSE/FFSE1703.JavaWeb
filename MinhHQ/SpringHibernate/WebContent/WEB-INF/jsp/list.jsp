<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sinh viên</title>
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
				<a href="create">Thêm sinh viên</a>
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
					<th scope="col">Ảnh đại diện</th>
					<th scope="col">Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${listStudent}">
					<tr>
						<th scope="row">${sv.masv}</th>
						<td>${sv.tensv }</td>
						<td>${sv.tuoisv }</td>
						<td>${sv.diachi }</td>
						<td>${sv.email }</td>
						<td>${sv.lop }</td>
						<td><img style="width: 100px; height: 100px;" src='<c:url value = "/resources/upload/${sv.avatar }" ></c:url>' alt="image"></td>
					<td><a href="edit/${sv.id }"><button
							class="btn btn-success">Edit</button></a> <a
					href="delete/${sv.id }"><button class="btn btn-danger"
					onclick="return confirm('Bạn có muốn xóa sinh viên này?');">Delete</button></a></td>
				</c:forEach>
			</tbody>
		</table>
<nav aria-label="Page navigation example">
	<ul class="pagination">
		<li class="page-item"><a class="page-link" href="?page=1">First
				Page</a></li>
		<c:if test="${currentPage > 2}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage-2}">${currentPage-2}</a></li>
			</c:if>
			<c:if test="${currentPage > 1}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage-1}">${currentPage-1}</a></li>
			</c:if>
			<li class="page-item active"><a class="page-link"
				href="?page=${currentPage}">${currentPage}</a></li>
			<c:if test="${currentPage < lastPage}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage+1}">${currentPage+1}</a></li>
			</c:if>
			<c:if test="${currentPage < lastPage - 1}">
				<li class="page-item"><a class="page-link"
					href="?page=${currentPage+2}">${currentPage+2}</a></li>
			</c:if>
		<li class="page-item"><a class="page-link" href="?page=${lastPage }">Last Page</a></li>
	</ul>
	</nav>
	</div>
	<script>
		function canhbao() {
			return confirm("Bạn Có Chắc Muốn Xóa Không?");
		}
	</script>
</body>
</html>