<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Spring MVC Redirect</title>
</head>
<body>
	<h2>Page1</h2>
	<%--   SEND REDIRECT
  <form:form method="POST" action="redirect">
    <input type="submit" value="Redirect" />
  </form:form> --%>

	<!--  SEND REDIRECT CẤP 2 -->
	<form:form method="GET" action="redirect">
    Name: <input type="text" name="name">
		<br />
		<input type="submit" value="Redirect" />
	</form:form>

</body>
</html>