<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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

<c:if test="${sv == null}">
	<h1 style="text-align: center;">Thêm sinh viên</h1>
	<form action="insert">
</c:if>
<c:if test="${sv != null}">
	<h1 style="text-align: center;">Cập nhật sinh viên</h1>
	<form action="update">
</c:if>	
		<input type="hidden" name="id" value="${sv.id }">
		<div class="form-group">
			<label>Họ đệm</label>
			<input class="form-control" type="text" value="${sv.hodem }" name="hodem" required="required" >
			
		</div>
		<div class="form-group">
			<label>Tên</label>
			<input class="form-control" type="text" value="${sv.ten }" name="ten" required="required" >
			
		</div>
		<div class="form-group">
			<label>Ngày sinh</label>
			<input class="form-control" type="text" value='<c:out value="${sv.ngaysinh }"/>' name="ngaysinh" required="required" >
			
		</div>
		<div class="form-group">
			<label>Giới tính</label>
			<select class="form-control" name="gioitinh" required="required">
				<option ${sv.gioitinh == '' ? 'selected' : ''} value="">Chọn giới tính</option>
				<option ${sv.gioitinh == 'Nam' ? 'selected' : ''} value="Nam" >Nam</option>
				<option ${sv.gioitinh == 'Nữ' ? 'selected'  : ''} value="Nữ" >Nữ</option>
			</select>
		</div>
		<div class="form-group">
			<label>Quê quán</label>
			<input class="form-control" type="text" value="${sv.quequan }" name="quequan" required="required" >
			
		</div>
		<div class="form-group">
			<label>Lớp</label>
			<select class="form-control" name="lop" required="required">
				<option ${sv.lop == '' ? 'selected' : ''} value="">Chọn lớp học</option>
				<option ${sv.lop == 'FFSE1701' ? 'selected' : ''} value="FFSE1701">FFSE1701</option>
				<option ${sv.lop == 'FFSE1702' ? 'selected' : ''} value="FFSE1702" >FFSE1702</option>
				<option ${sv.lop == 'FFSE1703' ? 'selected' : ''} value="FFSE1703" >FFSE1703</option>
				<option ${sv.lop == 'FFSE1704' ? 'selected' : ''} value="FFSE1704" >FFSE1704</option>
				<option ${sv.lop == 'FFSE1801' ? 'selected' : ''} value="FFSE1801" >FFSE1801</option>
			</select>
		</div>
		<div class="form-group">
			<label>Điểm LP1</label>
			<input class="form-control" type="text" value="${sv.diemlp1 }" name="diemlp1" required="required" >
			
		</div>
		<div class="form-group">
			<label>Điểm LP2</label>
			<input class="form-control" type="text" value="${sv.diemlp2 }" name="diemlp2" required="required" >
			
		</div>
		<button class="btn btn-primary" type="submit" >Submit</button>
	</form>	
</body>
</html>