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
				<h3 class="content-header-title mb-0">Sửa hợp đồng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quanlynhansutt/" />'>Danh sách hợp đồng</a></li>
							<li class="breadcrumb-item active">Sửa hợp đồng</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<%-- <div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="hopDongTT" action="">
						<form:input type="hidden" path="maHopDong" style="display:none" value="${hopDongTT.maHopDong}"/>
						<div class="form-group col-sm-6">
						  	<label>Mã Hợp Đồng</label>
						  	<form:input class="form-control" path="maHopDong" value="${hopDongTT.maHopDong}" placeholder="Mã Hợp Đồng" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mã Nhân Viên</label>
						  	<form:input class="form-control" path="hoSoNhanVien.maNhanVien" value="${hopDongTT.hoSoNhanVien.maNhanVien}" placeholder="Mã Nhân Viên" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mã Loại Hợp Đồng</label>
						  	<form:input class="form-control" path="loaiHopDong.tenHopDong" value="${hopDongTT.loaiHopDong.tenHopDong}" placeholder="Mã Loại Hợp Đồng" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Mã Chức Danh</label>
						  	<form:input class="form-control" path="chucDanh.tenChucDanh" value="${hopDongTT.chucDanh.tenChucDanh}" placeholder="Mã Loại Chức Danh" />
						</div>
						
						
						
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông tin</button>
						</div>
					</form:form>
				</div>
			</div> --%>
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
									<form:form method="POST" modelAttribute="hopDongTT" action="/ffse-fbms/quanlynhansutt/save">
										<form:input type="hidden" path="maHopDong"
											style="display:none" value="${hopDongTT.maHopDong}" />

										<div class="form-body">
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="form-group col-sm-6">
															<label>Mã Hợp Đồng</label>
															<form:input class="form-control" path="maHopDong"
																value="${hopDongTT.maHopDong}" placeholder="Mã Hợp Đồng" />
														</div>
														<div class="form-group col-sm-6">
															<label>Mã Nhân Viên</label>
															<form:input class="form-control"
																path="hoSoNhanVien.maNhanVien"
																value="${hopDongTT.hoSoNhanVien.maNhanVien}"
																placeholder="Mã Nhân Viên" />
														</div>

													</div>
													<div class="row">
														<div class="form-group col-sm-6">
															<label>Mã Loại Hợp Đồng</label>
															<form:input class="form-control"
																path="loaiHopDong.maLoaiHopDong"
																value="${hopDongTT.loaiHopDong.maLoaiHopDong}"
																placeholder="Mã Loại Hợp Đồng" />
														</div>
														<div class="form-group col-sm-6">
															<label>Mã Chức Danh</label>
															<form:input class="form-control"
																path="chucDanh.maChucDanh"
																value="${hopDongTT.chucDanh.maChucDanh}"
																placeholder="Mã Loại Chức Danh" />
														</div>
													</div>
												</div>
												<%-- <div class="col-md-4" style="text-align: center !important;">
													<img width="175px" height="175px"
														src="/ffse-fbms/resources/images/nhan-vien/${hoSoNhanVien.anhDaiDien}">
												</div> --%>
											</div>
											<h4 class="form-section">
												<i class="ft-user"> Thông Tin Hợp Đồng</i>
											</h4>
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="form-group col-sm-6">
															<div class="form-group">
																<label>Lương Tháng 13</label>
																<form:input class="form-control" path="luongThang13"
																	value="${hopDongTT.luongThang13}"
																	placeholder="Lương Tháng 13" />
															</div>
														</div>
														<div class="form-group col-sm-6">
															<label>Số Ngày Phép</label>
															<form:input class="form-control" path="soNgayPhep"
																value="${hopDongTT.soNgayPhep}"
																placeholder="Số Ngày Phép" />
														</div>

													</div>
													<div class="row">
														<div class="col-md-6">
															<div class="form-group">
																<label for="date1">Ngày Ký</label> <input
																	class="form-control" path="ngayKy"
																	value="${hopDongTT.ngayKy}" placeholder="Ngày Ký"
																	type="date" class="form-control" id="date1">
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="date1">Hợp Đồng Từ Ngày</label> <input
																	class="form-control" path="hopDongTuNgay"
																	value="${hopDongTT.hopDongTuNgay}"
																	placeholder="Hợp Đồng Từ Ngày" type="date"
																	class="form-control" id="date1">
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="date1">Hợp Đồng Đến Ngày</label> <input
																	class="form-control" path="hopDongDenNgay"
																	value="${hopDongTT.hopDongDenNgay}"
																	placeholder="Hợp Đồng Đến Ngày" type="date"
																	class="form-control" id="date1">
															</div>
														</div>
														<div class="col-md-6">
															<div class="form-group">
																<label for="location1">Trạng Thái</label> 
																<select class="custom-select form-control" id="location1"
																	name="location" path="trangThai">
																	<option value="${hopDongTT.trangThai == 1}">Còn Hợp Đồng</option>
																	<option value="${hopDongTT.trangThai == 2}">Hết Hợp Đồng</option>
																</select>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<sec:authorize access="hasRole('ROLE_PNS')">
											<div class="form-actions center">
												
													<input class="btn btn-success" type="submit" value="Save" />
												
											</div>
										</sec:authorize>
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

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />