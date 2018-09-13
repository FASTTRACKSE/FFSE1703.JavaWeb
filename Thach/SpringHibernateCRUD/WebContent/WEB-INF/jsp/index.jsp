<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></link>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.tableUpdated {
	width: 90% !important;
	margin: 17px 58px 0 !important;
}

.btnSpace {
	margin: 17px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<a href="?lang=en_US">English</a>
<a href="?lang=vi">Tiếng Việt</a>
	<div class="container">
		<h2 style="text-align: center"><spring:message code="liststudent" /></h2>
		<a href="addSv"><button class="btn btn-success"><spring:message code="add" /></button></a>
		<table class="table table-hover">
			<tr>
				<th><spring:message code="codestudent" /></th>
				<th><spring:message code="fullname" /></th>
				<th><spring:message code="birthyear" /></th>
				<th><spring:message code="email" /></th>
				<th><spring:message code="phone" /></th>
				<th><spring:message code="address" /></th>
				<th><spring:message code="class" /></th>
				<th><spring:message code="avatar" /></th>
				<th><spring:message code="action" /></th>
			</tr>
			<c:forEach var="x" items="${listSinhVien}">
				<tr>
					<td>${x.maSv}</td>
					<td>${x.ten}</td>
					<td>${x.namSinh}</td>
					<td>${x.email}</td>
					<td>${x.sdt}</td>
					<td>${x.diaChi}</td>
					<td>${x.lop}</td>
					<td><img alt="ảnh"
						src="<c:url  value="/image/${x.hinhAnh}"/>" width="70"
						height="90"></td>
					<td><a href="editSv/${x.id}"><button
								class="btn btn-edit"><spring:message code="edit" /></button></a> &nbsp; &nbsp; <a
						href="deleteSv/${x.id}"><button class="btn btn-danger"
								onclick="if (!confirm('<spring:message code="deletestudent" />')) return false"><spring:message code="delete" /></button></a>
					</td>
				</tr>

			</c:forEach>
		</table>


		<c:if test="${pageIndex > 1}">
			<a href="1"><spring:message code="first" /></a>
			<a href="${pageIndex - 1}">
				<button class="btn btn-default">${pageIndex - 1}</button>
			</a>
		</c:if>

		<a href="${pageIndex}"><button class="btn btn-success">${pageIndex}</button></a>

		<c:if test="${pageIndex < totalPage}">
			<a href="${pageIndex + 1}"><button class="btn btn-default">${pageIndex + 1}</button></a>
			<a href="${totalPage}"><spring:message code="last" /></a>
		</c:if>
	</div>
</body>
</html>
