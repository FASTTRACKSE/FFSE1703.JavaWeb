<%@page import="jdk.nashorn.internal.runtime.linker.JavaAdapterFactory"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Bây giờ là: <%= new java.util.Date() %> <br>
	Tổng của 5 + 5 = <%= 5 + 5 %> <br>
	
	<%!
		int soA, soB;
		int tong(int a, int b){
			return a + b;
		}
	%>
	
	<%
		soA = 6;
		soB = 7;
	%>
	
	<%--Chú thích--%>
	
	Tổng là: <%=soA %> + <%=soB %> = <%= tong(soA, soB) %>

	<form action="XinChaoServlet" method="post">
		Nhập tên: <input type="text" name="nhapTen"> <br>
		<input type="submit" value="Gửi">
	</form>
</body>
</html>