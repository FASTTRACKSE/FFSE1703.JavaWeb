<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<h3 class="content-header-title mb-0">Kinh Nghiệm Dự Án Của Nhân
			Viên</h3>
		<div class="row breadcrumbs-top">
			<div class="breadcrumb-wrapper col-xs-12">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/" />'>Danh
							Sách Nhân Viên</a></li>
					<li class="breadcrumb-item"><a
						href='<c:url value="/quantrinhansu/hosonhanvien/view/${maNv }" />'>Thông
							Tin Nhân Viên</a></li>
					<li class="breadcrumb-item active">Kinh Nghiệm Dự Án Nhân Viên</li>
				</ol>
			</div>
		</div>
		<div class="table-responsive">
			<table class="table mb-0">
				<thead>
					<tr>
						<th>Tên Dự Án</th>
						<th>Vai Trò</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="knda" items="${viewOne}">
						<tr>
							<td>${knda.projects.nameProject}</td>
							<td>${knda.roles.nameRoles}</td>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/view/templates/footer.jsp" />