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
				<h3 class="content-header-title mb-0">Danh sách Kĩ thuật</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/vendor/list-vendor" />'>Danh
									sách Kĩ thuật</a></li>

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
						href="<c:url value="/mvpquanliduan/vendor/show-form-add" />">
						<h5class="ft-plus-circle">Thêm Kĩ thuật
						</h5>
					</a>
				</div>
				<div class="x_content">

					<table class="table table-striped"
						style=" text-align: center">
						<thead>
							<tr style="text-align: center">
								<th >Stt</th>
								<th>Nhà cung cấp</th>
								<th>Điên thoại</th>
								<th>Email</th>
								<th>Địa chỉ</th>
								<th style=" text-align: center">Chức năng</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="vendor" items="${listVendor}"
								varStatus="count">
								<tr>

									<th scope="row">${count.count}</th>
									<td style="text-align: left">${vendor.nameVendor}</td>
									<td style="text-align: left">${vendor.phone}</td>
									<td style="text-align: left">${vendor.email}</td>
									<td style="text-align: left">${vendor.address}</td>
									<td><a
										style="width: 50px; high: 50px; border-color: #00E5EE; border-radius: 100%;"
										class="btn btn-outline-info "
										href="<c:url value="/mvpquanliduan/vendor/show-form-edit/${vendor.idVendor }" />"
										title=""><i class="ft-edit"></i></a> <a
										onclick=" if(!confirm('Bạn muốn xóa nghiệp vụ này?')){return false;}"
										style="width: 50px; high: 50px; border-color: #FF6A6A; border-radius: 100%;"
										class="btn btn-outline-danger "
										href="<c:url value="/mvpquanliduan/vendor/delete/${vendor.idVendor }" />"
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
