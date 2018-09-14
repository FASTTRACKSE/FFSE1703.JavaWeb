<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html version="-//W3C//DTD HTML 4.01 Transitional//EN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css" />">
<script
	src="<c:url value="/resources/jquery/jquery-3.3.1.slim.min.js" />">
	
</script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<h3>
			<a href="<c:url value ="/add"/>">Add Student</a>
		</h3>
		<table>
			<thead>
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Họ Tên</th>
					<th scope="col">Năm Sinh</th>
					<th scope="col">Email</th>
					<th scope="col">Avatar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${listsv}">
					<tr>
						<th scope="row">${sv.id}</th>
						<td>${sv.ho_ten }</td>
						<td>${sv.nam_sinh }</td>
						<td>${sv.email }</td>
						<td><img style="width: 100px;"
							src='<c:url value = "/resources/upload/${sv.avatar}" ></c:url>'
							alt="image"></td>
						<td><a href="<c:url value ="/update/${sv.id }"/>"
							class="btn btn-success">
						</a> <a href="<c:url value ="/delete/${sv.id }"/>"
							onclick="return confirm('Bạn có muốn xóa sinh viên này?');"
							class="btn btn-danger">
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${page > 1 }">
				<li class="page-item"><a class="page-link"
					href="<c:url value ="/list/1"/>">
				</a></li>
				<li class="page-item"><a class="page-link"
					href="<c:url value ="/list/${page-1}"/>">${page-1}</a></li>
			</c:if>
			<li class="page-item"><a class="page-link" style="color: black;"
				href="#">${page}</a></li>
			<c:if test="${page < totalPage }">
				<li class="page-item"><a class="page-link"
					href="<c:url value ="/list/${page+1}"/>">${page+1}</a></li>
				<li class="page-item"><a class="page-link"
					href="<c:url value ="/list/${total}"/>">
				</a></li>
			</c:if>
		</ul>
		</nav>
	</div>
</body>
</html>