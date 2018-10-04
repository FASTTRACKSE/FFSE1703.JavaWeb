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
				<h3 class="content-header-title mb-0">Duyệt đánh giá</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href="<c:url value = "/quantridanhgia/home/"/>">Quản trị
									đánh giá</a></li>
							<li class="breadcrumb-item active">Duyệt đánh giá</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="card">
				<c:if test="${empty listNhanVien }">
					<div class="card-body" style="margin: 1em">
						<h3>Chưa có đánh giá nào từ nhân viên</h3>
					</div>
				</c:if>
				<c:if test="${not empty listNhanVien }">
					<div class="card-header">
						<h4 class="card-title">Danh sách đánh giá</h4>
					</div>
					<div class="card-content">
						<div class="card-body" style="margin: 1em">
							<div class="table-responsive">
								<table class="table">
									<thead class="thead-dark">
										<tr>
											<th scope="col">#</th>
											<th scope="col">Nhân viên</th>
											<th scope="col">Đánh giá tổng thể</th>
											<th scope="col">Hành động</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listNhanVien }" var="x" varStatus="stt">
											<tr>
												<th scope="row">${stt.index +1}</th>
												<td>${x.nhanVien.tenNhanVien}</td>
												<td>${x.danhGiaTongThe }</td>
												<td><a class="btn btn-primary"
													href="<c:url value="/quantridanhgia/truongphong/duyetdanhgia/view/${x.id }" />">Đánh
														giá</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<ul class="pagination firstLast1-links">
									<c:if test="${pageDDG > 1 }">
										<li class="page-item first"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/1" />"
											class="page-link">First</a></li>
										<li class="page-item prev"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/${pageDDG-1 }" />"
											class="page-link">Prev</a></li>
										<li class="page-item prev"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/${pageDDG-1 }" />"
											class="page-link">${pageDDG-1 }</a></li>
									</c:if>
									<li class="page-item active"><a href="#" class="page-link">${pageDDG}</a></li>
									<c:if test="${pageDDG < total }">
										<li class="page-item next"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/${pageDDG+1 }" />"
											class="page-link">${pageDDG+1 }</a></li>
										<li class="page-item next"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/${pageDDG+1 }" />"
											class="page-link">Next</a></li>
										<li class="page-item last"><a
											href="<c:url value="/quantridanhgia/phongnhansu/danhsachdanhgia/${total}" />"
											class="page-link">Last</a></li>
									</c:if>
								</ul>
							</div>
						</div>
				</c:if>
			</div>
		</div>
	</div>
</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp"></jsp:include>