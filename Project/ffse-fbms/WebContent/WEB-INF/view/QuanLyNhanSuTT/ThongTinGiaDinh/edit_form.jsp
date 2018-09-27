<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa Thông Tin Gia Đình</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quanlynhansutt/bang_cap/" />'>Danh sách
									bằng cấp</a></li>
							<li class="breadcrumb-item active">Sửa Thông Tin Gia Đình</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<section id="horizontal-form-layouts">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-header">
									<h4 class="card-title" id="horz-layout-basic">Thông Tin
										Chính</h4>
									<a class="heading-elements-toggle"><i
										class="fa fa-ellipsis-v font-medium-3"></i></a>
									<div class="heading-elements">
										<ul class="list-inline mb-0">
											<li><a data-action="collapse"><i class="ft-minus"></i></a></li>
											<li><a data-action="reload"><i class="ft-rotate-cw"></i></a></li>
											<li><a data-action="expand"><i class="ft-maximize"></i></a></li>
											<li><a data-action="close"><i class="ft-x"></i></a></li>
										</ul>
									</div>
								</div>
								<div class="card-body collapse in">
									<div class="card-block">
										<form:form method="POST" modelAttribute="hsgd"
											action="/ffse-fbms/quanlynhansutt/gia_dinh/save">
											<form:hidden path="id" />
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<label>Mã Nhân Viên</label>
												<form:input class="form-control" readonly="true"
													path="hoSoNhanVienTT.maNhanVien" placeholder="Mã Nhân Viên" />
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Họ Và Tên</label>
													<form:input path="hoTen" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="hoTen"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="date1">Năm Sinh</label>
													<fieldset class="form-group position-relative">
														<form:input placeholder="Năm Sinh" type="date"
															class="form-control round" id="date1" path="namSinh" />
														<div class="form-control-position">
															<i class="fa fa-calendar-o"></i>
														</div>
													</fieldset>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label>Giới Tính</label>
													<form:select class="custom-select form-control"
														path="gioiTinh">
														<option value="none">Chọn</option>
														<form:option value="1">Nam</form:option>
														<form:option value="2">Nữ</form:option>
													</form:select>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<label>Quê Quán</label>
												<form:input class="form-control" path="queQuan"
													placeholder="Quê Quán" />
												<form:errors path="queQuan"
													cssClass="invalid-feedback d-block" />
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<label>Số Điện Thoại</label>
												<form:input class="form-control" path="soDienThoai"
													placeholder="Số Điện Thoại" />
												<form:errors path="soDienThoai"
													cssClass="invalid-feedback d-block" />
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<label>Quan Hệ</label>
												<form:input class="form-control" path="quanHe"
													placeholder="Quan Hệ" />
												<form:errors path="quanHe"
													cssClass="invalid-feedback d-block" />
											</div>
											<div class="col-xl-6 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<input class="btn btn-success" type="submit" value="Save" />
													<a class="btn btn-info" href="#">View</a>
												</div>
											</div>
										</form:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />