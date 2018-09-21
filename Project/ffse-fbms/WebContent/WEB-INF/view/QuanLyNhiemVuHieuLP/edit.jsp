<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Sửa nhiệm vụ</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href='<c:url value="/home" />'>Home</a></li>
							<li class="breadcrumb-item"><a href='<c:url value="/HieuLP/" />'>Danh sách nhiệm vụ</a></li>
							<li class="breadcrumb-item active">Sửa nhiệm vụ</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="content-body">
			<div class="main-content">
				<div class="row">
				<c:url var="addAction" value="/HieuLP/update"></c:url>
					<form:form method="POST" modelAttribute="edit" action="${addAction}">
						<form:input type="hidden" path="ID" style="display:none"
							value="${nv.ID}" />
						<div class="form-group col-sm-6">
							<label>Dự án</label>
							<form:input class="form-control" path="duAn" value="${nv.duAn}" readonly="true" />
						</div>
						
						<div class="form-group col-sm-6">
							<label>Tên công việc</label>
							<form:input class="form-control" path="tenCongviec"
								value="${nv.tenCongviec}" />
						</div>
					<div class="form-group col-sm-6">
						  	<label>Loại công việc</label>
						 <form:select path="loaiCongviec" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${congviec}" var="ld">
									<form:option value="${ld.loaiCongviec}" label="${ld.loaiCongviec}" />
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
						  	<label>Trạng thái</label>
						 <form:select path="loaiTrangthai" class="custom-select block round"
								id="customSelect">
								<c:forEach items="${trangthai}" var="ld">
									<form:option value="${ld.loaiTrangthai}" label="${ld.loaiTrangthai}" />
								</c:forEach>
							</form:select>
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian bắt đầu</label>
							<form:input path="tgBatdau" value="${nv.tgBatdau}" type="date"
								id="issueinput3" class="form-control" />
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian kết thúc</label>
							<form:input path="tgKetthuc" value="${nv.tgKetthuc}" type="date"
								id="issueinput3" class="form-control" />
						</div>
						<div class="form-group col-sm-6">
							<label>Người được phân công</label>
								<form:input class="form-control" path="nguoiDuocphancong"
								value="${nv.nguoiDuocphancong}" />
						</div>
						<div class="form-group col-sm-6">
							<label>Thời gian dự kiến hoàn thành</label>
							<form:input path="tgDukienhoanthanh"
								value="${nv.tgDukienhoanthanh}" type="date" id="issueinput3"
								class="form-control" />
						</div>
						<div class="form-group col-sm-6">
							<label>Mô tả</label>
							<form:textarea path="moTa"  value="${nv.moTa}" id="issueinput8" rows="5" class="form-control" placeholder="Mô tả" />
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
