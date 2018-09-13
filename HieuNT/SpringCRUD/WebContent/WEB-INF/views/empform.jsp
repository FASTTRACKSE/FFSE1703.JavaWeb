<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ADD</title>
<style>
body {
	background-color: black;
}

.error {
	color: red;
}
</style>
</head>
<body>
	<h1 style="color: white;">꧁༺🅰🅳🅳 🅽🅴🆆 🅴🅼🅿🅻🅾🆈🅴🅴༻꧂</h1>

	<form:form method="post" action="save" modelAttribute="command"
		enctype="multipart/form-data">
<%-- 	<div class="form-group">
    Name: <form:input path="name"/> <form:errors path="name" cssClass="error" /> <br/><br/>
    </div>
    Adress: <form:input path="address"/> <form:errors path="address" cssClass="error"/> <br/><br/>
    Email: <form:input path="email"/> <form:errors path="email" cssClass="error"/>  --%>
  <div class="form-group">
    <label for="exampleInputEmail1" style="color: white;">Name</label>
    <form:input path="name" type="text" class="form-control"  aria-describedby="emailHelp" placeholder="Enter email"></form:input>
     <form:errors path="name" cssClass="error" />
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1" style="color: white;">Address</label>
    <form:input  path="address" type="text" class="form-control" aria-describedby="emailHelp" placeholder="Enter email"/>
  <form:errors path="address" cssClass="error" />
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1" style="color: white;">Mail</label>
    <form:input  path="email" type="text" class="form-control" id="mail" placeholder="Password"></form:input>
   <form:errors path="email" cssClass="error" />
  </div>
		<div class="form-group">
			<form:input type="file" path="myFile" />
  </div>
		<button type="submit" class="btn btn-primary">Submit</button>
	<button  ><a href="/SpringCRUD/">HOME</a></button>

	</form:form>

</body>
</html>