<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
<div class="content-wrapper">
<form:form class="form"  method="GET" modelAttribute="formHopDong" action="">
	<div class="form-body">
		<h4 class="form-section">Thêm Hợp Đồng</h4>
		
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label>Mã Nhân Viên</label>
					<div class="form-control well">${hoSoNhanVienPikalong.maNv}</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label>Trạng Thái</label>
					<div class="form-control disabled">${hoSoNhanVienPikalong.isActive == 1 ? "Đang làm việc" : "Đã nghỉ việc"}</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6">
				<div class="form-group">
					<label>Phòng ban</label>
					<div class="form-control well">${hoSoNhanVienPikalong.maPhongBan}</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<label>Chức danh</label>
					<div class="form-control well">${hoSoNhanVienPikalong.maChucDanh}</div>
				</div>
			</div>
		</div>
		<h4 class="form-section">
			<i class="ft-user"></i> Thông Tin Hợp Đồng
		</h4>
		<div class="row">
		<div class="col-md-4">
				<label>Mã hợp đồng</label> <form:input path="maHopDong"
						disable="true" id="maHopDong" class="form-control" />
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label>Tên hợp đồng</label> <form:select path="loaiHopDongPikalong.maLoaiHopDong"
						id="tenHd" name="tenHdSelect" class="form-control">
						<option value="none" selected="" disabled=""> <--Chọn--> </option>
						<form:option value="1">Hợp đồng thử việc</form:option>
						<option value="2">Hợp đồng ngắn hạn</option>
						<option value="3">Hợp đồng chính thức</option>
						
					</form:select>
				</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<label>Trạng thái</label> <form:input path="trangThai"
						type="text" id="trangThai" class="form-control" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-group">
					<label>Lương tháng 13</label> <form:select path="luongThang13"
						  class="form-control">
						<form:option value="none" selected="" disabled=""> <--Chọn--> </form:option>
						<form:option value="1">Có</form:option>
						<form:option value="2">Không</form:option>
					</form:select>
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>Số ngày nghỉ trong năm</label> <form:input path="soNgayNghiTrongNam"
						type="text" id="chucDanh" class="form-control" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>Ngày ký hợp đồng</label> <form:input path="ngayKiKet"
						type="date" id="ngayKyKet" class="form-control" />
				</div>
			</div>
			<div class="col-md-3">
				<div class="form-group">
					<label>Ngày kết thúc hợp đồng</label> <form:input path="ngayKetThuc"
						type="date" id="ngayKetThuc" class="form-control" />
				</div>
			</div>
		</div>
	</div>
	<div class="form-actions center">
	<a href="QuanTriNhanSu/quanlihopdong/">
	<button type="button" class="btn btn-warning btn-min-width mr-1 mb-1">
			<i class="ft-x"></i> Hủy
	</button></a>
		<button type="button" class="btn btn-info btn-min-width mr-1 mb-1">
			<i class="fa fa-check"></i> Lưu
		</button>
		
	</div>
</form:form>
</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
