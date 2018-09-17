<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">

		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>
					<strong>THÊM DATABASE</strong>
				</h1>
			</div>
		</div>
		<form:form method="POST" action="/ffse-fbms/qlda/Famework/creat">
			<div class="form-group col-sm-6">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> 
				<label>Mã Database</label>
				<form:input class="form-control" path="maDatabase" readonly="true"
					placeholder="Mã Database" />
				<form:errors path="maDatabase" cssStyle="color: red"></form:errors>

			</div>
			<div class="form-group col-sm-6">
				<label>Tên Database</label>
				<form:input class="form-control" path="tenDatabase"
					placeholder="Tên Database " />
				<form:errors path="tenDatabase" cssStyle="color: red"></form:errors>
			</div>
			<div class="col-sm-12 text-center">
				<button type="submit" class="btn btn-success">Lưu thông tin</button>
			</div>
		</form:form>
	</div>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
