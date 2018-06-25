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
</head>
<body>
	<center>
        <h1>Sinh Viên Management</h1>
        <h2>
            <a href="new">Add New Sinh Viên</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Sinh Viên</a>
             
        </h2>
    </center>
    <div align="center">
    <a href="http://localhost:8080/quanlisinhvien1/list?page=1&theLocale=vi_VN">Tiếng Việt</a>
    <a href="http://localhost:8080/quanlisinhvien1/list?page=1&theLocale=en_US">English</a>
        <table border="1" cellpadding="5">
            <caption><h2>List of Students</h2></caption>
            <tr>
                <th>ID</th>
                <th><fmt:message key="Code Student" /></th>
                <th><fmt:message key="name" /></th>
                <th><fmt:message key="Birthday" /></th>
                <th><fmt:message key="Country" /></th>
                <th><fmt:message key="Sex" /></th>
                <th><fmt:message key="Class" /></th>
                <th><fmt:message key="Mark Lp1" /></th>
                <th><fmt:message key="Mark Lp2" /></th>
                <th><fmt:message key="Medium Score" /></th>
                <th><fmt:message key="Classification" /></th>
                <th><fmt:message key="Actions" /></th>
            </tr>
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
                    <td>
                        <a href="${pageContext.request.contextPath}/edit?id=<c:out value='${Sv.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="${pageContext.request.contextPath}/delete?id=<c:out value='${Sv.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
       	<ul style="text-align: center; list-style-type: none;">
       	<c:if test="${allpage != null }"></c:if>
       		<c:forEach var="page" begin="1" end="${allpage }">
       		<li><a href="${pageContext.request.contextPath}/list?page=<c:out value='${page}'/> &lang="><c:out value="${page}"/></a></li>
       		</c:forEach>
       	</ul>
    </div>   
</body>
</html>