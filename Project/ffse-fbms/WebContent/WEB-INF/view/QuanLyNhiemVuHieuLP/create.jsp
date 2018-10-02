<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<!-- Path -->
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0"><spring:message code="label.themmoinhiemvu"/></h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a
								href='<c:url value="/home" />'><spring:message code="label.trangchunhiemvu"/></a></li>
							<li class="breadcrumb-item"><a
								href='<c:url value="/HieuLP/" />'><spring:message code="label.danhsachnhiemvu"/></a></li>
							<li class="breadcrumb-item active"><spring:message code="label.themmoinhiemvu"/></li>
						</ol>
					</div>
				</div>
			</div>
		</div>
		<!-- End Path -->

		<div class="row match-height">
			<div class="col-md-12">
				<div class="card">
				<div class="card-header">
							<h4 class="content-header-title mb-0" style="margin-left: 450px"><b><spring:message code="label.themmoinhiemvu"/></b></h4><hr>
					<div class="content-body">
						<div class="main-content">
							<div class="row">
								<c:if test="${messageError ne null}">
									<div class="alert alert-danger alert-dismissable" role="alert">
										<button type="button" class="close" data-dismiss="alert">
											<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
										</button>
										${messageError}
									</div>
								</c:if>


								<form:form method="POST" modelAttribute="add" action="add">
									<div class="form-group col-sm-6">
										<label><spring:message code="label.duannhiemvu"/></label>
										<form:select path="duAn.maDuan"
											class="custom-select block " id="customSelect">
											<option value="0" label="<spring:message code="label.chonduannhiemvu"/>" />
											<c:forEach items="${duan}" var="ld">
												<form:option value="${ld.maDuan}" label="${ld.tenDuan}" />
											</c:forEach>
										</form:select>

									</div>
									<div class="form-group col-sm-6">
										<label><spring:message code="label.loaicongviecnhiemvu"/></label>
										<form:select path="idLoaiCongviec.IDcongviec"
											class="custom-select block " id="customSelect">
											<option value="0" label="<spring:message code="label.choncongviecnhiemvu"/>" />
											<c:forEach items="${congviec}" var="ld">
												<form:option value="${ld.IDcongviec}"
													label="${ld.loaiCongviec}" />
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group col-sm-6">
										<label><spring:message code="label.tencongviec"/></label>
										<form:input class="form-control block "
											path="tenCongviec" placeholder="Tên công việc" />
										<form:errors path="tenCongviec" cssClass="error" />
									</div>
									<div class="form-group col-sm-6">
										<label><spring:message code="label.trangthainhiemvu"/></label> <input
											class="form-control block " readonly value="<spring:message code="label.moinhiemvu"/>" />
										<form:hidden path="idLoaiTrangthai.IDtrangthai" value="1" />
									</div>
									<div class="form-group col-sm-3">
										<label><spring:message code="label.tgbatdau"/></label>
										<form:input path="tgBatdau" type="date" id="issueinput3"
											class="form-control block " style="width:240px" />
										<form:errors path="tgBatdau" cssClass="error" />
									</div>
									<div class="form-group col-sm-3">
										<label><spring:message code="label.tgketthuc"/></label>
										<form:input path="tgKetthuc" type="date" id="issueinput3"
											class="form-control block " style="width:240px;" />
										<form:errors path="tgKetthuc" cssClass="error" />
									</div>
									<div class="form-group col-sm-6">
										<label><spring:message code="label.nguoiduocphancong"/></label>

										<form:select path="nhanVien.maNhanVien"
											class="custom-select block " id="customSelect">
											<option value="0" label="<spring:message code="label.chonnhanviennhiemvu"/>" />
											<c:forEach items="${nhanVienHLP}" var="ld">
												<form:option value="${ld.maNhanVien}"
													label="${ld.hoDem} ${ld.ten}" />
											</c:forEach>
										</form:select>
									</div>
									<div class="form-group col-sm-12">
										<label><spring:message code="label.motanhiemvu"/></label>
										<form:textarea path="moTa" id="issueinput8" rows="5"
											class="form-control" placeholder="Mô tả" />
										<form:errors path="moTa" cssClass="error" />
									</div>

									<div class="form-group col-sm-3">
										<label><spring:message code="label.tgdukienhoanthanh"/></label>
										<div class="input-group">
											<form:input class="form-control block "
												path="tgDukienhoanthanh"
												placeholder="Thời gian dự kiến hoàn thành	"
												style="width:240px;"></form:input>
											<form:errors path="tgDukienhoanthanh" cssClass="error" />
											<span class="input-group-addon"><spring:message code="label.gionhiemvu"/></span>
										</div>

									</div>


									<div class="col-sm-12 text-center">
										<button type="submit" class="btn btn-success"><spring:message code="label.luunhiemvu"/></button>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	window.setTimeout(function() {
		$(".alert").fadeTo(500, 0).slideUp(500, function() {
			$(this).remove();
		});
	}, 2500);
</script>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
