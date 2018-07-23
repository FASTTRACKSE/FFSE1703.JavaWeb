<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>THÊM SINH VIÊN</title>
</head>
<body>
    <center>
        <h1>QUẢN LÝ DANH SÁCH SINH VIÊN</h1>
        <h2>
            &nbsp;&nbsp;&nbsp;
            <a href="/SinhVienCrud/ListSV/">LIST SINH VIÊN</a>
             
        </h2>
    </center>
    <div align="center">
            <form action="/SinhVienCrud/ListSV/insert" method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                        THÊM SINH VIÊN
                </h2>
            </caption>
                    
            <tr>
                <th>MÃ SINH VIÊN: </th>
                <td>
                    <input type="text" name="maSV" size="45"
                        />
                </td>
            </tr>
            <tr>
                <th>TÊN SINH VIÊN: </th>
                <td>
                    <input type="text" name="name" size="45"
                    />
                </td>
            </tr>
            <tr>
                <th>GIỚI TÍNH: </th>
                <td>
                    <input type="text" name="sex" size="15"
                    />
                </td>
            </tr>
                    <tr>
                <th>TUỔI: </th>
                <td>
                    <input type="text" name="age" size="15"
                    />
                </td>
            </tr>        <tr>
                <th>LỚP: </th>
                <td>
                    <input type="text" name="cls" size="45"
                    />
                </td>
            </tr>        <tr>
                <th>ĐỊA CHỈ: </th>
                <td>
                    <input type="text" name="dress" size="45"
                    />
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