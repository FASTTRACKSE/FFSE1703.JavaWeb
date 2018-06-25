<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset='UTF-8'">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<title>Insert title here</title>
</head>
<body>
			<!-- form sample -->
	<!--  <form action="a" method="post">
		Nhập Tên: <input type="text" name="nhapTen"> <br>
		
		<input type="submit" value="Gửi">
	</form> 
	
	<a href="new"><button type="button">click</button></a> -->
	
	<!--<fmt:setLocale value="${lang}"/> -->
	
	<fmt:setBundle basename="resources.${lang}"/> <!-- resources.${lang} dân tới file ngôn ngữ -->
	
	
	<div class="container">
	
	<div class="dropdown" style="float: right">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><fmt:message key="language_choose" />
    <span class="caret"></span></button>
    <ul class="dropdown-menu">
      <li><a href="list?lang=Resource_en_EN">Tiếng Anh</a></li>
      <li><a href="list?lang=Resource_vn_VN">Tiếng Việt</a></li>
    </ul>
  </div>
	
  <h2 style="text-align: center"><fmt:message key="title_List" /></h2>  
  <a href="add" style="text-align: center"><button type="button" class="btn btn-success"><fmt:message key="button_add" /></button></a>      
  <table class="table table-striped" style="text-align: center">
    <thead>
      <tr>
        <th style="text-align: center"><fmt:message key="student_id" /></th>
        <th style="text-align: center"><fmt:message key="name" /></th>
        <th style="text-align: center"><fmt:message key="age" /></th>
        <th style="text-align: center"><fmt:message key="country" /></th>
        <th style="text-align: center"><fmt:message key="gender" /></th>
        <th style="text-align: center"><fmt:message key="class_id" /></th>
        <th style="text-align: center"><fmt:message key="lp1_mark" /></th>
        <th style="text-align: center"><fmt:message key="lp2_mark" /></th>
        <th style="text-align: center"><fmt:message key="average_mark" /></th>
        <th style="text-align: center"><fmt:message key="rank" /></th>
        <th style="text-align: center"><fmt:message key="function" /></th>
      </tr>
    </thead>
    <tbody>
     
      <c:forEach var="x" items="${sinhVienList}">
      	<tr>
      		<td><c:out value="${x.getMaSV()}" /></td>
      		<td><c:out value="${x.getHoTen()}"/></td>
      		<td><c:out value="${x.getTuoi()}" /></td>
      		<td><c:out value="${x.getQueQuan()}" /></td>
      		<td><c:out value="${x.getGioiTinh()}" /></td>
      		<td><c:out value="${x.getMaLop()}" /></td>
      		<td><c:out value="${x.getDiemLp1()}" /></td>
      		<td><c:out value="${x.getDiemLp2()}" /></td>
      		<td><c:out value="${x.diemTrungBinh()}" /></td>
      		<td><c:out value="${x.xepLoai()}" /></td>
      		<td><a href="edit?maSv=<c:out value='${x.getMaSV()}' />" ><button type="button" class="btn btn-primary "><fmt:message key="button_update" /></button></a> 
      			&nbsp; &nbsp; &nbsp;
      			<a href="delete?maSv=<c:out value='${x.getMaSV()}'/>" ><button type="button" class="btn btn-danger" onclick="return myFunction()" ><fmt:message key="button_delete" /></button></a>
      		</td>
      	</tr>
       </c:forEach>
     
      
    </tbody>
  </table>
  
  										<!-- Phần phân trang -->
  <c:if test="${soTrang > 1}">
  
		<c:forEach var = "i" begin = "1" end = "${soTrang}">
         <a href="listsv?trang=${i}&lang=${lang}"> <c:out value = "${i}"/> </a> <!-- listsv không trùng với case ở servlet nên tự nhảy vào case default, lang để khi chuyển trang thì ngôn ngữ vẫn ko đổi -->
      </c:forEach>	
      
  </c:if>	
  										
</div>
	<script>
  		function myFunction(){
   		 return confirm("Bạn có muốn xóa sinh viên này không?");
  		};
	</script>
</body>
</html>