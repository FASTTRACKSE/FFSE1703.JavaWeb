<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Sửa Sinh Viên</h1>  
       <form:form method="POST" action="/SpringMVCCRUDSimple/editsave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>Tên SV : </td>   
          <td><form:input path="tenSV"  /></td>  
         </tr>    
         <tr>    
          <td>Năm Sinh :</td>    
          <td><form:input path="namSinh" /></td>  
         </tr>   
         <tr>    
          <td>Email :</td>    
          <td><form:input path="email" /></td>  
         </tr>
         <tr>    
          <td>Địa Chỉ :</td>    
          <td><form:input path="diaChi" /></td>  
         </tr> 
         <tr>    
          <td>Lớp Học :</td>    
          <td><form:input path="lopHoc" /></td>  
         </tr>    
           
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
</body>
</html>