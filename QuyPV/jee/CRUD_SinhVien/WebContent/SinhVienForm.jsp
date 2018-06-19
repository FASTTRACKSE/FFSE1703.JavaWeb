<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>

</head>
<body>

		<fmt:setBundle basename="Resources.${lang}" /> <!-- ngôn ngữ cho trang -->

	<div class="container">
		<h2>
			<c:if test="${sinhVien != null}"> 
				<fmt:message key="updateStudent" />
			</c:if>

			<c:if test="${sinhVien == null}"> 
				<fmt:message key="addStudent" />
			</c:if>
		</h2>
		<c:if test="${sinhVien == null}"> 
				<form action="insert" method="post">
		</c:if>
		
		<c:if test="${sinhVien != null}"> 
				<form action="update" method="post">
		</c:if>
		
			<div class="form-group">
				<label><fmt:message key="studentId" />:</label> 
		
				<c:if test="${sinhVien != null}">
					<input type="hidden" class="form-control"
					placeholder="Nhập mã sinh viên" name="maSv"
					value="<c:out value='${sinhVien.getMaSV()}'/>">
					<c:out value="${sinhVien.getMaSV()}" />
					
				</c:if>
				
				<c:if test="${sinhVien == null}">
					<input type="text" class="form-control"
					placeholder="Nhập mã sinh viên" name="maSv"
					 >
					<p style= "color: red"><c:out value='${eroMa}'/></p>
				</c:if>	
					
			</div>
			<div class="form-group">
				<label><fmt:message key="name" />:</label> <input type="text" class="form-control"
					placeholder="Nhập họ tên sinh viên" name="hoTen" value="<c:out value='${sinhVien.getHoTen()}'/>">
					<p style= "color: red"><c:out value='${eroHoTen}'/></p>
			</div>
			<div class="form-group">
				<label><fmt:message key="age" />:</label> <input type="text" class="form-control"
					placeholder="Nhập tuổi sinh viên" name="tuoi" value="<c:out value='${sinhVien.getTuoi()}'/>">
					<p style= "color: red"><c:out value='${eroDiaChi}'/></p>
			</div>
			<div class="form-group">
				<label><fmt:message key="country" />:</label> <input type="text" class="form-control"
					placeholder="Nhập quê quán sinh viên" name="queQuan" value="<c:out value='${sinhVien.getQueQuan()}'/>">
					<p style= "color: red"><c:out value='${eroDienThoai}'/></p>
			</div>
			
			
		

			<c:if test="${sinhVien == null}"> 
				<div class="form-group">
					<label><fmt:message key="gender" />:</label> 
					<input type="radio" name="gioiTinh" value="nam" checked="checked"> Nam |
					<input type="radio" name="gioiTinh" value="nữ"> Nữ
					
				</div>
			</c:if>
			
			<c:if test="${sinhVien != null}"> 
				 <c:set var = "gioiTinh" scope = "session" value = "${sinhVien.getGioiTinh()}"/>
     			 <c:if test = "${gioiTinh == 'nữ'}">
        		 	<div class="form-group">
						<label><fmt:message key="gender" />:</label> 
						<input type="radio" name="gioiTinh" value="nam"> Nam |
						<input type="radio" name="gioiTinh" value="nữ"  checked="checked"> Nữ
					</div>
     			</c:if>
     			<c:if test = "${gioiTinh == 'nam'}">
        		 	<div class="form-group">
        		 		<label><fmt:message key="gender" />:</label> 
						<input type="radio" name="gioiTinh" value="nam" checked="checked"> Nam |
						<input type="radio" name="gioiTinh" value="nữ"> Nữ
					</div>
     			</c:if>
			</c:if>
			
			<div class="form-group">
				<label><label><fmt:message key="classId" />:</label> :</label> <input type="text" class="form-control"
					placeholder="Nhập mã lớp sinh viên" name="maLop" value="<c:out value='${sinhVien.getMaLop()}'/>">
					<p style= "color: red"><c:out value='${eroMaLop}'/></p>
			</div>
			<div class="form-group">
				<label><label><fmt:message key="lp1Mark" /></label> :</label> <input type="text" class="form-control"
					placeholder="Nhập điểm lp1" name="diemLp1" value="<c:out value='${sinhVien.getDiemLp1()}'/>">
			</div>
			<div class="form-group">
				<label><label><fmt:message key="lp2Mark" /></label> :</label> <input type="text" class="form-control"
					placeholder="Nhập điểm lp1" name="diemLp2" value="<c:out value='${sinhVien.getDiemLp2()}'/>">
			</div>
			<button type="submit" class="btn btn-default"><label><fmt:message key="save" /></label> </button>
		</form>

	</div>

</body>
</html>