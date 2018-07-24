<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh Sách Sinh Viên</title>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>
	<center><h1>Danh Sách Sinh Viên</h1></center>
	<table id="customers">
  <tr>
    <th>Tên sinh viên</th>
    <th>Mã sinh viên</th>
    <th>Ngày sinh</th>
    <th>Điểm Lp1</th>
    <th>Điểm Lp2</th>
    <th>Điểm TB</th>
    <th>Xếp loại</th>
    <th>Chức năng</th>
  </tr>
  <c:forEach var="sv" items="${SinhVien}">
  	<tr>
    <td><c:out value="${sv.ten}" /></td>
    <td><c:out value="${sv.ma}" /></td>
    <td><c:out value="${sv.ngay_sinh}" /></td>
    <td><c:out value="${sv.lp1}" /></td>
    <td><c:out value="${sv.lp2}" /></td>
    <td><c:out value="${sv.getDTB()}" /></td>
    <td><c:out value="${sv.getXL()}" /></td>
    <td><a href="aaaa">Thêm</a>
    	<a href="aaaa">Sửa</a>
    	<a href="aaaa">Xoá</a>
    </td>
  </tr>
  </c:forEach>
  
</table>
<center><br><a href="insert"><input type="submit" value="Thêm sinh viên"></a></center>

</body>
</html>