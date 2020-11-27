<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book store login</title>
<style> 
<style>
body {font-family: Arial, Helvetica, sans-serif;}
.wrapper {
	text-align: center;
}
input[type=text], input[type=password] {
  width: 400px;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}
button {
  background-color: #4CAF50;
  color: white;
  padding: 14px 50px;
  margin: 8px 100px;
  border: none;
  cursor: pointer;
  width: 300px;
}
button:hover {
  opacity: 0.8;
}
.container {
  padding: 16px;
}
span.psw {
  float: right;
  padding-top: 16px;
}
h3 {
	color: red;
	text-align: center;
	
}
</style>
</head>
<body>
<br>
 
<div class="wrapper">
	<h3>${param.message}</h3>
	<form action="LoginController" method="post">
    <div class="container">
      <label for="usernameId"><b>Enter username</b></label>
      <input type="text" placeholder="Enter Username" name="username" id="usernameId"required>
		<br>
      <label for="passwordId"><b>Enter password</b></label>
      <input type="password" placeholder="Enter Password" name="password" id="passwordId" required>
        <br>
      <button type="submit">Login</button>
    </div>
  </form>
 </div>
</body>
</html>
