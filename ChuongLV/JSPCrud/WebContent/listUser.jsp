<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="net.roseindia.bean.UserBean"%>
<%@ page import="net.roseindia.dao.UserDao"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All User</title>
</head>
<body>
<%
	//UserBean user = new UserBean();
	UserDao dao = new UserDao();
	List<UserBean> userList = dao.getAllUsers();
	//Iterator<UserBean> itr = userList.iterator();
%>
<table border="1">
	<tr>
		<th>Id</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Date</th>
		<th>Country</th>
		<th>Gender</th>
		<th>Class</th>
		<th>Action</th>
	</tr>
	<tr>
		<%
			/*while(itr.hasNext())
			 {
			 System.out.println(user.getId());*/
			for (UserBean user : userList) {
		%>
		<td><%=user.getId()%></td>
		<td><%=user.getfName()%></td>
		<td><%=user.getlName()%></td>
		<td><%=user.getdate()%></td>
		<td><%=user.getcountry()%></td>
		<td><%=user.getgender()%></td>
		<td><%=user.getClass()%></td>
		<td>
		<a href="UserHandler?action=edit&userId=<%=user.getId()%>">Edit</a>
		<a href="UserHandler?action=editform&userId=<%=user.getId()%>">Update</a>
		<a href="UserHandler?action=delete&userId=<%=user.getId()%>">Delete</a>
		</td>

	</tr>
	<%
		}
		//}
	%>
</table>
<p><a href="UserHandler?action=insert">Add User</a></p>
</body>
</html>