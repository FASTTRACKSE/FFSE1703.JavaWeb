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
						<form:form cssClass="form" action="kydanhgia/save">
							<form:hidden path="maKy" />
							<div class="form-body">
								<h4 class="form-section">
									<i class="fa fa-plus"></i>Tạo danh sách đánh giá
								</h4>
								<div class="row">
									<div class="col-md-4">
										<div class="form-group">
											<label for="projectinput1">Kỳ đánh giá</label>
											<form:input cssClass="form-control" path="tenKy" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group">
											<label for="projectinput2">Mô tả</label>
											<form:input cssClass="form-control" path="moTa" />
										</div>
									</div>
									<div class="col-md-4">
										<div class="form-group" style="padding-top: 1.9rem">
											<c:if test="${command.maKy == 0 }">
												<button class="btn btn-primary" type="submit">Tạo</button>
											</c:if>
											<c:if test="${command.maKy != 0 }">
												<button class="btn btn-primary" type="submit">Sửa</button>
												<a class="btn btn-danger"
													href="<c:url value = "/quantridanhgia/phongnhansu/kydanhgia"/>">Hủy</a>
											</c:if>
										</div>
									</div>
									<form:hidden path="isDelete" />
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		<c:if test="${not empty listKyDanhGia}">
			<div class="row">
				<div class="card">
					<div class="card-header">
						<h4 class="card-title">Danh sách kỳ đánh giá</h4>
					</div>
					<div class="card-content">
						<div class="card-body" style="margin: 1em">
							<div class="table-responsive">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">Kỳ đánh giá</th>
											<th scope="col">Thông tin</th>
											<th scope="col">Hành động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listKyDanhGia }" var="x" varStatus="stt" >
											<tr>
												<th scope="row">${stt.index + 1}</th>
												<td>${x.tenKy }</td>
												<td>${x.moTa }</td>
												<td><a class="btn btn-info"
													href="<c:url value = "/quantridanhgia/phongnhansu/kydanhgia/edit/${x.maKy }"/>">Sửa</a></td>
											</tr>
										</c:forEach>
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