<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DANH SÁCH SINH VIÊN</title>
</head>
<body  background="images/p.jpg">
    <center>
        <h1>QUẢN LÝ SINH VIÊN</h1>
        <h2>
            <a href="/SinhVienCrud/ListSV/new">ADD SINH VIÊN</a>
            &nbsp;&nbsp;&nbsp;             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>DANH SÁCH SINH VIÊN</h2></caption>
            <tr>
                <th>MÃ SINH VIÊN</th>
                <th>TÊN</th>
                <th>GIỚI TÍNH</th>
                <th>TUỔI</th>
                <th>LỚP</th>
                <th>ĐỊA CHỈ</th>
                <th>ACTIONS</th>
                
            </tr>
             <c:forEach var="SV" items="${SinhVien}">
                <tr>
                    <td><c:out value="${SV.maSV}" /></td>
                    <td><c:out value="${SV.name}" /></td>
                    <td><c:out value="${SV.sex}" /></td>
                    <td><c:out value="${SV.age}" /></td>
                    <td><c:out value="${SV.cls}" /></td>
                    <td><c:out value="${SV.dress}" /></td>
                    
                    <td>
                        <a href="/SinhVienCrud/ListSV/edit?maSV=<c:out value='${SV.maSV}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/SinhVienCrud/ListSV/delete?maSV=<c:out value='${SV.maSV}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
         </table>
         <a href="/SinhVienCrud/ListSV/phanTrang?page=1">1</a> 
		<a href="/SinhVienCrud/ListSV/phanTrang?page=2">2</a> 
		<a href="/SinhVienCrud/ListSV/phanTrang?page=3">3</a>
    </div>
   	    
</body>
</html>