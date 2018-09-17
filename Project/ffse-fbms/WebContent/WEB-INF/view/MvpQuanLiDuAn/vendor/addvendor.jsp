	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới nhà cung cấp</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/mvpquanliduan/domain/listdomain" />'>Danh
									sách nhà cung cấp</a></li>
							<li class="breadcrumb-item active">Thêm mới nhà cung cấp</li>
						</ol>
					</div>
				</div>
			</div>
		</div>

		<hr>
		<!-- End Path -->

		<div class="justify-content-md-center" style="width: 95%">
                     <form:form method="post" action="">
                        <h4 class="form-section"><i class="ft-clipboard"></i> Nhà cung cấp</h4>
                        <div class="row">
                          <div class="form-group col-12 mb-2">
                            <label for="projectinput5">Nhà cung câp</label>
                            <form:input class="form-control" path="nameVendor" placeholder="nhà cung cấp" />
                           
                          </div>
                        </div>
                        <div class="row">
                          <div class="form-group col-md-6 mb-2">
                            <label for="projectinput6">Điện thoại</label>
                           <form:input class="form-control" path="phone" placeholder="Điện thoại" />
                          </div>
                          <div class="form-group col-md-6 mb-2">
                            <label for="projectinput7">Email</label>
                            <form:input class="form-control" path="email" placeholder="Email" />
                          </div>
                        </div>
                        <div class="row">
                          <div class="form-group col-12 mb-2">
                            <label>Địa chỉ</label>
                            <form:input class="form-control" path="address" placeholder="Địa chỉ" />
                          </div>
                        </div>
                        <div class="col-sm-12 text-center">
                        
							<button type="button" class="btn btn-outline-primary btn-lg mr-1 mb-1 btn-block"><i class="fa fa-check-circle"></i> Lưu thông tin</button>
						</div>
                       
                      </div>
                      </form:form>
				</div>

			</div>

<!-- ////////////////////////////////////////////////////////////////////////////-->			

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
