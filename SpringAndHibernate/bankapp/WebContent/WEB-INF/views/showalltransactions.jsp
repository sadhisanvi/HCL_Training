<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
            <th>transactionInfo</th>
            <th>date</th>
            <th>amount</th>
            <th>transactionType</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${transactions}" var="transaction">
            <tr>
                <td>${transaction.txId}</td>
                <td>${transaction.txInfo}</td>
                <td><fmt:formatDate  pattern="dd/MM/yyyy" value="${transaction.timestamp}"/></td>
                <td>${transaction.amount}</td>
                 <td>${transaction.txType}</td>       
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>