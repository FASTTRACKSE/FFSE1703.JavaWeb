<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<% out.println(request.getAttribute("hello"));
%>
<%= new java.util.Date() %>
<%= 3+4 %>
<%
for (int i=1; i <= 5; i++) {
out.println("<br/>Lần lặp thứ: " + i);
}
%>

<%!
int soA, soB;
int tinhTong (int a, int b) {
return a + b;
}
%>
<%
soA = 10;
soB = 20;
%>
Tổng <%=soA%> + <%=soB%> = <%= tinhTong(soA, soB) %>

</form>
</body>
</html>