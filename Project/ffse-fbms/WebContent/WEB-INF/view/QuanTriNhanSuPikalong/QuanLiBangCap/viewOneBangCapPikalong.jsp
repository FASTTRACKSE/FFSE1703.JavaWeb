<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<h3 class="content-header-title mb-0">Danh sách Bằng Cấp Của Nhân
			Viên</h3>
		<div class="row breadcrumbs-top">
			<div class="breadcrumb-wrapper col-xs-12">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/" />'>Danh
							Sách Nhân Viên</a></li>
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/view/${maNv }" />'>Thông Tin Nhân Viên</a></li>
					<li class="breadcrumb-item active">Bằng Cấp Nhân Viên</li>
				</ol>
			</div>
		</div>
		<div class="table-responsive">
			<a href="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiBangCap/add/${maNv}"
				class="btn btn-outline-success round btn-min-width mr-1 mb-1">Thêm</a>
			<table class="table mb-0">
				<thead>
					<tr>
						<th>Chuyên Ngành</th>
						<th>Xếp Loại</th>
						<th>Nơi Cấp</th>
						<th>Ngày Cấp</th>
						<th>Chức Năng</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bangcap" items="${viewOne}">
						<tr>
							<td>${bangcap.chuyenNganh}</td>
							<td>${bangcap.xepLoai}</td>
							<td>${bangcap.noiCap}</td>
							<td>${bangcap.ngayCap}</td>
							<td><a
								href='<c:url value = "/QuanTriNhanSuPikalong/QuanLiBangCap/edit/${bangcap.id}"></c:url>'
								class="btn btn-outline-info round">Sửa</a> <a
								href='<c:url value = "/QuanTriNhanSuPikalong/QuanLiBangCap/remove/${bangcap.id}"></c:url>'
								class="btn btn-outline-danger round"
								onclick="return confirm('Bạn có muốn xóa bằng cấp này?');">Xóa</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />