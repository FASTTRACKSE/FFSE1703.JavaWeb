<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DANH SÁCH SINH VIÊN</title>
</head>
<body>
    <center>
        <h1>QUẢN LÝ SINH VIÊN</h1>
        <h2>
            <a href="/CRUD/CRUDSinhVien/new">ADD SINH VIÊN</a>
            &nbsp;&nbsp;&nbsp;             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <h3>DANH SÁCH SINH VIÊN</h3>
            <tr>
                <th>ID</th>
				<th><fmt:message key="Name" /></th>
				<th><fmt:message key="Gender" /></th>
				<th><fmt:message key="Date" /></th>
				<th><fmt:message key="Class" /></th>
				<th><fmt:message key="Address" /></th>
				<th><fmt:message key="Action" /></th>

			</tr>
             <c:forEach var="SV" items="${SinhVien}">
                <tr>
                    <td>${SV.getId()}</td>
                    <td>${SV.getName()}</td>
                    <td>${SV.getGioitinh()}</td>
                    <td>${SV.getNgaysinh()}</td>
                    <td>${SV.getLop()}</td>
                    <td>${SV.getQuequan()}</td>
                    
                    <td>
                        <a href="/CRUD/CRUDSinhVien/edit?maSV=${SV.getId()}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/CRUD/CRUDSinhVien/delete?maSV=${SV.getId()}">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
         </table>
         <%
			String totalPage = request.getAttribute("SoTrang").toString();
			int trang = Integer.parseInt(totalPage);
			for (int i = 1; i <= trang; i++) {
				out.print("<a href='phanTrang?page=" + i + "'>" + ' ' + i + ' '
						+ "</a>");
			}
		%>
    </div>
</body>
</html>