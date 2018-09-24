<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa công việc</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/QuanLyNhiemVuMinhHQ/list" />'>Danh sách công việc</a></li>
							<li class="breadcrumb-item active">Sửa công việc</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="CongViec" action="/ffse-fbms/QuanLyNhiemVuMinhHQ/update">
						<form:input type="hidden" path="ID" style="display:none" value="${congViec.ID}"/>
						<div class="form-group col-sm-6">
						  	<label>Dự án</label>
						  	<form:input class="form-control" path="duAn" value="${congViec.duAn}" readonly="true"/>
						</div>
						<div class="form-group col-sm-6">
						  	<label>Tên công việc</label>
						  	<form:input class="form-control" path="tenCongViec" value="${congViec.tenCongViec}"/>
						</div>
						<div class="form-group col-sm-6">
						  	<label>Loại công việc</label>
						  	<form:input class="form-control" path="loaiCongViec" value="${congViec.loaiCongViec}"/>
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mô tả</label>
						  	<form:textarea class="form-control" path="moTa" value="${congViec.moTa}"/>
						</div>
						<div class="form-group col-sm-6">
						  	<label>Thời gian bắt đầu</label>
						  	<form:input class="form-control" type="date" path="tgBatDau" value="${congViec.tgBatDau}"/>
						</div>
						<div class="form-group col-sm-6">
						  	<label>Thời gian kết thúc</label>
						  	<form:input class="form-control" type="date" path="tgKetThuc" value="${congViec.tgKetThuc}"/>
						</div>
						<div class="form-group col-sm-6">
						  	<label>phân công</label>
						  	<form:input class="form-control" path="phanCong" value="${congViec.phanCong}"/>
						</div>
						<div class="form-group col-sm-6">
						  	<label>Thời gian dự kiến</label>
						  	<form:input class="form-control" path="tgDuKien" value="${congViec.tgDuKien}"/>
						</div>
						<div class="form-group col-sm-6">
						  	<label>Trạng thái</label>
						  	<form:input class="form-control" path="trangThai" value="${congViec.trangThai}"/>
						</div>
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông tin</button>
						</div>
						<form:hidden path="isDelete"/>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
