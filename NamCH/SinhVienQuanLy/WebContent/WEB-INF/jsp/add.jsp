<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm Sinh Viên</title>
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
    <center><h1>Thêm Sinh Viên</h1></center>
    <div id="form">
      <form action="/SinhVienQuanLy/addsave" method="post">    
        <label>Mã Sinh Viên</label>
        <input type="text" name="maSv" > 
      
        <label>Họ Và Tên</label>
        <input type="text" name="tenSv" >
        
        <label>Năm Sinh</label>
        <input type="text" name="namSinh" > 
        
        <label>Email</label>
        <input type="text" name="email" >    
        
        <label>Phone</label>
        <input type="text" name="soDt">
        
        <label>Địa Chỉ</label>
        <input type="text" name="diaChi" >  
        
        <label>Lớp Học</label>
        <input type="text" name="lop">  
                  
        <input type="submit" value="Submit">
      </form>
    </div>
</body>
</html>