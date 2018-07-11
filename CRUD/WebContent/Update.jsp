<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SỬA SINH VIÊN</title>
</head>
<body>
    <center>
        <h1>QUẢN LÝ DANH SÁCH SINH VIÊN</h1>
        <h2>
            &nbsp;&nbsp;&nbsp;
            <a href="/CRUD/CRUDSV/">LIST SINH VIÊN</a>
             
        </h2>
    </center>
    <div align="center">
            <form action="/CRUD/CRUDSV/update" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                        SỬA SINH VIÊN
                </h2>
            </caption>
                    
            <tr>
                <th>MÃ SINH VIÊN: </th>
                <td>
                <c:if test="${SV != null}">
                    <input type="text" name="userid" size="45"
                     value="${SV.getId()}"/>
                      </c:if>
                </td>
            </tr>
            
            <tr>
                <th>TÊN SINH VIÊN: </th>
                <td>
                    <input type="text" name="name" size="45"
                     value="${SV.getName()}"/>
                </td>
            </tr>
            <tr>
                <th>GIỚI TÍNH: </th>
                <td>
                    <input type="text" name="gioitinh" size="15"
                     value="${SV.getGioitinh()}"/>
                </td>
            </tr>
                    <tr>
                <th>NGÀY SINH: </th>
                <td>
                    <input type="text" name="ngaysinh" size="15"
                     value="${SV.getNgaysinh()}"/>
                </td>
            </tr>        <tr>
                <th>LỚP: </th>
                <td>
                    <input type="text" name="lop" size="45"
                     value="${SV.getLop()}"/>
                </td>
            </tr>        <tr>
                <th>ĐỊA CHỈ: </th>
                <td>
                    <input type="text" name="quequan" size="45"
                     value="${SV.getQuequan()}"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
                
            </tr>
            
        </table>
        </form>
    </div>   
</body>
</html>