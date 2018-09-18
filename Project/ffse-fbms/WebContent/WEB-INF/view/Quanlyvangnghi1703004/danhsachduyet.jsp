<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<h3>Danh sách đã duyệt</h3>
			<div>
			<div class="container">
			    <div class="table-responsive">
						<table class="table mb-0">
							<thead>
				<tr>
					<th >Mã đơn</th>
					<th >Mã nhân viên</th>
					<th >Ngày bắt đầu</th>
					<th >Ngày kết thúc</th>
					<th >Số ngày nghỉ</th>
					<th >Lý do</th>
					<th >Ghi chú</th>
					<th >Ghi chú của trưởng phòng</th>
					<th >Trạng thái</th>
					<th>Chức năng</th>
				</tr>
				</thead>
				<tbody>
			<c:forEach var="nv" items="${danhsachduyet}">
					<tr>
					<td>${nv.id}</td>
					<td>${nv.maNhanVien.maNhanVien}</td>
					<td>${nv.ngayBatDau}</td>
					<td>${nv.ngayKetThuc}</td>
					<td>${nv.soNgayNghi}</td>
					<td>${nv.lyDo.lyDo}</td>
					<td>${nv.ghiChu}</td>
					<td>${nv.ghiChuTruongPhong}</td>
					<td>${nv.trangThai.trangThai}</td>
					<td><button class="btn btn-success">
									Sửa</button>
					</td>
						</tr>
				</c:forEach>
				</tbody>
		</table>
		</div>
		</div>
		</div>
		</div>
		</div>
		</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
