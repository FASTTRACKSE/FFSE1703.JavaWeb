<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/WEB-INF/view/templates/header.jsp" />
	<div class="app-content content container-fluid">
		<div class="content-wrapper">
			<!-- Path -->
			<div class="content-header row">
				<div class="content-header-left col-md-9 col-xs-12 mb-2">
					<h3 class="content-header-title mb-0">Danh Sách Trạng Thái</h3>
					<div class="row breadcrumbs-top">
						<div class="breadcrumb-wrapper col-xs-12">
							<ol class="breadcrumb">
								<li class="breadcrumb-item"><a
									href='<c:url value="/home" />'>Home</a></li>
								<li class="breadcrumb-item active">Danh Sách Trạng Thái</li>
							</ol>
						</div>
					</div>
				</div>
				<div class="content-header-right col-md-3 col-xs-12">
					<div role="group" aria-label="Button group with nested dropdown"
						class="btn-group float-md-right" id="add-new">
						<a class="btn btn-primary"
							href='<c:url value = "/TranDuc-QuanLyTaiLieu/TrangThai/add_formTT" />'><span
							data-i18n="" class="ft-plus-square">Thêm Mới</span></a>
					</div>
				</div>
			</div>
			<!-- End Path -->
			<div class="content-body">
				<div class="row">
					<div class="col-xs-12">
						<div class="card">
							<div class="card-header">
								<h4 class="card-title">Danh Sách Danh Mục</h4>
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
								<div class="card-block card-dashboard">
									<div class="table-responsive">
										<table id="datatable"
											class="table table-striped table-bordered dataex-res-constructor">
											<thead>
												<tr>
													<th>ID</th>
													<th>Mã Trạng Thái</th>
													<th>Tên Trạng Thái</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<div class="modal fade" id="confirm-delete" tabindex="-1"
													role="dialog" aria-labelledby="myModalLabel"
													aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">															<div class="modal-header">
																<button type="button" class="close" data-dismiss="modal"
																	aria-hidden="true">&times;</button>
																<h4 class="modal-title" id="myModalLabel">Bạn Có
																	Chắc Muốn Xóa</h4>
															</div>
															<div class="modal-body">
																<p>Bạn Có Chắc Muốn Xóa</p>
																<p class="debug-url"></p>
															</div>

															<div class="modal-footer">
																<button type="button" class="btn btn-default"
																	data-dismiss="modal">Quay Lại</button>
																<a class="btn btn-danger btn-ok">Xóa</a>
															</div>
														</div>
													</div>
												</div>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
</body>
</html>