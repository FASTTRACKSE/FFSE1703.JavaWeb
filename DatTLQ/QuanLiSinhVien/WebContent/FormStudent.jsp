<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
		<h1>Quản Lí Sinh Viên</h1>
        <h2>
        	<a href="student">Trở về</a>
        	&nbsp;&nbsp;&nbsp;
        	        	
        </h2>
	</center>
    <div align="center">
		<form action="" method="post">
        <table border="1" cellpadding="5">
            <caption>
            	<h2>
            		<c:if test="${sv != null}">
            			Edit Student
            		</c:if>
            		<c:if test="${sv == null}">
            			Add Student
            		</c:if>
            	</h2>
            </caption>
        		<c:if test="${sv != null}">
        			<input type="hidden" name="id" value="<c:out value='${sv.id}' />" />
        		</c:if>            
            <tr>
                <th>Họ Đệm: </th>
                <td>
                	<input type="text" name="firstName" size="45"
                			value="<c:out value='${sv.firstName}' />"
                		/>
                </td>
            </tr>
            <tr>
                <th>Tên: </th>
                <td>
                	<input type="text" name="txtName" size="45"
                			value="<c:out value='${sv.txtName}' />"
                	/>
                </td>
            </tr>
            <tr>
                <th>Ngày Sinh: </th>
                <td>
                	<input type="text" name="txtDate" size="45"
                			value="<c:out value='${sv.txtDate}' />"
                	/>
                </td>
            </tr>
             <tr>
                <th>Giới Tính: </th>
                <td>
                	<input type="text" name="txtSex" size="45"
                			value="<c:out value='${sv.txtSex}' />"
                	/>
                </td>
            </tr>
             <tr>
                <th>Quê Quán: </th>
                <td>
                	<input type="text" name="queQuan" size="45"
                			value="<c:out value='${sv.queQuan}' />"
                	/>
                </td>
            </tr>
             <tr>
                <th>Lớp: </th>
                <td>
                	<input type="text" name="txtLop" size="45"
                			value="<c:out value='${sv.txtLop}' />"
                	/>
                </td>
            </tr>
             <tr>
                <th>Điểm LP1: </th>
                <td>
                	<input type="text" name="lp1" size="45"
                			value="<c:out value='${sv.lp1}' />"
                	/>
                </td>
            </tr>
              <tr>
                <th>Điểm LP2:  </th>
                <td>
                	<input type="text" name="lp2" size="45"
                			value="<c:out value='${sv.lp2}' />"
                	/>
                </td>
            </tr>
              
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" name="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>