
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhật thông tin sinh viên</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1 style="text-align: center;">Thông Tin Sinh Viên</h1>
		  Customer ID: ${student.masv} <br/>
          Customer Name: ${student.name} <br/>
           Customer Name: ${student.age} <br/>
            Customer Name: ${student.email} <br/>
          
             
          Customer Address: ${student.address} <br/>
             Customer Name: ${student.lop} <br/>
                Customer Name: ${student.author} <br/>
                   Customer Name: ${student.avatar} <br/>
	</div>
</body>
</html>