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
				<h3 class="content-header-title mb-0">Thêm nhân viên</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Trang chủ</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/quanlyhoso/" />'>Danh sách nhân viên</a></li>
							<li class="breadcrumb-item active">Thêm nhân viên</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->
		<div class="content-body">
			<!-- Basic Elements start -->
			<section id="horizontal-form-layouts">
				<div class="row">
					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title" id="horz-layout-basic">giới thiệu</h4>
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
									<form:form method="POST" action=""
										modelAttribute="hoSoNhanVienTT">
										<div class="form-body">
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="form-group col-sm-6">
															<label>tên nhân viên</label>
															<form:input class="form-control" path="tenNhanVien"
																placeholder="tên nhân viên" />
														</div>
														<div class="form-group col-sm-6">
															<label>năm sinh</label>
															<form:input class="form-control" path="namSinh"
																placeholder="năm sinh" />

														</div>
													</div>
													<div class="row">
														<div class="form-group col-sm-6">

															<label for="projectinput3">Giới tính</label>
															<form:select path="gioiTinh" type="text"
																id="projectinput3" class="form-control"
																placeholder="Giới tính">
																<option value="none" selected="selected">Chọn
																	giới tính</option>
																<option value="1">Nam</option>
																<option value="2">Nữ</option>
															</form:select>

														</div>
														<div class="form-group col-sm-6">
															<label for="projectinput2">Tình trạng hôn nhân</label>
															<form:select path="tinhTrangHonNhan" type="text"
																id="projectinput2" class="form-control">
																<option value="none" selected="selected">Chọn
																	tình trạng hôn nhân</option>
																<option value="1">Chưa kết hôn</option>
																<option value="2">Đã kết hôn</option>
															</form:select>
														</div>
													</div>

													<div class="row">
														<div class="form-group col-sm-6">
															<div class="form-group">
																<label for="projectinput4">Số CMND</label>
																<form:input path="soCmnd" type="number"
																	id="projectinput4" class="form-control"
																	placeholder="Số CMND" />
															</div>
														</div>
														<div class="form-group col-sm-6">

															<label for="projectinput4">Nơi cấp</label>
															<form:input path="noiCap" type="text" id="projectinput4"
																class="form-control" placeholder="Nơi cấp" />

														</div>
													</div>
													<div class="row">
														<div class="form-group col-sm-6">

															<label for="projectinput4">Ngày cấp</label>
															<form:input path="ngayCap" type="date" id="projectinput4"
																class="form-control" placeholder="Ngày cấp" />

														</div>
														<div class="form-group col-sm-6">
															<div class="form-group">
																<label for="projectinput4">Dân tộc</label>
																<form:select path="danToc" type="text"
																	id="projectinput4" class="form-control">
																	<option value="none" selected="selected">Chọn
																		dân tộc</option>
																	<c:forEach items="${listDanToc}" var="x">
																		<option value="${x.maDanToc}">${x.tenDanToc}</option>
																	</c:forEach>
																</form:select>
															</div>
														</div>
													</div>


													<div class="row">
														<div class="form-group col-sm-6">

															<label for="projectinput4">Quốc tịch</label>
															<form:select path="quocTich" type="text"
																id="projectinput4" class="form-control">
																<option value="none" selected="selected">Chọn
																	quốc tịch</option>
																<c:forEach items="${listQuocTich}" var="x">
																	<option value="${x.maQuocTich}">${x.tenQuocTich}</option>
																</c:forEach>
															</form:select>

														</div>
													</div>
												</div>
											</div>
											<h4 class="form-section">
												<i class="ft-user"> thông tin liên lạc</i>
											</h4>
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="form-group col-sm-6">
															<label>số điện thoại</label>
															<form:input class="form-control" path="soDienThoai"
																placeholder="số điện thoại" />
														</div>
														<div class="form-group col-sm-6">
															<label>Email</label>
															<form:input class="form-control" path="email"
																placeholder="Email" />
														</div>
													</div>
													<div class="row">
														<div class="form-group col-sm-6">
															<label>tỉnh, thành phố</label>
															<form:select path="thanhPho" type="text" id="thanhPhoId"
																class="form-control" onchange="clickComboboxThanhPho()">
																<option value="noThanhPho" selected="selected">Chọn
																	thành phố</option>
																<c:forEach items="${listThanhPho}" var="x">
																	<option value="${x.maThanhPho}">${x.tenThanhPho}</option>
																</c:forEach>
															</form:select>
														</div>
														<div class="form-group col-sm-6">
															<label>quận, huyện</label>
															<form:select path="quanHuyen" id="quanHuyenId"
																type="text" class="form-control" disabled="true"
																onchange="clickComboboxQuan()" name="quanHuyen">
																<option value="noQuanHuyen" selected="selected">Chọn
																	quận huyện</option>
															</form:select>

														</div>

													</div>
													<div class="row">

														<div class="form-group col-sm-6">
															<label>xã, phường</label>

															<form:select path="xaPhuong" type="text" id="phuongXaId"
																class="form-control" name="phuongXaSelect"
																disabled="true">
																<option value="noPhuongXa" selected="selected">Chọn
																	xã, phường</option>

															</form:select>
														</div>
														<div class="form-group col-sm-6">
															<label>địa chỉ</label>
															<form:input class="form-control" path="diaChi"
																placeholder="địa chỉ" />
														</div>
													</div>


												</div>
											</div>
											<h4 class="form-section">
												<i class="ft-user"> thông tin làm việc</i>
											</h4>
											<div class="row">
												<div class="col-md-8">
													<div class="row">
														<div class="form-group col-sm-6">
															<label>phòng ban</label>

															<form:select path="phongBan" type="text" id="companyName"
																class="form-control" name="phongBanSelect">
																<option value="none" selected>Chọn Phòng ban</option>
																<c:forEach items="${listPhongBan}" var="x">
																	<option value="${x.maPhongBan}">${x.tenPhongBan}</option>
																</c:forEach>
															</form:select>
														</div>
														<div class="form-group col-sm-6">
															<label>chức danh</label>
															<form:select path="chucDanh" type="text" id="companyName"
																class="form-control" placeholder="Company Name"
																name="chucDanhSelect">
																<option value="none" selected="selected">Chọn
																	chức danh</option>
																<c:forEach items="${listChucDanh}" var="x">
																	<option value="${x.maChucDanh}">${x.tenChucDanh}</option>
																</c:forEach>
															</form:select>
														</div>
													</div>
													<div class="row">
														<div class="form-group col-sm-6">
															<label for="projectinput4">Ảnh đại diện</label>
															<form:input path="anhDaiDien" type="text"
																id="projectinput4" class="form-control"
																placeholder="ảnh đại diện" />
														</div>
														<div class="form-group col-sm-6">
															<label for="location1">Trạng Thái</label>
															<form:select class="custom-select form-control"
																path="trangThai">
																<form:option value="1">Còn
																		Hợp Đồng</form:option>
																<form:option value="2">Hết
																		Hợp Đồng</form:option>
															</form:select>
														</div>
													</div>

												</div>
											</div>
										</div>
										<div class="form-actions center">
											<input class="btn btn-success" type="submit" value="Save" />
											<%-- <a href="<c:url value = "/quanlynhansutt/add"/>"
												class="btn btn-primary">Back</a>
 											--%>
										</div>
									</form:form>
									<script type="text/javascript">
										window.onload = function() {

											console.log("aaa");
										}
										function clickComboboxThanhPho() {
											var maThanhPho = $("#thanhPhoId")
													.val();

											if (maThanhPho == 'noThanhPho') { // nếu người dùng chưa chọn thành phố

												$('#quanHuyenId option')
														.remove();
												$('#quanHuyenId')
														.append(
																$(
																		'<option>',
																		{
																			value : 'noQuanHuyen',
																			text : 'Chọn Quận Huyện'
																		}));

												$('#quanHuyenId').prop(
														'disabled', true); /*disable combobox quận huyện */

											} else { // nếu người dùng đã chọn thành phố

												$('#quanHuyenId').prop(
														'disabled', false); /*enable combobox quận huyện */
												$('#quanHuyenId option')
														.remove(); /* xóa những option quận huyện cũ */
											}

											$
													.ajax({
														url : "/ffse-fbms/quanlynhansutt/ho_so/selectquan/"
																+ maThanhPho,
														dataType : "json",
														success : function(data) {
															/* alert("Hello! I am an alert box!"); */
															$('#quanHuyenId')
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

														}
													});
										};
									</script>

									<script type="text/javascript">
									<!-- ajax select QuanHuyen -->
										function clickComboboxQuan() {
											var maQuanHuyen = $("#quanHuyenId")
													.val();
											if (maQuanHuyen == 'noQuanHuyen') { /* nếu người dùng chưa chọn quận huyện */
												$('#phuongXaId').prop(
														'disabled', true); /*disable combobox phường xã */

											} else { /* nếu người dùng đã chọn quận huyện*/

												$('#phuongXaId').prop(
														'disabled', false); // enable combobox phường xã
												$('#phuongXaId option')
														.remove(); // xóa những option phường xã cũ
											}

											$
													.ajax({
														url : "/ffse-fbms/quanlynhansutt/ho_so/selectphuong/"
																+ maQuanHuyen,
														dataType : "json",
														success : function(data) {
															/* alert("Hello! I am an alert box!"); */

															$('#phuongXaId')
																	.append(
																			$(
																					'<option>',
																					{
																						value : 'noPhuongXa',
																						text : 'Chọn phường xã'
																					}));

															for (var i = 0; i < data.length; i++) {
																$('#phuongXaId')
																		.append(
																				$(
																						'<option>',
																						{
																							value : data[i].maXa,
																							text : data[i].tenXa
																						}));
															}

														}
													});
										};
									</script>
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