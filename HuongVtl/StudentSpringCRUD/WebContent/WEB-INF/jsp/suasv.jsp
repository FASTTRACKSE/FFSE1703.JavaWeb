<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
    background-color: green;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>
<body>
	 <center><h2>Sửa Thông Tin</h2></center>  
       <form:form method="post" action="/StudentSpringCRUD/editsave">   
     Mã Sinh Viên:
     <input type="hidden" name = "id"  value="<c:out value="${command.id}" />"  >
     	<input type="text" name="maSv" value="<c:out value="${command.maSv}" />"><br><br>
  		<form:errors path="maSv" cssStyle="color:red;display:block;text-align: center"></form:errors>
 	 Tên Sinh Viên:
  		<input type="text" name="tenSv"  value="<c:out value="${command.tenSv}" />"><br><br>
  		<form:errors path="tenSv" cssStyle="color:red;display:block;text-align: center"></form:errors>
	 Năm Sinh:
  		<input type="text" name="namSinh"  value="<c:out value="${command.namSinh}" />"><br><br>
  		<form:errors path="namSinh" cssStyle="color:red;display:block;text-align: center"></form:errors>
  	Email:
  		<input type="text" name="email"  value="<c:out value="${command.email}" />"><br><br>
  		<form:errors path="email" cssStyle="color:red;display:block;text-align: center"></form:errors>	
  	 Địa Chỉ:
  		<input type="text" name="diaChi"  value="<c:out value="${command.diaChi}" />"><br><br>
  		<form:errors path="diaChi" cssStyle="color:red;display:block;text-align: center"></form:errors> 
  	 Lớp:
  		<input type="text" name="lop"  value="<c:out value="${command.lop}" />"><br><br>
  		<form:errors path="lop" cssStyle="color:red;display:block;text-align: center"></form:errors>
  	<input type="submit" value="Submit">
  			</form:form>		    
</body>
</html>