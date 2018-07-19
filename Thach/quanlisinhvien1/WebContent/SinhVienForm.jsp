<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:choose>
	<c:when test="${not empty param.theLocale}">
		<c:set var="theLocale" value="${param.theLocale}" scope="session" />
	</c:when>
	<c:otherwise>
		<c:if test="${empty theLocale}">
			<c:set var="theLocale" value="${pageContext.request.locale}"
				scope="session" />
		</c:if>
	</c:otherwise>
</c:choose>

<fmt:setLocale value="${theLocale}" />

<fmt:setBundle basename="resources.Resource" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1>
			<fmt:message key="StudentsManagement" />
		</h1>
		<h2>
			<a class="btn btn-primary" href="new"><fmt:message
					key="AddNewStudents" /></a> &nbsp;&nbsp;&nbsp; <a
				class="btn btn-primary" href="list"><fmt:message
					key="ListAllStudents" /></a>

		</h2>
	</center>
	<div align="center" class="form-group container" >
		<c:if test="${Sv != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${Sv == null}">
			<form action="insert" method="post">
		</c:if>

		<caption>
			<h2>
				<c:if test="${Sv != null}">
                        Edit Sinh Viên
                    </c:if>
				<c:if test="${Sv == null}">
                        <fmt:message key="AddNewStudents" />
                    </c:if>
			</h2>
		</caption>
		<c:if test="${Sv != null}">
			<input class="form-control" type="hidden" name="id"
				value="<c:out value='${Sv.id}' />" />
		</c:if>
		<div class="form-group">
			<lable for="text">Mã Sinh Viên: </lable>
			<input class="form-control" type="text" name="masv" size="45"
				value="<c:out value='${Sv.masv}' />" />
		</div>
		<div class="form-group">
			<lable>Tên Sinh Viên:</lable>
			<input class="form-control" type="text" name="ten" size="45"
				value="<c:out value='${Sv.ten}' />" />
	</div>
	<div class="form-group">
		<lable>Ngày Sinh:</lable>
		<input class="form-control" type="text" name="ngaysinh"
			size="45" value="<c:out value='${Sv.ngaysinh}' />" />
		</div>
	<div class="form-group">
		<lable for="quequan">Quê Quán:</lable>
		<input class="form-control" type="text" name="quequan"
			size="45" value="<c:out value='${Sv.quequan}' />" />
	</div>
	<div class="form-group">
		<lable>Giới Tính:</lable>
		<input class="form-control" type="text" name="gioitinh"
			size="45" value="<c:out value='${Sv.gioitinh}' />" />
		</div>
	<div class="form-group">
		<lable>Lớp:</lable>
		<input class="form-control" type="text" name="lop" size="5"
			value="<c:out value='${Sv.lop}' />" />
	</div>
	<div class="form-group">
		<th>Điểm Lp1:</th>
		<input class="form-control" type="number" name="lp1" size="5"
			value="<c:out value='${Sv.lp1}' />" />
	</div>
	<div class="form-group">
		<th>Điểm Lp2:</th>
		<input class="form-control" type="number" name="lp2" size="5"
			value="<c:out value='${Sv.lp2}' />" />
	</div>
	<tr>
		<td colspan="2" align="center"><input class="btn btn-default"
			type="submit" value="Save" /></td>
	</tr>
	</form>
	</div>
</body>
</html>