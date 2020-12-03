<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hcl bank app</title>
<style type="text/css">
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
</style>

</head>
<body>
<table>
    <thead>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>balance</th>
            <th>address</th>
            <th>phone</th>
            <th>email</th>
             <th>aadharcard no</th>
             <th>pancard no</th>
            <th>update</th>
            <th>delete</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${accounts}" var="account">
            <tr>
                <td>${account.accountId}</td>
                <td>${account.name}</td>
                <td>${account.balance}</td>
                <td>${account.address}</td>
                <td>${account.phone}</td>
                <td>${account.email}</td>
                <td>${account.aadharCard}</td>
                <td>${account.panNumber}</td>
                <td><a href="updateaccount?id=${account.accountId}">update account</a></td>
                <td><a href="deleteaccount?id=${account.accountId}">delete account</a></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>