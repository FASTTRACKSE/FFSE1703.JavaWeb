<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-12 mb-2">
				<h3 class="content-header-title mb-0">Update Bằng Cấp</h3>
			</div>
		</div>
		<div class="content-body">
			<!-- Basic Elements start -->
			<section class="basic-elements">
				<div class="row">
					<div class="col-md-12">
						<div>
							<div>
								<div>
									<div class="row">
										<form:form method="post"
											action="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiGiaDinh/editOneGiaDinh"
											class="form-horizontal">
											<form:hidden path="id" />
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Mã Nhân Viên</label>
													<form:input path="maNV" type="text"
														class="form-control round" readonly="true" />
													<form:errors path="maNV" cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Quan Hệ</label>
													<form:select path="quanHe" class="form-control round">
														<form:option value="">Chọn Quan Hệ</form:option>
														<form:option value="Bố">Bố</form:option>
														<form:option value="Mẹ">Mẹ</form:option>
														<form:option value="Anh">Anh</form:option>
														<form:option value="Chị">Chị</form:option>
														<form:option value="Em">Em</form:option>
														<form:option value="Vợ">Vợ</form:option>
													</form:select>
													<form:errors path="quanHe"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Họ Tên</label>
													<form:input path="hoTen" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="hoTen"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Quê Quán</label>
													<form:input path="queQuan" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="queQuan"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Nơi Ở Hiện Nay</label>
													<form:input path="noiOHienNay" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="noiOHienNay"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Nghề Nghiệp</label>
													<form:input path="ngheNghiep" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="ngheNghiep"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">SDT</label>
													<form:input path="sdt" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="sdt"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-12 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<input class="btn btn-outline-success round" type="submit" value="Save" />
													<a class="btn btn-outline-info round"
														href="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiGiaDinh/viewOneGiaDinh/${maNv}">View</a>
												</div>
											</div>
										</form:form>
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
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />