<%@page import="javax.websocket.SendResult"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="Servlets_And_Filters.*"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create New Account</title>
<link rel="stylesheet" type="text/css" href="Style1.css">
</head>

<body>

<form align="center" method="get">

<img src="img_509460.png" border="0" height="300"  width="550" align="left">

First Name : <input type="text" id="fname" name="fname" size=30><br> <br>

Last Name  : <input type="text" id="lname" name="lname" size=30><br><br>

Email : <input type="text" id="email" name="email" size=30><br> <br>

Username : <input type="text" id="uname" name="uname" size=30><br><br>

Password : <input type="password" id="pass" name="pass" size=30><br><br><br>

<input type="submit" id="createAccount" value="Create Account" onclick="form.action='Input1';">
</form>


</body>

</html>