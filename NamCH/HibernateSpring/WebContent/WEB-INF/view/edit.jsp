<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Update Sinh Viên</title>
<style>
    input[type=text], select {
        width: 100%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    #form {
        border-radius: 5px;
        background-color: #f2f2f2;
        padding: 20px;
    }
</style>
</head>
<body>
    <center><h1>Update Sinh Viên</h1></center>
    <div id="form">
      <form:form action="/HibernateSpring/editSave" method="post" enctype="multipart/form-data">
        <form:input type="hidden" path="id"/> 
        <label>Mã Sinh Viên</label>
        <form:input type="text" path="code"/> <br>
        
        <label>Họ Và Tên</label>
        <form:input type="text" path="name"/>  <br>
        
        <label>Năm Sinh</label>
        <form:input type="text" path="year"/>  <br>
        
        <label>Email</label>
       <form:input type="text" path="email"/>  <br>
        
        <label>Phone</label>
        <form:input type="text" path="phone"/>  <br>
        
        <label>Địa Chỉ</label>
        <form:input type="text" path="adress"/>  <br>
        
        <label>Lớp Học</label>
       <form:input type="text" path="classes"/>  <br>
        
        <label>Hình Ảnh:</label> <input id="imgUrl" class="form-control"
                    type="file" name="file" /> <br> 
                    <img src="<c:url value="/images/${command.image}" />" width="100" height="150">
                    <img id="img" src="#"
                    alt="your image" width="100" height="150" />
                
        <input type="submit" value="Submit">
      </form:form>
    </div>
    <script type="text/javascript">
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    $('#img').attr('src', e.target.result);
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
        $("#imgUrl").change(function() {
            readURL(this);
        });
    </script>
</body>
</html>