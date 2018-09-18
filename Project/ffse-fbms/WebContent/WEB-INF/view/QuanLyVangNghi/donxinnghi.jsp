
    <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông Tin Nghỉ</title>
<style>
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

#formthongtin {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>
<body>
	
<jsp:include page="/WEB-INF/view/templates/header.jsp" />
<div class="app-content content container-fluid">
	<div class="content-wrapper">
		<!-- Path -->
		<center><h1>Thông Tin Nghỉ</h1></center>
<div id ='formthongtin'>
  <form action="">
    <label for="tPhong">Tên phòng ban</label>
    <input type="text" name="tPhong" placeholder="Tên phòng ban">

    <label for="tenNv">Tên nhân viên</label>
    <input type="text"  name="tenNv" placeholder="Tên nhân viên">

   <div>
		<label>Ngày kết thúc</label>
		<fieldset class="form-group position-relative">
		<input type="date" class="form-control round" id="from" />
			<div class="form-control-position">
				<i class="fa fa-calendar-o"></i>
			</div>
		</fieldset>
	</div>
    
    <label for="denNgay">Thời gian nghỉ đến ngày</label>
    <input type="text"  name="denNgay" placeholder="Thời gian nghỉ đến ngày">

	 <label for="denNgay">Lý do</label>
	 <select>
		  <option value="volvo"></option>
	</select>
	 
  	 <label for="tongNgayNghi">Tổng số ngày nghỉ</label>
    <input type="text"  name="tongNgayNghi" placeholder="Tổng số ngày nghỉ">
  	
  	<input type="submit" value="Lưu nháp">
    <input type="submit" value="Gửi">
  </form>
</div>

<jsp:include page="/WEB-INF/view/templates/footer.jsp" />
</body>
</html>

