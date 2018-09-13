<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Student</h1>
	
	<form:form action="/Hibernate_Spring/add" modelAttribute="sv" method="POST" >
		<table>
			<c:if test="${!empty sv.ho_ten}">
				<tr>
					<td><form:label path="id">
							<spring:message text="id" />
						</form:label></td>
					<td><form:input path="id" readonly="true" size="10"
							disabled="true" /> <form:hidden path="id" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="ho_ten">
						<spring:message text="ho_ten" />
					</form:label></td>
				<td><form:input path="ho_ten" /></td>
			</tr>
			<tr>
				<td><form:label path="nam_sinh">
						<spring:message text="nam_sinh" />
					</form:label></td>
				<td><form:input path="nam_sinh" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message text="email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty sv.ho_ten}">
						<input type="submit" value="<spring:message text="Edit Person"/>" />
					</c:if> <c:if test="${empty sv.ho_ten}">
						<input type="submit" value="<spring:message text="Add Person"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3>Student List</h3>
	<c:if test="${!empty listsv}">
		<table class="tg">
			<tr>
				<th width="80">Student ID</th>
				<th width="120">Student Name</th>
				<th width="120">Student Date</th>
				<th width="120">Student Email</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listsv}" var="sinhvien">
				<tr>
					<td>${sinhvien.id}</td>
					<td>${sinhvien.ho_ten}</td>
					<td>${sinhvien.nam_sinh}</td>
					<td>${sinhvien.email}</td>
					<td><a href="<c:url value='/edit/${sinhvien.id}' />">Edit</a></td>
					<td><a href="<c:url value='/delete/${sinhvien.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>