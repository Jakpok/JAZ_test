<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Enter your credentials</h2>
	<form action="login">
	<table>
	  <tr><td><label>Username: </td><td><input type="text" pattern=".{3,30}" name="username"/></label></td></tr>
	  <tr><td><label>Password: </td><td><input type="password" pattern=".{3,30}" name="password"/></label></td></tr>
	  <tr><td><input type="submit" value="Login"></td></tr>
	  </table>
	</form> 
	<br/><br/><a href="home.jsp">Home</a>
</body>
</html>