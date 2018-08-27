<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Student List</h1>
<table border="2" width="100%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Date</th>
		<th>Class</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<c:forEach var="emp" items="${list}">
		<tr>
			<td>${emp.id}</td>
			<td>${emp.name}</td>
			<td>${emp.ngaySinh}</td>
			<td>${emp.lop}</td>
			<td><a href="/SpringMVCAss5/editemp/${emp.id}">Edit</a></td>
			<td><a href="/SpringMVCAss5/deleteemp/${emp.id}"
				onclick="return confirm('Bạn có muốn xóa sinh viên này?');"
				class="btn btn-danger">Delete</a></td>
		</tr>
	</c:forEach>
</table>
<br />

<center>

	<c:if test="${page > 1}"><a href="/SpringMVCAss5/list/1">First</a></c:if>
	<c:if test="${page > 1}"><a href="/SpringMVCAss5/list/${page-1}">${page-1}</a></c:if>
	<a href="/SpringMVCAss5/list/${page}">${page}</a>
	<c:if test="${page < total}"><a href="/SpringMVCAss5/list/${page+1}">${page+1}</a></c:if>
	<c:if test="${page < total}"><a href="/SpringMVCAss5/list/${total}">Last</a></c:if>
</center>


<a href="/SpringMVCAss5/empform">Add New Student</a>