<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
	<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
<body>
	<center><h2>Danh Sách Sinh Viên</h2></center>
		<table>
		<tr>
			<th>Mã</th>
			<th>Tên</th>
			<th>Năm Sinh</th>
			<th>Địa chỉ</th>
			<th>Email</th>
			<th>Tên lớp</th>
			<th>Ảnh đại diện</th>
			<th>Chức năng</th>
		</tr>
		
		 <c:forEach var="sv" items="${list}">   
			   <tr>  
			   <td>${sv.maSv}</td>  
			   <td>${sv.tenSv}</td>  
			   <td>${sv.namSinh}</td>  
			   <td>${sv.diaChi}</td>  
			   <td>${sv.email}</td> 
			   <td>${sv.lop}</td> 
			   <td></td>
			   <td>
			   		<a href="edit/${sv.id}">Edit</a>
			   		<a href="delete/${sv.id}">Delete</a>
			   	</td>    
			   </tr>  
			   </c:forEach>  
   
	</table>
	
<center><br><a href="them"><input type="submit" value="Thêm sinh viên"></a></center>
</body>
</html>