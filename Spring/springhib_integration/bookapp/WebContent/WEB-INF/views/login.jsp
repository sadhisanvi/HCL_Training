<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LogIn</title>
</head>
<body>
<br>
	<form:form action="login" method="post" modelAttribute="account">
		<table>
			<tr>
				<td>Enter username:</td>
				<td><form:input path="username"/></td>
			</tr>
			
			<tr>
				<td>Enter password:</td>
				<td><form:input path="password"/></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="login"> </td>				
			</tr>
		</table>
	</form:form>
</body>
</html>