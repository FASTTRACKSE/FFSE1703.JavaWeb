<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm mới nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/QuanTriHeThong/chuc_danh/" />'>Danh sách chức danh</a></li>
							<li class="breadcrumb-item active">Thêm mới nhiệm vụ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
					<form:form method="POST" modelAttribute="add" action="add">
						<div class="form-group col-sm-6">
						  	<label>Dự án</label>
						  	<form:input class="form-control" path="duAn" placeholder="Tên dự án" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Loại công việc</label>
						 <form:select path="loaiTrangthai" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${congviec}" var="ld">
									<form:option value="${ld.ID}" label="${ld.loaiCongviec}" />
								</c:forEach>
							</form:select>
						  	<form:errors path="loaiCongviec" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Tên công việc</label>
						  	<form:input class="form-control" path="tenCongviec" placeholder="Tên công việc" />
						  	<form:errors path="tenCongviec" cssClass="error" />
						</div>
							<div class="form-group col-sm-6">
						  	<label>Trạng thái</label>
							<form:input path="loaiTrangthai" class="form-control" readonly="true" value="Mới"/>
							<form:errors path="loaiTrangthai" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Thời gian bắt đầu</label>
						    <form:input path="tgBatdau" type="date" id="issueinput3" class="form-control" />
						  	<form:errors path="tgBatdau" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Thời gian kết thúc</label>
						  <form:input path="tgKetthuc" type="date" id="issueinput3" class="form-control" />
						  	<form:errors path="tgKetthuc" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Người được phân công</label>
						  	<form:input class="form-control" path="nguoiDuocphancong" placeholder="Người phân công" />
						  	<form:errors path="nguoiDuocphancong" cssClass="error" />
						</div>
						<div class="form-group col-sm-6">
						  	<label>Thời gian dự kiến hoàn thành</label>
						    <form:input path="tgDukienhoanthanh" type="date" id="issueinput3" class="form-control" />
						  	<form:errors path="tgDukienhoanthanh" cssClass="error" />
						</div>
							<div class="form-group col-sm-6">
						  	<label>Mô tả</label>
						  	<form:textarea path="moTa" id="issueinput8" rows="5" class="form-control" placeholder="Mô tả" />
						  	<form:errors path="moTa" cssClass="error" />
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
