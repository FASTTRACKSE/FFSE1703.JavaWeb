<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới khách hàng</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/mvpquanliduan/khachhang/listkhachhang" />'>Danh sách chức danh</a></li>
							<li class="breadcrumb-item active">Thêm mới khách hàng</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST"  action="" modelAttribute="khachHang">
						<div class="form-group col-sm-6">
						  	<label>Tên khách hàng</label>
						  	<form:input class="form-control" path="fullname" placeholder="Tên khách hàng" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Email</label>
						  	<form:input class="form-control" path="email" placeholder="Email" />
						  
						</div>
						<div class="form-group col-sm-6">
						  	<label>Số điện thoại</label>
						  	<form:input class="form-control" path="phone" placeholder="Phone" />
						  
						</div>
						<div class="form-group col-sm-6">
						  	<label>Giới tính</label>
						  	<form:input class="form-control" path="gender" placeholder="Giới tính" />
						  
						</div>
						<div class="form-group col-sm-6">
						  	<label>Ngày sinh</label>
						  	<form:input class="form-control" type="date" path="birthday" placeholder="Ngày sinh" />
						  
						</div>
						<div class="form-group col-sm-6">
						  	<label>Địa chỉ</label>
						  	<form:input class="form-control" path="address" placeholder="Địa chỉ" />
						  
						</div>
						
						<div class="col-sm-12 text-center">
							<button type="submit" class="btn btn-success">Lưu thông tin</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
