<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Set premium</title>
</head>
<body>
	<h2>Manage users</h2>
	<form action="premiumManage">
	<table>
	  <tr><td><label>Username: </td><td><input type="text" name="username"/></label></td></tr>
	  <tr><td><label>Action: </label></td><td>
	  
	  	<select name="action">
		  <option value="set">Set as premium</option>
		  <option value="remove">Remove premium</option>
		</select> 
	  
	  </td></tr>
	  <tr><td><input type="submit" value="Send"></td></tr>
	  </table>
	</form> 
	<br/><br/><a href="home.jsp">Home</a>
</body>
</html>