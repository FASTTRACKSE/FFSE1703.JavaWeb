<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" >
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
</head>
<body class="container">
<h1 style="text-align: center;">Quản lý sinh viên</h1>
<h3><a href="${pageContext.request.contextPath }/new">Thêm sinh viên</a></h3>
<table class="table table-striped ">
  		<thead class="thead-dark">
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Họ đệm</th>
		      <th scope="col">Tên</th>
		      <th scope="col">Ngày sinh</th>
		      <th scope="col">Giới tính</th>
		      <th scope="col">Quê quán</th>
		      <th scope="col">Lớp</th>
		      <th scope="col">Điểm LP1</th>
		      <th scope="col">Điểm LP1</th>
		      <th scope="col">Điểm TB</th>
		      <th scope="col">Xếp loại</th>
		      <th scope="col">Hành động</th>
		    </tr>
  		</thead>
  		<tbody>
  		<c:forEach var="sv" items="${listSinhVien}">
		    <tr>
		     <th scope="row"><c:out value="${sv.id}"/></th>
		     <td><c:out value="${sv.hodem }"/></td>
		     <td><c:out value="${sv.ten }"/></td>
		     <td><c:out value="${sv.ngaysinh }"/></td>
		     <td><c:out value="${sv.gioitinh }"/></td>
		     <td><c:out value="${sv.quequan }"/></td>
		     <td><c:out value="${sv.lop }"/></td>
		     <td><c:out value="${sv.diemlp1 }"/></td>
		     <td><c:out value="${sv.diemlp2 }"/></td>
		     <td><c:out value="${sv.diemtb }"/></td>
		     <td><c:out value="${sv.xeploai }"/></td>
		     <td>
		     	<a href="${pageContext.request.contextPath }/edit?id=<c:out value='${sv.id}' />">Edit</a>
		        &nbsp;&nbsp;&nbsp;&nbsp;
		        <a href="${pageContext.request.contextPath }/delete?id=<c:out value='${sv.id}' />">Delete</a>  
		     </td>
		    </tr>
   </c:forEach>
  </tbody>
</table>
</body>
</html>