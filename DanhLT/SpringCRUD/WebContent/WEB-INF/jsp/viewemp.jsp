<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<f:view>
   

	<h1>Student List</h1>
	<table border="2" width="70%" cellpadding="2">
	<tr><th>Id</th><th>Mã Sinh Viên</th><th>Tên</th><th>Tuổi</th><th>Lớp</th><th>Địa Chỉ</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="emp" items="${listsv}"> 
    <tr>
    <td>${emp.id}</td>
    <td>${emp.masv}</td>
    <td>${emp.ten}</td>
    <td>${emp.tuoi}</td>
    <td>${emp.lop}</td>
     <td>${emp.diachi}</td>
    <td><a href="/SpringCRUD/editemp/${emp.id}">Edit</a></td>
    <td><a href="/SpringCRUD/deleteemp/${emp.id}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <center>
	<c:if test="${pageid > 1}"><a href="/SpringCRUD/viewemp/1">First</a></c:if>
	<c:if test="${pageid > 1}"><a href="/SpringCRUD/viewemp/${pageid-1}">${pageid-1}</a></c:if>
	<a href="/SpringCRUD/viewemp/${pageid}">${pageid}</a>
	<c:if test="${pageid < pagetotal}"><a href="/SpringCRUD/viewemp/${pageid+1}">${pageid+1}</a></c:if>
	<c:if test="${pageid < pagetotal}"><a href="/SpringCRUD/viewemp/${pagetotal}">Last</a></c:if>
	
	</center>
    <a href="/SpringCRUD/empform">Add New Student</a>
</f:view>
</body>
</html>