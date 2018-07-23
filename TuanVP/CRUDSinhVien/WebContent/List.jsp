<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="${lang }" />
<fmt:setBundle basename="messages.messages"></fmt:setBundle>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><fmt:message key="tieude" /></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body class="container">
	<div class="dropdown">
		<button class="btn btn-secondary dropdown-toggle" type="button"
			id="dropdownMenuButton" data-toggle="dropdown">
			<fmt:message key="ngonngu" />
		</button>
		<div class="dropdown-menu">
			<a class="dropdown-item" href="list?lang=vi"> <fmt:message
					key="tiengviet" />
			</a> <a class="dropdown-item" href="list?lang=en"> <fmt:message
					key="tienganh" />
			</a>
		</div>
	</div>
	<h1 style="text-align: center;">
		<fmt:message key="tieude" />
	</h1>
	<h3>
		<a href="${pageContext.request.contextPath }/new"><fmt:message
				key="them" /></a>
	</h3>
	<table class="table table-striped ">
		<thead class="thead-dark">
			<tr>
				<th scope="col"><fmt:message key="id" /></th>
				<th scope="col"><fmt:message key="hodem" /></th>
				<th scope="col"><fmt:message key="ten" /></th>
				<th scope="col"><fmt:message key="ngaysinh" /></th>
				<th scope="col"><fmt:message key="gioitinh" /></th>
				<th scope="col"><fmt:message key="quequan" /></th>
				<th scope="col"><fmt:message key="lophoc" /></th>
				<th scope="col"><fmt:message key="diemlp1" /></th>
				<th scope="col"><fmt:message key="diemlp2" /></th>
				<th scope="col"><fmt:message key="diemtb" /></th>
				<th scope="col"><fmt:message key="xeploai" /></th>
				<th scope="col"><fmt:message key="hanhdong" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sv" items="${listSinhVien}">
				<tr>
					<th scope="row"><c:out value="${sv.id}" /></th>
					<td><c:out value="${sv.hodem }" /></td>
					<td><c:out value="${sv.ten }" /></td>
					<td><c:out value="${sv.ngaysinh }" /></td>
					<td><c:out value="${sv.gioitinh }" /></td>
					<td><c:out value="${sv.quequan }" /></td>
					<td><c:out value="${sv.lop }" /></td>
					<td><c:out value="${sv.diemlp1 }" /></td>
					<td><c:out value="${sv.diemlp2 }" /></td>
					<td><c:out value="${sv.diemtb }" /></td>
					<td><c:out value="${sv.xeploai }" /></td>
					<td><a
						href="${pageContext.request.contextPath }/edit?id=<c:out value='${sv.id}' />"><fmt:message
								key="sua" /></a> &nbsp;&nbsp;&nbsp;&nbsp; <a
						href="${pageContext.request.contextPath }/delete?id=<c:out value='${sv.id}' />"><fmt:message
								key="xoa" /></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
	<ul class="pagination">
		<li class="page-item"><a class="page-link" href="list?page=1&lang=${lang}"><fmt:message
					key="trangdau" /></a></li>
		<c:if test="${page > 1 }">
			<li class="page-item"><a class="page-link"
				href="list?page=${page-1}&lang=${lang}"> << </a></li>
			<li class="page-item"><a class="page-link"
				href="list?page=${page-1}&lang=${lang}">${page-1}</a></li>
		</c:if>
		<li class="page-item"><a class="page-link" style="color: black;"
			href="#">${page }</a></li>
		<c:if test="${page < totalPage }">
			<li class="page-item"><a class="page-link"
				href="list?page=${page+1}&lang=${lang}">${page+1}</a></li>
			<li class="page-item"><a class="page-link"
				href="list?page=${page+1}&lang=${lang}"> >> </a></li>
		</c:if>
		<li class="page-item"><a class="page-link"
			href="list?page=${totalPage}&lang=${lang}"><fmt:message key="trangcuoi" /></a></li>
	</ul>
	</nav>
</body>
</html>