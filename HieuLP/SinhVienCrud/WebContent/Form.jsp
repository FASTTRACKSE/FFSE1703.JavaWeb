<%@page import="model.NgonNguDAO"%>
<%@page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<% Map<String,String> show= new NgonNguDAO().VietNamLanguage();
String lang =(String) session.getAttribute("lang");
if(lang!=null){
 if(lang.equals("Vietnamese")){
	show=new NgonNguDAO().VietNamLanguage();
}else if(lang.equals("Thailand")){
	show=new NgonNguDAO().ThailandLanguage();
	}
}else{
	show=new NgonNguDAO().ThailandLanguage();

}


%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DANH SÁCH SINH VIÊN</title>
<style>
.dropdown {
    display: table-cell;
    text-align: center;
    vertical-align: middle;
    width: ...;
    height: ...;
}
</style>
</head>
<body background="images/p.jpg">
	<center>
		<h1><%=show.get("Login.tieude") %></h1>
		<h2>
			<a href="/SinhVienCrud/ListSV/new"><%=show.get("Login.add") %></a>
			&nbsp;&nbsp;&nbsp;
		</h2>
	</center>

	<div align="center">
		
		<table border="1" cellpadding="5">
			<caption>
				<h2><%=show.get("Login.dssv") %></h2>
			</caption>
			<tr>
				<th><%=show.get("Login.masv") %></th>
				<th><%=show.get("Login.ten") %></th>
				<th><%=show.get("Login.gioitinh") %></th>
				<th><%=show.get("Login.tuoi") %></th>
				<th><%=show.get("Login.lop") %></th>
				<th><%=show.get("Login.diachi") %></th>
				<th><%=show.get("Login.action") %></th>

			</tr>
			<c:forEach var="SV" items="${SinhVien}">
				<tr>
					<td><c:out value="${SV.maSV}" /></td>
					<td><c:out value="${SV.name}" /></td>
					<td><c:out value="${SV.sex}" /></td>
					<td><c:out value="${SV.age}" /></td>
					<td><c:out value="${SV.cls}" /></td>
					<td><c:out value="${SV.dress}" /></td>

					<td><a
						href="/SinhVienCrud/ListSV/edit?maSV=<c:out value='${SV.maSV}' />">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="/SinhVienCrud/ListSV/delete?maSV=<c:out value='${SV.maSV}' />">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		<a href="/SinhVienCrud/ListSV/phanTrang?page=1">1</a> <a
			href="/SinhVienCrud/ListSV/phanTrang?page=2">2</a> <a
			href="/SinhVienCrud/ListSV/phanTrang?page=3">3</a>
		
	</div>
		<div class="dropdown" style=fload:left>
			<button class="btn btn-primary dropdown-toggle" type="button"
				data-toggle="dropdown">
				Dropdown Example <span class="caret"></span>
			</button>
			<ul class="dropdown-menu" >
				<li align="center"><a href="/SinhVienCrud/ListSV/DaNgonNgu?Lang=Vietnamese">VIETNAMESE</a></li>
				<li align="center"><a href="/SinhVienCrud/ListSV/DaNgonNgu?Lang=Thailand">THAILAND</a></li>
			</ul>
		</div>
</body>
</html>