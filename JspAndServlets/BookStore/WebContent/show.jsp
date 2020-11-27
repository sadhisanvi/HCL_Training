<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show all books</title>

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
tr:nth-child(even) {
  background-color: #dddddd;
}
.links a {
  background-color: #4CAF50;
  text-decoration: none;
  text-align: center;
  color: white;
  float:left;
  padding: 14px 25px;
  margin: 8px 10px;
  border: none;
  cursor: pointer;
  width: 200px;
}
.links > a:hover {
  opacity: 0.8;
}
h2 {
	color:red;
	
}
</style>
</head>
<body>
<br>
<h2>Welcome ${sessionScope.user.username}!</h2> <br>
<div class="links">
	
	<a href="BookController.do?action=addbook">add new book</a>
	
	<c:if test="${login.profile == 'admin'}">
	<a href="UserManagementController.do?action=adduser">add new user</a>
	</c:if>
	
	<a href="LogoutController">Logout</a>
</div>


<table>
	<tr>
		<th>id</th>
		<th>isbn</th>
		<th>title</th>
		<th>author</th>
		<th>publish date</th>
		<th>price</th>
		<c:if test="${login.profile == 'admin' || login.profile == 'mgr'}">
		<th>Update</th>
		</c:if>
		
		<c:if test="${login.profile == 'admin'}">
		<th>Delete</th>
		</c:if>
		
	</tr>
	<c:forEach var="book" items="${books}">
	
	<tr>
		<td>${book.id}</td>
		<td><c:out value="${book.isbn}"></c:out> </td>
		<td><c:out value="${book.title}"></c:out> </td>
		<td><c:out value="${book.author}"></c:out> </td>
		<td><c:out value="${book.pubDate}"></c:out> </td>
		<td><c:out value="${book.price}"></c:out> </td>
		
		<c:if test="${login.profile == 'admin' || login.profile == 'mgr'}">
		<td><a href="BookController.do?action=updatebook&id=${book.id}">Update</a></td>
		</c:if>
		<c:if test="${login.profile == 'admin'}">
		<td><a href="BookController.do?action=deletebook&id=${book.id}">Delete</a></td>
		</c:if>
	</tr>
	</c:forEach>
</table>
</body>
</html>
