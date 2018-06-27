<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>QUẢN LÝ SINH VIÊN</title>
</head>
<style>       body{
             margin: 0;
            font-family:fantasy;	
             background: url(IMAGE/p.jpg) no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
        }</style>
<body  background="images/p.jpg">
<img src="images/p.jpg" alt="Pic 2" class="left" height="87" width="65" />
<img src="IMAGE/p.jpg" alt="Pic 2" class="left" height="87" width="65" />
<img src="ME/p.jpg" alt="Pic 2" class="left" height="87" width="65" />



    <center>
        <h1>QUẢN LÝ SINH VIÊN</h1>
        <h2>
            <a href="/new">ADD SINH VIÊN</a>
            &nbsp;&nbsp;&nbsp;             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>DANH SÁCH SINH VIÊN</h2></caption>
            <tr>
                <th>MÃ SINH VIÊN</th>
                <th>TÊN</th>
                <th>TUỔI</th>
                <th>LỚP</th>
                <th>ĐỊA CHỈ</th>
                <th>ACTIONS</th>
                
            </tr>
             <c:forEach var="SV" items="${SinhVien}">
                <tr>
                    <td><c:out value="${SV.maSV}" /></td>
                    <td><c:out value="${SV.name}" /></td>
                    <td><c:out value="${SV.age}" /></td>
                    <td><c:out value="${SV.cls}" /></td>
                    <td><c:out value="${SV.dress}" /></td>
                    
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