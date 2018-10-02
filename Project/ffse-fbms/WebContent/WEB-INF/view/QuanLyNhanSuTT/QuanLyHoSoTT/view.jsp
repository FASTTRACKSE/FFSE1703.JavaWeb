
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thông Tin Nhân Viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quanlynhansutt/ho_so/" />'>Danh sách
									nhân viên</a></li>
							<li class="breadcrumb-item active">xem thông tin nhân viên</li>
						</ol>
					</div>
				</div>
			</div>
			<c:if test="${empty add}">
				<style>
i.fa {
	width: 20px;
}
</style>
				<div class="content-header-right col-md-3 col-xs-12">
					<div role="group" aria-label="Button group with nested dropdown"
						class="dropdown nav-item float-md-right">
						<div role="group" class="btn-group">
							<button id="btnGroupDrop1" type="button" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"
								class="btn btn-outline-primary dropdown-toggle">
								<i class="ft-settings icon-left"></i>
								<spring:message code="label.thongTinKhac" />
							</button>
							<div aria-labelledby="btnGroupDrop1"
								class="dropdown-menu dropdown-menu-right">
								<a href="<c:url value = "#"/>" class="dropdown-item"><i
									class="fa fa-id-card-o"></i> <spring:message
										code="label.thongTinHoSo" /></a> <a
									href="<c:url value = "/quanlynhansutt/bang_cap/viewOneBangCap/${maNhanVien}"/>"
									class="dropdown-item"><i class="fa fa-graduation-cap"></i>
									<spring:message code="label.thongTinBangCap" /></a> <a
									href="<c:url value = "/quanlynhansutt/gia_dinh/viewOneGiaDinh/${maNhanVien}"/>"
									class="dropdown-item"><i class="fa fa-users"></i> <spring:message
										code="label.thongTinGiaDinh" /></a> <a
									href="<c:url value = "/quanlynhansutt/kinh_Nghiem/viewOneKinhNghiem/${maNhanVien}"/>"
									class="dropdown-item"><i class="fa fa-file-code-o"></i> <spring:message
										code="label.thongTinKinhNghiem" /></a> <a
									href="<c:url value = "/quanlynhansutt/hop_dong/viewOneHopDong/${maNhanVien}"/>"
									class="dropdown-item"><i class="fa fa-handshake-o"></i> <spring:message
										code="label.thongTinHopDong" /></a>
								<div class="dropdown-divider"></div>
								<a
									href="<c:url value = "/quanlynhansutt/ho_so/viewOne/${maNhanVien}"/>"
									class="dropdown-item text-xs-center"><spring:message
										code="label.xemTatCa" /></a>
							</div>
						</div>
					</div>
				</div>
			</c:if>
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
										Của nhân viên</h4>
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
										<div class="card-body collapse in">
											<div class="card-block">
												<form:form method="POST" action="update"
													modelAttribute="formHoso" enctype="multipart/form-data">
													<div class="form-body">
														<div class="row">
															<div class="col-md-8">
															<div class="row">
																<div class="form-group col-sm-6">
																<img
																		src="<c:url value="/uploads/${formHoso.anhDaiDien}" />"
																		width="150" height="200">
																</div>
																</div>
																<div class="row">
																	<div class="form-group col-sm-6">
																		<label>mã nhân viên</label>
																		<form:input class="form-control" path="maNhanVien"
																			placeholder="mã nhân viên" readonly="true" />
																	</div>
																	<div class="form-group col-sm-6">
																		<label>tên nhân viên</label>
																		<form:input class="form-control" path="tenNhanVien"
																			placeholder="tên nhân viên" readonly="true" />
																	</div>

																</div>

																<div class="row">
																	<div class="form-group col-sm-6">
																		<div class="form-group">
																			<label>giới tính</label>
																			<form:select class="custom-select form-control"
																				path="gioiTinh" readonly="true">
																				<option value="none">Chọn</option>
																				<form:option value="1">Nam</form:option>
																				<form:option value="2">Nữ</form:option>
																			</form:select>
																		</div>
																	</div>
																	<div class="form-group col-sm-6">
																		<label for="projectinput2">Tình trạng hôn nhân</label>
																		<form:input class="form-control"
																			path="tinhTrangHonNhan.tinhTrangHonNhan"
																			readonly="true" />
																	</div>
																</div>

																<div class="row">
																	<div class="form-group col-sm-6">
																		<div class="form-group">
																			<label for="projectinput4">Số CMND</label>
																			<form:input path="soCmnd" type="text"
																				id="projectinput4" class="form-control"
																				placeholder="Số CMND" readonly="true" />
																		</div>
																	</div>
																	<div class="form-group col-sm-6">
																		<label for="projectinput4">Nơi cấp</label>
																		<form:input path="noiCap" type="text"
																			id="projectinput4" class="form-control"
																			placeholder="Nơi cấp" readonly="true" />
																	</div>
																</div>

																<div class="row">
																	<div class="form-group col-sm-6">
																		<label for="projectinput4">Ngày cấp</label>
																		<fieldset class="form-group position-relative">
																			<form:input placeholder="Ngày cấp" type="date"
																				class="form-control" path="ngayCap" readonly="true" />

																		</fieldset>
																	</div>
																	<div class="form-group col-sm-6">
																		<div class="form-group">
																			<label for="projectinput4">Dân tộc</label>
																			<form:select path="danToc.maDanToc" type="text"
																				id="projectinput4" class="form-control"
																				readonly="true">
																				<c:forEach items="${listDanToc}" var="hsnv">
																					<form:option value="${hsnv.maDanToc}">${hsnv.tenDanToc}</form:option>
																				</c:forEach>
																			</form:select>
																		</div>
																	</div>
																</div>

																<div class="row">
																	<div class="form-group col-sm-6">
																		<label for="projectinput4">Quốc tịch</label>
																		<form:select path="quocTich.maQuocTich" type="text"
																			id="projectinput4" class="form-control"
																			readonly="true">
																			<c:forEach items="${listQuocTich}" var="hsnv">
																				<form:option value="${hsnv.maQuocTich}">${hsnv.tenQuocTich}</form:option>
																			</c:forEach>
																		</form:select>
																	</div>
																	<div class="form-group col-sm-6">
																		<label>năm sinh</label>
																		<form:input class="form-control" path="namSinh"
																			placeholder="năm sinh" readonly="true" />

																	</div>
																</div>


																<div class="row">
																	<div class="form-group col-sm-6">
																		<label>số điện thoại</label>
																		<form:input class="form-control" path="soDienThoai"
																			placeholder="số điện thoại" readonly="true" />
																	</div>
																	<div class="form-group col-sm-6">
																		<label>Email</label>
																		<form:input class="form-control" path="email"
																			placeholder="Email" readonly="true" />
																	</div>
																</div>
																<div class="row">
																	<div class="form-group col-sm-6">
																		<label>tỉnh, thành phố</label>
																		<form:select path="thanhPho.maThanhPho" type="text"
																			id="thanhPhoId" class="form-control"
																			onchange="clickComboboxThanhPho()" readonly="true">
																			<option value="noThanhPho" selected="selected">Chọn
																				thành phố</option>
																			<c:forEach items="${listThanhPho}" var="x">
																				<form:option value="${x.maThanhPho}">${x.tenThanhPho}</form:option>
																			</c:forEach>
																		</form:select>
																	</div>
																	<div class="form-group col-sm-6">
																		<label>quận, huyện</label>
																		<form:select path="quanHuyen.maQuanHuyen"
																			id="quanHuyenId" type="text" class="form-control"
																			disabled="true" onchange="clickComboboxQuan()"
																			name="quanHuyen" readonly="true">
																			<option value="noQuanHuyen" selected="selected">Chọn
																				quận huyện</option>
																		</form:select>
																	</div>
																</div>
																<div class="row">
																	<div class="form-group col-sm-6">
																		<label>xã, phường</label>
																		<form:select path="xaPhuong.maXa" type="text"
																			id="phuongXaId" class="form-control"
																			name="phuongXaSelect" disabled="true" readonly="true">
																			<option value="noPhuongXa" selected="selected">Chọn
																				xã, phường</option>
																		</form:select>
																	</div>
																	<div class="form-group col-sm-6">
																		<label>địa chỉ</label>
																		<form:input class="form-control" path="diaChi"
																			placeholder="địa chỉ" readonly="true" />
																	</div>
																</div>
																<div class="row">
																	<div class="form-group col-sm-6">
																		<label>phòng ban</label>
																		<form:select path="phongBan.maPhongBan" type="text"
																			id="companyName" class="form-control"
																			name="phongBanSelect" readonly="true">
																			<option value="none" selected>Chọn Phòng ban</option>
																			<c:forEach items="${listPhongBan}" var="x">
																				<form:option value="${x.maPhongBan}">${x.tenPhongBan}</form:option>
																			</c:forEach>
																		</form:select>
																	</div>
																	<div class="form-group col-sm-6">
																		<label>chức danh</label>
																		<form:select path="chucDanh.maChucDanh" type="text"
																			id="companyName" class="form-control"
																			placeholder="Company Name" name="chucDanhSelect" readonly="true">
																			<option value="none" selected="selected">Chọn
																				chức danh</option>
																			<c:forEach items="${listChucDanh}" var="x">
																				<form:option value="${x.maChucDanh}">${x.tenChucDanh}</form:option>
																			</c:forEach>
																		</form:select>

																	</div>
																</div>
																<div class="row">
																	<div class="form-group col-sm-6">
																		<label for="location1">Trạng Thái</label>
																		<form:select class="custom-select form-control"
																			path="trangThai" readonly="true">
																			<form:option value="1">Còn
																		Làm Việc</form:option>
																			<form:option value="2">Hết
																		Làm Việc</form:option>
																		</form:select>
																	</div>
																</div>

															</div>
														</div>

													</div>
													<div class="form-actions center">
														<input class="btn btn-success" type="submit" value="back" />
													</div>
												</form:form>
												<script>
													window.onload = function() {
														clickComboboxThanhPho(); // gọi function này để load quận

													}
												</script>

												<script type="text/javascript">
												<!-- ajax select ThanhPho -->
													function clickComboboxThanhPho() {
														var maThanhPho = $(
																"#thanhPhoId")
																.val();
														if (maThanhPho == 'noThanhPho') { // nếu người dùng chưa chọn thành phố
															$(
																	'#quanHuyenId option')
																	.remove();
															$('#quanHuyenId')
																	.prop(
																			'disabled',
																			true); /*disable combobox quận huyện */

															$(
																	'#phuongXaId option[value=noPhuongXa]')
																	.attr(
																			'selected',
																			'selected')
															$('#phuongXaId')
																	.prop(
																			'disabled',
																			true);

														} else { // nếu người dùng đã chọn thành phố

															$('#quanHuyenId')
																	.prop(
																			'disabled',
																			false); /*enable combobox quận huyện */

															$(
																	'#quanHuyenId option')
																	.remove(); /* xóa những option quận huyện cũ */
														}

														$
																.ajax({
																	url : "/ffse-fbms/quanlynhansutt/ho_so/selectquan/"
																			+ maThanhPho,
																	dataType : "json",
																	success : function(
																			data) {
																		$(
																				'#quanHuyenId')
																				.append(
																						$(
																								'<option>',
																								{
																									value : 'noQuanHuyen',
																									text : 'Chọn Quận Huyện'
																								}));

																		for (var i = 0; i < data.length; i++) {
																			$(
																					'#quanHuyenId')
																					.append(
																							$(
																									'<option>',
																									{
																										value : data[i].maQuanHuyen,
																										text : data[i].tenQuanHuyen
																									}));

																		}
																		$(
																				'#quanHuyenId option[value=${formHoso.quanHuyen.maQuanHuyen}]')
																				.attr(
																						'selected',
																						'selected')
																		clickComboboxQuan(); // gọi function này để load phường

																	}
																});
													};
												</script>

												<script>
													// ajax select QuanHuyen
													function clickComboboxQuan() {
														var maQuanHuyen = $(
																"#quanHuyenId")
																.val();
														if (maQuanHuyen == 'noQuanHuyen') { /* nếu người dùng chưa chọn thành phố */
															$(
																	'#phuongXaId option')
																	.remove();
															$('#phuongXaId')
																	.prop(
																			'disabled',
																			true); /*disable combobox quận huyện */

														} else { /* nếu người dùng đã chọn thành phố*/

															$('#phuongXaId')
																	.prop(
																			'disabled',
																			false); // enable combobox quận huyện 
															$(
																	'#phuongXaId option')
																	.remove(); // xóa những option quận huyện cũ
														}

														$
																.ajax({
																	url : "/ffse-fbms/quanlynhansutt/ho_so/selectphuong/"
																			+ maQuanHuyen,
																	dataType : "json",
																	success : function(
																			data) {

																		$(
																				'#phuongXaId')
																				.append(
																						$(
																								'<option>',
																								{
																									value : 'noPhuongXa',
																									text : 'Chọn phường xã'
																								}));

																		for (var i = 0; i < data.length; i++) {
																			$(
																					'#phuongXaId')
																					.append(
																							$(
																									'<option>',
																									{
																										value : data[i].maXa,
																										text : data[i].tenXa
																									}));

																		}
																		$(
																				'#phuongXaId option[value=${formHoso.xaPhuong.maXa}]')
																				.attr(
																						'selected',
																						'selected')

																	}
																});
													};
												</script>
												<!-- preview image -->
												<script type="text/javascript">
													function readURL(input) {
														if (input.files
																&& input.files[0]) {
															var reader = new FileReader();
															reader.onload = function(
																	e) {
																$('#img')
																		.attr(
																				'src',
																				e.target.result);
															}
															reader
																	.readAsDataURL(input.files[0]);
														}
													}
													$("#imgUrl").change(
															function() {
																readURL(this);
															});
												</script>
											</div>
										</div>
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