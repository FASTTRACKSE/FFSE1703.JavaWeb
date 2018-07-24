<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

input[type=submit] {
    width: 100%;
    background-color: green;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

div {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>
<body>
<form action="add" method="post">
<center><h1>Thêm sinh viên</h1></center>
  <label for="fname">Họ Đệm</label>
  <input type="text"  name="hodem" placeholder="Họ đệm...">
  <label for="fname">Tên Sinh Viên</label>
  <input type="text"  name="ten" placeholder="Tên sinh viên...">
  <label for="fname">Mã Sinh Viên</label>
  <input type="text"  name="ma" placeholder="Mã sinh viên...">
  <label for="fname">Ngày Sinh</label>
  <input type="text"  name="ngsinh" placeholder="Ngày sinh...">
  <label for="fname">Quê Quán</label>
  <input type="text"  name="quequan" placeholder="Quê quán...">
  <label for="fname">Giới Tính</label>
  <input type="text"  name="gioitinh" placeholder="Giới tính...">
  <label for="fname">Điểm LP1</label>
  <input type="text"  name="lp1" placeholder="Điểm LP1...">
  <label for="fname">Điểm LP2</label>
  <input type="text"  name="lp2" placeholder="Điểm LP2...">
  <center><input type="submit" value="Thêm"></center>
  
</form>

</body>
</html>