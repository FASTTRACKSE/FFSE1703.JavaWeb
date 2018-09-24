<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="table-responsive">
		<a href="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiGiaDinh/add/${maNv}"
				class="btn btn-outline-success round btn-min-width mr-1 mb-1">Thêm</a>
			<table class="table mb-0">
				<thead>
					<tr>
						<th>Họ Tên</th>
						<th>Quan Hệ</th>
						<th>Quê Quán</th>
						<th>Nơi Ở Hiện Nay</th>
						<th>Nghề Nghiệp</th>
						<th>SĐT</th>
						<th>Chức Năng</th>
					</tr>
				</thead>
				<tbody>
					<h1>${viewOne.get(0).maNV }</h1>
					<c:forEach var="giadinh" items="${viewOne}">
						<tr>
							<td>${giadinh.hoTen}</td>
							<td>${giadinh.quanHe}</td>
							<td>${giadinh.queQuan}</td>
							<td>${giadinh.noiOHienNay}</td>
							<td>${giadinh.ngheNghiep}</td>
							<td>${giadinh.sdt}</td>
							<td><a
								href='<c:url value = "/QuanTriNhanSuPikalong/QuanLiGiaDinh/edit/${giadinh.id}"></c:url>'
								class="btn btn-outline-info round">Sửa</a> <a
								href='<c:url value = "/QuanTriNhanSuPikalong/QuanLiGiaDinh/remove/${giadinh.id}"></c:url>'
								class="btn btn-outline-danger round "
								onclick="return confirm('Bạn có muốn xóa Thông Tin này?');">Xóa</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />