<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách sinh viên</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script
	src="<c:url value="/resources/jquery/jquery-3.3.1.slim.min.js" />"></script>
<script src="<c:url value="/resources/popper/popper.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="dropdown" style="width: 20%">
			<button class="btn btn-success dropdown-toggle" type="button" 
					id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" 
					aria-expanded="false">
				<spring:message code="ngonngu" />
			</button>
			<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
				<a class="dropdown-item" href="?lang=vi">
					<spring:message code="tiengviet" />
				</a>
				<a class="dropdown-item" href="?lang=en">
					<spring:message code="tienganh" />
				</a>
			</div>
		</div>
		<div style="text-align: center;">
			<h1>
				<spring:message code="title1" />
			</h1>
		</div>
		<h3>
			<a href="/Spring_MVC_CRUD/add"><spring:message code="them" /></a>
		</h3>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col"><spring:message code="masv" /></th>
					<th scope="col"><spring:message code="tensv" /></th>
					<th scope="col"><spring:message code="namsinh" /></th>
					<th scope="col"><spring:message code="diachi" /></th>
					<th scope="col"><spring:message code="email" /></th>
					<th scope="col"><spring:message code="lophoc" /></th>
					<th scope="col"><spring:message code="anh" /></th>
					<th scope="col"><spring:message code="hanhdong" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${list }">
					<tr>
						<th scope="row">${sv.maSV}</th>
						<td>${sv.tenSV }</td>
						<td>${sv.namSinh }</td>
						<td>${sv.diaChi }</td>
						<td>${sv.email }</td>
						<td>${sv.lopHoc }</td>
						<td><img style="width: 100px;" src='<c:url value = "/resources/upload/${sv.avatar }" ></c:url>' alt="image"></td>
						<td>
							<a href="/Spring_MVC_CRUD/edit/${sv.maSV }" class="btn btn-success">
								<spring:message code="sua" />
							</a> 
							<a href="/Spring_MVC_CRUD/delete/${sv.maSV }" onclick="return confirm('Bạn có muốn xóa sinh viên này?');" class="btn btn-danger">
								<spring:message code="xoa" />
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${page > 1 }">
					<li class="page-item"><a class="page-link"
						href="/Spring_MVC_CRUD/list/1"> <spring:message
								code="trangdau" />
					</a></li>
					<li class="page-item"><a class="page-link"
						href="/Spring_MVC_CRUD/list/${page-1}">${page-1}</a>
					</li>
				</c:if>
				<li class="page-item">
					<a class="page-link"style="color: black;" href="#">${page }</a>
				</li>
				<c:if test="${page < total }">
					<li class="page-item">
						<a class="page-link" href="/Spring_MVC_CRUD/list/${page+1}">${page+1}</a>
					</li>
					<li class="page-item">
						<a class="page-link" href="/Spring_MVC_CRUD/list/${total}">
							<spring:message code="trangcuoi" />
						</a>
					</li>
				</c:if>
			</ul>
		</nav>
	</div>
</body>
</html>