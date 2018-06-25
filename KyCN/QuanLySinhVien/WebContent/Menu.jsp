<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ffse20.quanlysinhvien.model.*"%>
<%@ page import="ffse20.quanlysinhvien.dao.*"%>
<%@ page import="java.util.*"%>
<html>
<head>

<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<title>All User</title>
</head>
<body>
<%

	SinhVienDao dao = new SinhVienDao();
	List<SinhVienModel> userList = dao.getAllUsers();

%>
<div align="center">
<table border="1">
	<tr>
		<th>Id</th>
		<th>Ho Dem</th>
		<th>Ten</th>
		<th>Ngay Sinh</th>
		<th>Que Quan</th>
		<th>Gioi Tinh</th>
		<th>Lop</th>
		<th>Action</th>
	</tr>
	<tr>
		<%

			for (SinhVienModel user : userList) {
		%>
		<td><%=user.getId()%></td>
		<td><%=user.getHoDem()%></td>
		<td><%=user.getTen()%></td>
		<td><%=user.getNgaySinh()%></td>
		<td><%=user.getQueQuan()%></td>
		<td><%=user.getGioiTinh()%></td>
		<td><%=user.getLop()%></td>
		<td><a
			href="Main?action=editform&userId=<%=user.getId()%>">Update</a>
		<a
			href="Main?action=delete&userId=<%=user.getId()%>">Delete</a></td>

	</tr>
	<%
		}
	%>
</table>
</div>
<p><a href="Main?action=insert">Add User</a></p>
</body>
</html>