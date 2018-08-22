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

		<h1>Add Student</h1>
       <form:form method="post" action="save">  
      	<table >  
      	  <tr>  
          <td>Mã Sinh Viên : </td> 
          <td><form:input path="masv"  /></td>
         </tr>  
         <tr>  
          <td>Tên : </td> 
          <td><form:input path="ten"  /></td>
         </tr>  
         <tr>  
          <td>Tuổi :</td>  
          <td><form:input path="tuoi" /></td>
         </tr> 
         <tr>  
          <td>Lớp :</td>  
          <td><form:input path="lop" /></td>
         </tr> 
          <tr>  
          <td>Địa Chỉ :</td>  
          <td><form:input path="diachi" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>  

</f:view>
</body>
</html>