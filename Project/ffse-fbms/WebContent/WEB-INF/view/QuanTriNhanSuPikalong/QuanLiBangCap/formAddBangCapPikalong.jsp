<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm Bằng Cấp</h3>
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
											action="save"
											class="form-horizontal">
										
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Chuyên Ngành</label>
													<form:input path="chuyenNganh" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="chuyenNganh"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Xếp Loại</label>
													<form:input path="xepLoai" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="xepLoai"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Nơi Cấp</label>
													<form:input path="noiCap" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="noiCap"
														cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Mã Nhân Viên</label>
													<form:input path="maNV" type="text" id="roundText"
														class="form-control round" />
													<form:errors path="maNV" cssStyle="color:red;display:block"></form:errors>
												</div>
											</div>
											<div class="col-xl-4 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<label for="roundText">Ngày Cấp</label>
													<div class="position-relative has-icon-left">
														<form:input path="ngayCap" type="date" id="roundText"
															class="form-control round" />
														<form:errors path="ngayCap"
															cssStyle="color:red;display:block"></form:errors>
														<div class="form-control-position">
															<i class="ft-message-square"></i>
														</div>
													</div>
												</div>
											</div>
											<div class="col-xl-6 col-lg-6 col-md-12 mb-1">
												<div class="form-group">
													<input class="btn btn-success" type="submit" value="Save" />
													<a class="btn btn-info"
														href="/ffse-fbms/QuanTriNhanSuPikalong/QuanLiBangCap/listBangCapPikalong">View</a>
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