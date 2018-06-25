<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <center>
        <h1>Sinh Viên Management</h1>
        <h2>
            <a href="new">Add New Sinh Viên</a>
            &nbsp;&nbsp;&nbsp;
            <a href="list">List All Sinh Viên</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${Sv != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${Sv == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${Sv != null}">
                        Edit Sinh Viên
                    </c:if>
                    <c:if test="${Sv == null}">
                        Add New SinhVien
                    </c:if>
                </h2>
            </caption>
                <c:if test="${Sv != null}">
                    <input type="hidden" name="id" value="<c:out value='${Sv.id}' />" />
                </c:if>           
            <tr>
                <th>Mã Sinh Viên: </th>
                <td>
                    <input type="text" name="masv" size="45"
                            value="<c:out value='${Sv.masv}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Tên Sinh Viên: </th>
                <td>
                    <input type="text" name="ten" size="45"
                            value="<c:out value='${Sv.ten}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngày Sinh: </th>
                <td>
                    <input type="text" name="ngaysinh" size="45"
                            value="<c:out value='${Sv.ngaysinh}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Quê Quán: </th>
                <td>
                    <input type="text" name="quequan" size="45"
                            value="<c:out value='${Sv.quequan}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Giới Tính: </th>
                <td>
                    <input type="text" name="gioitinh" size="45"
                            value="<c:out value='${Sv.gioitinh}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Lớp: </th>
                <td>
                    <input type="text" name="lop" size="5"
                            value="<c:out value='${Sv.lop}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Điểm Lp1: </th>
                <td>
                    <input type="number" name="lp1" size="5"
                            value="<c:out value='${Sv.lp1}' />"
                    />
                </td>
            </tr>
             <tr>
                <th>Điểm Lp2: </th>
                <td>
                    <input type="number" name="lp2" size="5"
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