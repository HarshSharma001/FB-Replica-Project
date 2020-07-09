<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="sq" uri="http://java.sun.com/jsp/jstl/sql" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="AdminLayout.css">

<title>Admin Database</title>


</head>
<body align="center">

<sq:setDataSource var="db" driver="oracle.jdbc.driver.OracleDriver" 

url="jdbc:oracle:thin:@DESKTOP-N6R0FO5:1521:XE" user="system" password="angiosperm" />

<sq:query var="rs" dataSource="${db}">select *from userAccounts</sq:query>

<p><b><u> FB Replica Database</u></b></p>

<table align="center">
<tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Username</th> 
    <th>Password</th>       
</tr>
<c:forEach items="${rs.rows}" var="accounts"> 

<tr>
    <td>${accounts.First_Name}</td>
    <td>${accounts.Last_Name}</td>
    <td>${accounts.Email}</td>
    <td>${accounts.Username}</td>
    <td>${accounts.Password}</td>
  </tr>

</c:forEach>
</table> <br><br>

<a href="Index.jsp" style="font-family: Century; height:15px; font-size:20pt;

color:red;">
Logout</a>

</body>
</html>