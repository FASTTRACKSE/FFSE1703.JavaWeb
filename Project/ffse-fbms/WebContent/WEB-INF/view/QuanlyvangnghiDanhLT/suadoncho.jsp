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

				<form:form method="POST" modelAttribute="suadoncho">
					<div class="row">
						<div class="form-group col-sm-6">
							<div>
								<label><spring:message code="label.madon"/></label>
								<form:input class="form-control round" path="id" readonly="true" />
								<form:hidden path="ngayNghi.soNgayDaNghi"/>
								<form:hidden path="ngayNghi.soNgayConLai"/>
							</div>
							<div>
								<label><spring:message code="label.maNhanVien"/></label>
								<form:select  path="ngayNghi.maNhanVien"  class="custom-select block round" id="customSelect"   >
									<c:forEach items="${hoso}" var="ld">
										<form:option value="${ld.maNhanVien}" label="${ld.maNhanVien}" readonly="true" />
									</c:forEach>
								</form:select>
							</div>
							<div>
								<label><spring:message code="label.ngaybatdau"/></label>
								<fieldset class="form-group position-relative">
									<form:input type="date" class="form-control round" id="from" readonly="true" path="ngayBatDau"  />
									<div class="form-control-position">
										<i class="fa fa-calendar-o"></i>
									</div>
								</fieldset>
							</div>
							<div>
								<label><spring:message code="label.ghichunhanvien"/></label>
								<form:input class="form-control round" readonly="true" path="ghiChu"  />
							    <form:errors style="color:red" path="ghiChu"  /> 
							</div>
						</div>

						<div class="form-group col-sm-6">

							<div>
								<label>Ly do</label>
								<form:select readonly="true"  path="lyDo.id" class="custom-select block round"
									id="customSelect">
									<c:forEach items="${lyDo}" var="ld">
										<form:option value="${ld.id}" label="${ld.lyDo}" />
									</c:forEach>
								</form:select>
							</div>
							<div>

								<label><spring:message code="label.songaynghi"/></label>
								<form:input class="form-control round" readonly="true" path="soNgayNghi" />
							</div>
							<div>
								<label><spring:message code="label.ngayketthuc"/></label>
								<fieldset class="form-group position-relative">
									<form:input type="date" class="form-control round" id="from" readonly="true" path="ngayKetThuc" />
									<div class="form-control-position">
										<i class="fa fa-calendar-o"></i>
									</div>
								</fieldset>
							</div>
							<div>
								<label><spring:message code="label.ghichutruongphong"/></label>
								<form:input class="form-control round" path="ghiChuTruongPhong" />
								
							</div>
						</div>
						<div>
							<div class="col-md-2">
								<button type=submit  class="btn btn-outline-danger round  mr-1 mb-1"
									formaction="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/updatechoduyet/tuchoi">Từ
									chối</button>
							</div>
							<div class="col-md-4">
								<div class="col-md-2">
									<button type="submit" class="btn btn-outline-success round  mr-1 mb-1"
										formaction="<%=request.getContextPath()%>/QuanlyvangnghiDanhLT/updatechoduyet/daduyet">Duyệt</button>
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