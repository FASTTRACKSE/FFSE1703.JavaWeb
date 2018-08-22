<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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



div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>
<body>
	 <center><h3>Thêm Sinh </h3></center>  
       <form:form method="post" action="/StudentSpringCRUD/themSv">    
     Mã Sinh Viên:
  		<form:input path="maSv"/>
  		<form:errors path="maSv" cssStyle="color:red;display:block;text-align: center"></form:errors>
 	 Tên Sinh Viên:
  		<form:input path="tenSv"/>
  		<form:errors path="tenSv" cssStyle="color:red;display:block;text-align: center"></form:errors>
	 Năm Sinh:
	 	<form:input path="namSinh"/>
  		<form:errors path="namSinh" cssStyle="color:red;display:block;text-align: center"></form:errors>
  	Email:
  		<form:input path="email"/>
  		<form:errors path="email" cssStyle="color:red;display:block;text-align: center"></form:errors>
  	 Địa Chỉ:
  	 	<form:input path="diaChi"/>
  		<form:errors path="diaChi" cssStyle="color:red;display:block;text-align: center"></form:errors>
  	 Lớp:
  	 	<form:input path="lop"/>
  		<form:errors path="lop" cssStyle="color:red;display:block;text-align: center"></form:errors>

  			</form:form>
  
  	<h4>File Upload Example - JavaTpoint</h4>  
  
	<h3 style="color:red">${filesuccess}</h3>  
	<form:form method="post" action="savefile" enctype="multipart/form-data">  
	<p><label for="image">Choose Image</label></p>  
	<p><input name="file" id="fileToUpload" type="file" /></p>  
	<p><input type="submit" value="Upload"></p>  
	
	<input type="submit" value="Submit"  >
	</form:form>  	
	
		    
</body>
</html>