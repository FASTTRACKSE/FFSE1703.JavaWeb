<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<!-- ///////////////////////////////////////////////////////// -->


<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Danh sách Khách Hàng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/khachhang/list-khachhang" />'>Danh
									sách Khách Hàng</a></li>

						</ol>
					</div>
				</div>
			</div>
		</div>
		<hr>
		<!-- End Path -->

		<div class="content-body">
			<div class="x_panel">
				<div class="x_title">
					<a class="btn btn-outline-success round btn-min-width mr-1 mb-1"
						href="<c:url value="/mvpquanliduan/khachhang/show-form-add" />">
						<h5class="ft-plus-circle">Thêm Khách Hàng
						</h5>
					</a>
				</div>
				<div class="x_content">

					<table class="table table-striped"
						style="text-align: center">
						<thead>
							<tr>
								<th style="text-align: center">ID</th>
								<th style=" text-align: center">Tên khách hàng</th>
								<th style="text-align: center">Email</th>
								<th style="text-align: center">Số điện thoại</th>
								<th style="text-align: center">Giới tính</th>
								<th style="text-align: center">Địa chỉ</th>
								<th style="text-align: center">Chức năng</th>
								
							</tr>
						</thead>
						<tbody>
							<c:forEach var="khachHang" items="${listKhachHang}">
								<tr>
									<td style="text-align: left">${khachHang.idKhachHang}</td>
									<td style="text-align: left">${khachHang.fullname}</td>
									<td style="text-align: left">${khachHang.email}</td>
									<td style="text-align: left">${khachHang.phone}</td>
									<td style="text-align: left">${khachHang.gender}</td>
									<td style="text-align: left">${khachHang.address}</td>
									
									<td><a
										style="width: 50px; high: 50px; border-color: #00E5EE; border-radius: 100%;"
										class="btn btn-outline-info "
<<<<<<< HEAD
										href="<c:url value="/mvpquanliduan/khachhang/show-form-edit/${khachhang.idKhachHang }" />"
=======
										href="<c:url value="/mvpquanliduan/khachhang/show-form-edit/${khachHang.idKhachHang }" />"
>>>>>>> 8b94f4e29fb752d434d99a01d8a972e6481a723d
										title=""><i class="ft-edit"></i></a> <a
										onclick=" if(!confirm('Bạn muốn xóa nghiệp vụ này?')){return false;}"
										style="width: 50px; high: 50px; border-color: #FF6A6A; border-radius: 100%;"
										class="btn btn-outline-danger "
<<<<<<< HEAD
										href="<c:url value="/mvpquanliduan/khachhang/delete/${khachhang.idKhachHang }" />"
=======
										href="<c:url value="/mvpquanliduan/khachhang/delete/${khachHang.idKhachHang }" />"
>>>>>>> 8b94f4e29fb752d434d99a01d8a972e6481a723d
										title=""><i class="ft-delete"></i></a>
								</tr>

							</c:forEach>
							
									
								<!--<script type="text/javascript"> window.onload = alertName; </script>	  -->	
						
						</tbody>
						
					</table>
						<c:if test="${success != null }">
							${success}
						</c:if>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- ////////////////////////////////////////////////////////////////////////////-->

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />