<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
        <h1>Books Management</h1>
        <h2>
            <a href="/new">Add New Sinh Viên</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Sinh Viên</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Mã Sinh Viên</th>
                <th>Họ Và Tên</th>
                <th>Lớp</th>
                <th>Điểm Lp1</th>
                <th>Điểm Lp2</th>
                <th>Điểm TB</th>
                <th>Xếp Loại</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="SinhVien" items="${listSinhVien}">
                <tr>
                    <td><c:out value="${Sv.id}" /></td>
                    <td><c:out value="${Sv.masv}" /></td>
                    <td><c:out value="${Sv.ten}" /></td>
                    <td><c:out value="${Sv.lop}" /></td>
                    <td><c:out value="${Sv.lp1}" /></td>
                    <td><c:out value="${Sv.lp2}" /></td>
                    <td><c:out value="${Sv.tb}" /></td>
                    <td><c:out value="${Sv.xeploai}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${Sv.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${Sv.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>