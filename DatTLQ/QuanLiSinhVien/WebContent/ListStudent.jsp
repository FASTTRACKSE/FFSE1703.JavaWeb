<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:set var="lang" value="${not empty param.lang ? param.lang : not empty lang ? lang : pageContext.request.locale}" scope="session" />
	<div class="container">
		<h2></h2>
		<p></p>
		<a href="add">Thêm Sinh Viên</a>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>ID</th>
					<th>Họ Đệm</th>
					<th>Tên</th>
					<th>Ngày Sinh</th>
					<th>Giới Tính</th>
					<th>Quê Quán</th>
					<th>Lớp</th>
					<th>Điểm LP1</th>
					<th>Điểm LP2</th>
					<th>Điểm TB</th>
					<th>Xếp Loại</th>
					<th>Chức Năng</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="sv" items="${listStudent}">
					<tr>
						<td><c:out value="${sv.id}" /></td>
						<td><c:out value="${sv.firstName}" /></td>
						<td><c:out value="${sv.txtName}" /></td>
						<td><c:out value="${sv.txtDate}" /></td>
						<td><c:out value="${sv.txtSex}" /></td>
						<td><c:out value="${sv.queQuan}" /></td>
						<td><c:out value="${sv.txtLop}" /></td>
						<td><c:out value="${sv.lp1}" /></td>
						<td><c:out value="${sv.lp2}" /></td>
						<td><c:out value="${sv.getDTB()}" /></td>
						<td><c:out value="${sv.getXeploai()}" /></td>

						<td><a href="edit?id=<c:out value="${sv.id}" />">Edit</a>
						<a href="edit?id=<c:out value="${sv.id}" />">Delete</a></td>	
							
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<center>
		<a  href="student">First</a>
		<c:if test="${pageid > 1}">
				<a href="student?page=${pageid-1}"><</a> - 
			</c:if>
			<c:if test="${pageid > 1}">
				<a href="student?page=${pageid-1}">${pageid-1}</a> - 
			</c:if>
			${pageid}
			<c:if test="${pageid <lastPage}">
			 - <a href="student?page=${pageid+1}">${pageid+1}</a>
			 </c:if>
			 <c:if test="${pageid <lastPage}">
			 - <a href="student?page=${pageid+1}">></a>
			 </c:if>
			 <a  href="student?page=${lastPage}">Last</a>
		</center>
	</div>
</body>
</html>