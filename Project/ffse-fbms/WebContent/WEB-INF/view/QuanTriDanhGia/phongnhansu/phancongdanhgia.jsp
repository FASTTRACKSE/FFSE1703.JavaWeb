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
							<li class="breadcrumb-item active">Đánh giá nhân viên</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${listDanhGia == '' }">
			<div class="row">
				<div class="card">
					<div class="card-content">
						<div class="card-body" style="margin: 1em">
							<form:form cssClass="form" action="">
								<div class="form-body">
									<h4 class="form-section">
										<i class="fa fa-plus"></i>Tạo danh sách đánh giá
									</h4>
									<div class="row">
										<div class="col-md-4">
											<div class="form-group">
												<label for="projectinput1">Kỳ đánh giá</label>
												<form:select path="kyDanhgia">
													<form:options items="${listKyDanhGia }" />
												</form:select>

											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<label for="projectinput2">Phòng ban</label>
												<form:select path="phongBan">
													<form:options items="${listPhongBan }" />
												</form:select>
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												<button class="btn btn-primary" type="submit">Tạo</button>
											</div>
										</div>
									</div>
								</div>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${listDanhGia !='' }">
			<div class="row">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Danh sách nhân viên cần đánh giá</h4>
					</div>
					<div class="card-content">
						<div class="card-body" style="margin: 1em">
							<div class="table-responsive">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">First Name</th>
											<th scope="col">Last Name</th>
											<th scope="col">Username</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row">1</th>
											<td>Mark</td>
											<td>Otto</td>
											<td>@mdo</td>
										</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>