<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<div class="content-body">
			<div class="main-content">

				<form:form method="POST" modelAttribute="suachoduyet">
					<div class="row">
						<div class="form-group col-sm-6">
							 <form:hidden path="ngayNghi.soNgayDaNghi"/>
							<form:hidden path="ngayNghi.soNgayConLai"/> 
							<div>
								<label><spring:message code="label.madon"/></label>
								<form:input class="form-control round" path="id" readonly="true" />
							</div>
							<div>
								<label><spring:message code="label.maNhanVien"/></label>
								<form:select path="ngayNghi.maNhanVien"
									class="custom-select block round" id="customSelect">
									<c:forEach items="${hoso}" var="ld">
										<form:option value="${ld.maNhanVien}" label="${ld.maNhanVien}" />
									</c:forEach>
								</form:select>
							</div>
							<div>
								<label><spring:message code="label.ngaybatdau"/></label>
								<fieldset class="form-group position-relative">
									<form:input type="date" class="form-control round" id="from"
										path="ngayBatDau" />
									<div class="form-control-position">
										<i class="fa fa-calendar-o"></i>
									</div>
								</fieldset>
							</div>
							<div>
								<label><spring:message code="label.ghichu"/></label>
								<form:input class="form-control round" path="ghiChu" />
							    <form:errors style="color:red" path="ghiChu"  /> 
							</div>
						</div>

						<div class="form-group col-sm-6">

							<div>
								<label><spring:message code="label.lydo"/></label>
								<form:select path="lyDo.id" class="custom-select block round"
									id="customSelect">
									<c:forEach items="${lydo}" var="ld">
										<form:option value="${ld.id}" label="${ld.lyDo}" />
									</c:forEach>
								</form:select>
							</div>
							<div>

								<label><spring:message code="label.songaynghi"/></label>
								<form:input class="form-control round" path="soNgayNghi" />
								<form:errors style="color:red" path="soNgayNghi"  />
							</div>
							<div>
								<label><spring:message code="label.ngayketthuc"/></label>
								<fieldset class="form-group position-relative">
									<form:input type="date" class="form-control round" id="from"
										path="ngayKetThuc" />
									<div class="form-control-position">
										<i class="fa fa-calendar-o"></i>
									</div>
								</fieldset>
							</div>
							<div>
								<label><spring:message code="label.ghichutruongphong"/></label>
								<form:input class="form-control round" path="ghiChuTruongPhong" />
								 <form:errors style="color:red" path="ghiChuTruongPhong"  /> 
								
							</div>
						</div>
						<div>
							<div class="col-md-2">
								<button type=submit  class="btn btn-outline-danger round  mr-1 mb-1"
									formaction="<%=request.getContextPath()%>/Quanlyvangnghi1703004/updatenhap/tuchoi"><spring:message code="label.tuchoi"/></button>
							</div>
							<div class="col-md-4">
								<div class="col-md-2">
									<button type="submit" class="btn btn-outline-success round  mr-1 mb-1"
										formaction="<%=request.getContextPath()%>/Quanlyvangnghi1703004/updateduyet/duyet"><spring:message code="label.duyet"/></button>
								</div>
							</div>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>
</div>


<jsp:include page="/WEB-INF/view/templates/footer.jsp" />