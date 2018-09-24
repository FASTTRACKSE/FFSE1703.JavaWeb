<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />

<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<div class="content-header row">
			<div class="content-header-left col-md-6 col-xs-12 mb-2">
				<h3 class="content-header-title mb-0">Thêm Dự Án</h3>
				<div class="row breadcrumbs-top">
					<div class="breadcrumb-wrapper col-xs-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="/ffse-fbms/home">Home</a></li>
							<li class="breadcrumb-item"><a href="/ffse-fbms/qlda/DuAn/">Danh
									sách Dự Án</a></li>
							<li class="breadcrumb-item active">Thêm dự án</li>
						</ol>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<h1>
				<strong>THÊM DỰ ÁN</strong>
			</h1>
		</div>
	</div>
	<form:form method="POST" action="/ffse-fbms/qlda/DuAn/creat"
		modelAttribute="duAn">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<form:hidden class="form-control" path="maDuAn" placeholder="maDuAn"
			readonly="true" />
		<form:errors path="maDuAn" cssStyle="color: red"></form:errors>

		<div class="form-group col-sm-6">
			<label>Tên dự án</label>
			<form:input class="form-control" path="tenDuAn"
				placeholder="Tên dự án" readonly="true" />
			<form:errors path="tenDuAn" cssStyle="color: red"></form:errors>
		</div>

		<div class="form-group col-sm-6">
			<label>Tên dự án</label>
			<form:input class="form-control" path="tenDuAn"
				placeholder="Tên dự án" readonly="true" />
			<form:errors path="tenDuAn" cssStyle="color: red"></form:errors>
		</div>
		<div class="form-group col-sm-6">
			<label>Start Date</label>
			<form:input path="startDate" cssClass="form-control round"
				type="date" />
			<form:errors path="startDate" cssStyle="color: red"></form:errors>
			<div class="help-block"></div>
		</div>
		<div class="form-group col-sm-6">
			<label>End Date</label>
			<form:input path="endDate" cssClass="form-control round" type="date" />
			<form:errors path="endDate" cssStyle="color: red"></form:errors>
			<div class="help-block"></div>
		</div>

		<div class="form-group col-sm-6">
			<label>Mô tả dự án</label>
			<form:textarea path="moTaDuAn" cssClass="form-control round" />
			<form:errors path="moTaDuAn" cssStyle="color: red"></form:errors>
		</div>

		<div class="form-group col-sm-6">
			<label>Tên Database</label>

			<form:select path="database" cssClass="form-control round"
				mutiple="true">
				<c:forEach items="${database}" var="db">
					<option value="${db.maDatabase }"
						<c:forEach items="${database}" var="dbs">
					    </c:forEach>>${db.tenDatabase }
					</option>
				</c:forEach>
			</form:select>
			<label>Tên Khách Hàng</label>
			<form:select path="KhachHang" cssClass="form-control round"
				mutiple="true">
				<c:forEach items="${khachhang}" var="kh">
					<option value="${kh.makh }">${kh.tenkh}</option>
				</c:forEach>
			</form:select>
		</div>

		<div class="form-group col-sm-6">
			/////////

		</div>
		<div class="col-sm-12 text-center">
			<button type="submit" class="btn btn-success">Lưu thông tin</button>
		</div>

	</form:form>
	<div class="col-sm-4">
		<c:if test="${message !=null }">
						 ${message }
			</c:if>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
