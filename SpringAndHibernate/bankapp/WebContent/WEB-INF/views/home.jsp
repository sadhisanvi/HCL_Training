<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome, ${sessionScope.user.userType}</h3>  <br>
<c:if test="${sessionScope.user.userType == 'ADMIN'}">
	<a href="showallusers"> Show All Users </a> <br>
	<a href="showallaccounts"> Show All Accounts </a> <br>
	<a href="adduser"> Add User </a> <br>
	<a href="addaccount"> Add Account </a> <br>
	<a href="login"> Logout </a>
	
</c:if>

<c:if test="${sessionScope.user.userType == 'MANAGER'}">
	<a href="showallaccounts"> Show All Accounts </a> <br>
	<a href="addaccount"> Add Account </a> <br>
	<a href="transfer"> Transfer </a> <br>
	<a href="withdraw"> Withdraw </a> <br>
	<a href="deposit"> Deposit </a> <br>
	<a href="login"> Logout </a>
</c:if>

<c:if test="${sessionScope.user.userType == 'CLERK'}">
	<a href="showalltransactions"> Show All Transactions </a> <br>
	<a href="login"> Logout </a>
</c:if>

</body>
</html>