<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Quản Lý Sinh Viên</title>
</head>
<body>
    <center>
        <h1>Quản Lý Sinh Viên</h1>
        <h2>
            <a href="/new">Thêm Sinh Viên</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">Tất Cả Danh Sách Sinh Viên</a>
              
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Danh Sách Sinh Viên</h2></caption>
            <tr>
                <th>Mã Sinh Viên</th>
                <th>Tên</th>
                <th>Tuổi</th>
                <th>Lớp</th>
                <th>Địa Chỉ</th>
                <th>Giới Tính</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="SV" items="${SinhVien}">
                <tr>
                    <td><c:out value="${SV.maSV}" /></td>
                    <td><c:out value="${SV.ten}" /></td>
                    <td><c:out value="${SV.tuoi}" /></td>
                    <td><c:out value="${SV.lop}" /></td>
                    <td><c:out value="${SV.diaChi}" /></td>
                    <td><c:out value="${SV.gioiTinh}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${book.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>