<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<c:choose>
    <c:when test="${not empty param.theLocale}">
        <c:set var="theLocale" value="${param.theLocale}" scope="session" /> 
    </c:when>    
    <c:otherwise>
		<c:if test="${empty theLocale}">
		    <c:set var="theLocale" value="${pageContext.request.locale}" scope="session" />
		</c:if>
    </c:otherwise>
</c:choose>

<fmt:setLocale value="${theLocale}" />

<fmt:setBundle basename="myLanguages.Language" /> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<center>
        <h1>Students Management</h1>
        <h2>
            <a href="new"><fmt:message key="add"/></a>
            &nbsp;&nbsp;&nbsp;
            <a href="list"><fmt:message key="title"/></a>
             
        </h2>
    </center>
    <div align="center">
    <a href="http://localhost:8080/Assignment1/listsv?trang=1&theLocale=en_US">English</a>|
    <a href="http://localhost:8080/Assignment1/listsv?trang=1&theLocale=vi_VN">Viet Nam</a>|
    <a href="?language=ja_JP">Japanese</a>|
    <a href="?language=fr_FR">France</a>
        <table border="1" cellpadding="5">
            <caption><b>List of Students</b></caption>
            <tr>
                <th>ID</th>
                <th><fmt:message key="name"/></th>
                <th><fmt:message key="class"/></th>
                <th><fmt:message key="address"/></th>
                <th><fmt:message key="age"/></th>
                <th><fmt:message key="author"/></th>
                <th>LP#1</th>
                <th>LP#2</th>
                <th>Điểm TB</th>
                <th><fmt:message key="classification"/></th>
                <th><fmt:message key="actions"/></th>
            </tr>
            <c:forEach var="student" items="${listStudent}">
                <tr>
                    <td><c:out value="${student.id}" /></td>
                    <td><c:out value="${student.name}" /></td>
                    <td><c:out value="${student.clas}" /></td>
                    <td><c:out value="${student.address}" /></td>
                    <td><c:out value="${student.age}" /></td>
                    <td><c:out value="${student.author}" /></td>
                    <td><c:out value="${student.diemLp1}" /></td>                    
                    <td><c:out value="${student.diemLp2}" /></td>
                    <td><c:out value="${student.diemTrungBinh()}" /></td>
                    <td><c:out value="${student.xepLoai()}" /></td>
                    <td>
                        <a href="edit?id=<c:out value='${student.id}' />"><fmt:message key="edit"/></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a onclick='return canhbao()' href="delete?id=<c:out value='${student.id}' />"><fmt:message key="delete"/></a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
        <c:forEach var = "i" begin = "1" end = "${soTrang}">
         <a href="listsv?trang=<c:out value = '${i}'/>"> <c:out value = "${i}"/></a> <!-- listsv không trùng với case ở servlet nên tự nhảy vào case default -->
      </c:forEach>
    </div>   
    <script>
    function canhbao(){
    return confirm("Bạn Có Chắc Muốn Xóa Không?");
    }
</script>
</body>
</html>


