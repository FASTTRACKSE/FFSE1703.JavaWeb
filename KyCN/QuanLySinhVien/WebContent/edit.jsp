<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="ffse20.quanlysinhvien.model.*"%>
<%@ page import="ffse20.quanlysinhvien.dao.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit User</title>
</head>
<body>
<%
	SinhVienModel user = new SinhVienModel();
%>
<%
	SinhVienDao dao = new SinhVienDao();
%>
<form method="POST" action='Main' name="frmEditUser"><input
	type="hidden" name="action" value="edit" /> <%
 	String uid = request.getParameter("userId");
 	if (!((uid) == null)) {
 		int id = Integer.parseInt(uid);
 		user = dao.getUserById(id);
 %>
<table>
	<tr>
		<td>User ID</td>
		<td><input type="text" name="userId" readonly="readonly"
			value="<%=user.getId()%>"></td>
	</tr>
	<tr>
		<td>Ho Dem</td>
        <td><input type="text" name="hoDem" value="<%=user.getHoDem()%>"/></td>
	</tr>
	<tr>
		<td>Ten</td>
		<td><input type="text" name="ten" value="<%=user.getTen()%>"/></td>
	</tr>
		<tr>
		<td>Ngay Sinh</td>
		<td><input type="text" name="ngaySinh" value="<%=user.getNgaySinh()%>"/></td>
	</tr>
		<tr>
		<td>Que Quan</td>
		<td><input type="text" name="queQuan" value="<%=user.getQueQuan()%>"/></td>
	</tr>
		<tr>
		<td>Gioi Tinh</td>
		<td><input type="text" name="gioiTinh" value="<%=user.getGioiTinh()%>"/></td>
	</tr>
		<tr>
		<td>Lop</td>
		<td><input type="text" name="lop" value="<%=user.getLop()%>"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input type="submit" value="Update" /></td>
	</tr>
</table>
<%
	} else
		out.println("ID Not Found");
%>
</form>
</body>
</html>