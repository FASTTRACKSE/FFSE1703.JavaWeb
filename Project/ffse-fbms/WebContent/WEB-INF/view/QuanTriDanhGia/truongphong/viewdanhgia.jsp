<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="/WEB-INF/view/QuanTriDanhGia/templates/header.jsp"></jsp:include>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-9 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Đánh giá nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<c:url value = "/quantridanhgia/home/"/>">Quản trị
									đánh giá</a></li>
							<li class="breadcrumb-item"><a
								href="<c:url value = "/quantridanhgia/danhgianhanvien/"/>">Đánh
									giá nhân viên</a></li>
							<li class="breadcrumb-item active">Form đánh giá</li>
						</ol>
					</div>
				</div>
			</div>
			<div class="content-body">
				<!-- Basic form layout section start -->
				<section id="basic-form-layouts">
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-content collpase show">
									<div class="card-body" style="margin: 1em">
										<form:form cssClass="form form-horizontal form-bordered"
											method="POST">
											<div class="form-body">
												<h4 class="form-section">
													<i class="ft-user"></i> Bản đánh giá
												</h4>
												<div class="form-group row">
													<label class="col-md-3 label-control">Nhân viên</label>
													<div class="col-md-9">
														<h3>Tên nhân viên</h3>
													</div>
												</div>
												<div class="form-group row">
													<label class="col-md-3 label-control"> Kỷ luật công
														việc </label>
													<div class="col-md-9">
														<form:label cssClass="form-control" path="kyLuatCongViec" />
													</div>
												</div>
												<div class="form-group row">
													<label class="col-md-3 label-control">Tinh thần làm
														việc</label>
													<div class="col-md-9">
														<form:label cssClass="form-control" path="tinhThanLamViec" />
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Khối lượng
														công việc đạt được</label>
													<form:label cssClass="form-control"
														path="khoiLuongCongViec" />
												</div>
												<div class="form-group row">
													<label class="col-md-3 label-control">Kết quả công
														việc đạt được</label>
													<div class="col-md-9">
														<form:label cssClass="form-control" path="ketQuaCongViec" />
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Kỹ năng tích
														lũy</label>
													<div class="col-md-9">
														<form:label readonly="readonly" cssClass="form-control"
															path="kyLuatCongViec" />
													</div>
												</div>

												<div class="form-group row">
													<label class="col-md-3 label-control">Định hướng</label>
													<div class="col-md-9">
														<form:label cssClass="form-control" path="dinhHuong" />
													</div>
												</div>

												<div class="form-group last">
													<label class="col-md-3 label-control">Xếp loại</label>
													<div class="col-md-9">
														<form:label cssClass="form-control" path="xepLoai" />
													</div>
												</div>
												<div class="form-actions">
													<a href="<c:url value="/quantridanhgia/danhgianhanvien/"/>"
														class="btn btn-danger btn-min-width mr-1 mb-1">Trở về</a>
													<c:if test="${command.isActive == 1 }">
														<a href="<c:url value="/quantridanhgia/danhgianhanvien/showform"/>"
															class="btn btn-danger btn-min-width mr-1 mb-1">Sửa</a>
													</c:if>
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
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>