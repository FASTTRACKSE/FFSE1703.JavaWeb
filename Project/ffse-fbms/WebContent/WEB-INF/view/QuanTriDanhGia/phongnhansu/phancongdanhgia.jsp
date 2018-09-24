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
		<div class="row">
			<div class="card">
				<div class="card-content">
					<div class="card-body" style="margin: 1em">
						<form:form cssClass="form" action="phancongdanhgia/create">
							<div class="form-body">
								<h4 class="form-section">
									<i class="fa fa-plus"></i>Tạo danh sách đánh giá
								</h4>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label for="projectinput1">Kỳ đánh giá</label>
											<form:select path="kyDanhGia" cssClass="form-control">
												<c:forEach items="${listKyDanhGia }" var="x">
													<form:option value="${x.maKy }" label="${x.tenKy}"></form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="projectinput2">Phòng ban</label>
											<form:select path="phongBan" cssClass="form-control">
												<c:forEach items="${listPhongBan }" var="x">
													<form:option value="${x.maPhongBan }"
														label="${x.tenPhongBan}"></form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" style="padding-top: 1.9rem">
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
		<c:if test="${empty listDanhGia}">
			<div class="row">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Danh sách đánh giá nhân viên</h4>
					</div>
					<div class="card-content">
						<div class="card-body" style="margin: 1em">
							<div class="table-responsive">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">Nhân viên</th>
											<th scope="col">Xếp loại</th>
											<th scope="col">Trang Thái</th>
											<th scope="col">Hành động</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<th scope="row">1</th>
											<td>Mark</td>
											<td>Otto</td>
											<td>Nháp</td>
											<td><a class="btn btn-info">Xem</a></td>
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