<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%!
	int soA, soB;
	int tinhTong(int a,int b){
		return a + b;
	}
	%>
	<%
	soA = 10;
	soB = 20;
	%>
	Tổng <%= soA %> + <%= soB %> = <%= tinhTong(soA, soB) %></br>
	
	Bây giờ là <%= new java.util.Date() %>
	<%--Chú thích--%>
</body>
</html>