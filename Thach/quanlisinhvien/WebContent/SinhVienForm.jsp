<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <center>
        <h1>Books Management</h1>
        <h2>
            <a href="/new">Add New Sinh Viên</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List All Sinh Viên</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${SinhVien != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${SinhVien == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${SinhVien != null}">
                        Edit Book
                    </c:if>
                    <c:if test="${SinhVien == null}">
                        Add New SinhVien
                    </c:if>
                </h2>
            </caption>
                <c:if test="${SinhVien != null}">
                    <input type="hidden" name="id" value="<c:out value='${Sv.id}' />" />
                </c:if>           
            <tr>
                <th>Mã Sinh Viên: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${Sv.masv}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Full Name: </th>
                <td>
                    <input type="text" name="author" size="45"
                            value="<c:out value='${Sv.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Class: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${Sv.class}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Điểm Lp1: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${Sv.lp1}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Điểm Lp2: </th>
                <td>
                    <input type="text" name="price" size="5"
                            value="<c:out value='${Sv.lp2}' />"
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