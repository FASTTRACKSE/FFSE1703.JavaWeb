<%@ page language="java" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibs/customTaglib.tld" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<html>
<head>
<title>Fasttrack SE</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<a href="?language=en_US">English</a>
	<a href="?language=vi">Viet Nam</a>
	
	<h1 style="text-align: center;"> <spring:message code="title_list" /></h1>
	<div class="container">
		<a style="background: green" href="showForm" class="btn btn-info"
			role="button"><spring:message code="add" /></a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th><spring:message code="code" /></th>
					<th> <spring:message code="full_name" /></th>
					<th><spring:message code="birth_year" /></th>
					<th><spring:message code="email" /></th>
					<th><spring:message code="address" /></th>
					<th><spring:message code="class" /></th>
					<th><spring:message code="avatar" /></th>
					<th><spring:message code="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="st" items="${list}">
					<tr>
						<td>${st.classSv}0${st.id}</td>
						<td>${st.fullName}</td>
						<td>${st.birthYear}</td>
						<td>${st.email}</td>
						<td>${st.address}</td>
						<td>${st.classSv}</td>
						<td><div class="right">
								<img style="width: 100px;"
									src='<c:url value = "/upload/${st.avatar }" ></c:url>'
									alt="image">
							</div></td>
						<td><a href="editStudent/${st.id}" title=""
							class="btn btn-primary"> <i
								class="glyphicon glyphicon-pencil"></i></a> <a
							onclick=" if(!confirm('<spring:message code="delete" />??')){return false;}"
							href="delete/${st.id}" title="" class="btn btn-danger"> <i
								class="glyphicon glyphicon-remove"></i></a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		
		 <nav aria-label="Page navigation example"
			style="text-align: center; float: right;">
			<ul class="pagination justify-content-center">
				<c:if test="${pageId > 1}">
					<li class="page-item"><a href="1">first</a></li>
					<li class="page-item"><a href="${pageId-1 }">${pageId-1 }</a></li>
				</c:if>
				<li class="page-item active"><a href="${pageId}">${pageId}</a></li>
				<c:if test="${pageId < totalPage}">
					<li class="page-item"><a href="${pageId+1 }">${pageId+1 }</a></li>
					<li class="page-item"><a href="${totalPage }">last</a></li>
				</c:if>
			</ul>
		</nav>
	
	</div>