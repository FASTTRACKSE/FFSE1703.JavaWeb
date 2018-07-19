<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<c:choose>
    <c:when test="${not empty param.theLocale}">
        <c:set var="theLocale" value="${param.theLocale}" scope="session" /> 
    </c:when>    
    <c:otherwise>
		<c:if test="${empty theLocale}">
		    <c:set var="theLocale" value="${pageContext.request.locale}" scope="session" />
		</c:if>
    </c:otherwise>
</c:choose>

<fmt:setLocale value="${theLocale}" />

<fmt:setBundle basename="resources.Resource" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset='UTF-8'">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<center>
        <h1><fmt:message key="StudentsManagement" /></h1>
        <h2>
        <!-- Thêm -->
            <a class="btn btn-primary" href="new"><fmt:message key="AddNewStudents" /></a>
            &nbsp;&nbsp;&nbsp;
            <a class="btn btn-primary" href="list"><fmt:message key="ListAllStudents" /></a>
             <!-- Ngôn Ngữ -->
        </h2>
    </center>
     <div class="dropdown container" style="float:center">
    <button style="background-color: #60D94A" class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown"><fmt:message key="Language" />
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="http://localhost:8080/quanlisinhvien1/list?page=1&theLocale=vi_VN">Tiếng Việt</a></li>
      <li>  <a href="http://localhost:8080/quanlisinhvien1/list?page=1&theLocale=en_US">English</a></li>
    </ul>
  </div>
    <div align="center" class="container">
    
        <table class="table table-striped">
            <caption><h2>List of Students</h2></caption>
            <thead>
            <tr style="background-color: #60D94A">
                <th>ID</th>
                <th><fmt:message key="CodeStudent" /></th>
                <th><fmt:message key="name" /></th>
                <th><fmt:message key="Birthday" /></th>
                <th><fmt:message key="Country" /></th>
                <th><fmt:message key="Sex" /></th>
                <th><fmt:message key="Class" /></th>
                <th><fmt:message key="MarkLp1" /></th>
                <th><fmt:message key="MarkLp2" /></th>
                <th><fmt:message key="MediumScore" /></th>
                <th><fmt:message key="Classification" /></th>
                <th><fmt:message key="Actions" /></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="Sv" items="${listSinhVien}">
                <tr>
                    <td><c:out value="${Sv.id}" /></td>
                    <td><c:out value="${Sv.masv}" /></td>
                    <td><c:out value="${Sv.ten}" /></td>
                    <td><c:out value="${Sv.ngaysinh}" /></td>
                    <td><c:out value="${Sv.quequan}" /></td>
                    <td><c:out value="${Sv.gioitinh}" /></td>
                    <td><c:out value="${Sv.lop}" /></td>
                    <td><c:out value="${Sv.lp1}" /></td>
                    <td><c:out value="${Sv.lp2}" /></td>
                    <td><c:out value="${Sv.tinhTrungBinh()}" /></td>
                    <td><c:out value="${Sv.xepLoai()}" /></td>
                    <!-- Sửa Xóa -->
                    <td>
                        <a class="btn btn-info" href="${pageContext.request.contextPath}/edit?id=<c:out value='${Sv.id}' />"><fmt:message key="Edit" /></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/delete?id=<c:out value='${Sv.id}' />"><fmt:message key="Delete" /></a>                     
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
       	<ul class="pagination active" style="text-align: left; list-style-type: none;">
       	
       	<c:if test="${allpage != null }"></c:if>
       		<c:forEach var="page" begin="1" end="${allpage }">
       		<li><a href="${pageContext.request.contextPath}/list?page=<c:out value='${page}'/>"><c:out value="${page}"/></a></li>
       		</c:forEach>
       	</ul>
    </div>   
</body>
</html>