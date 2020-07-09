<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Verify Email</title>
</head>


<body style="background: #222925 ;">

<form align="center" style="color: red;
font-size: 30px;
font-family: Love Nature, Century, Consolas, Courier New;
background: #222925 ;
padding: 76px;" method="post">

Verification Code : <input type="text" id="vcode" name="vcode" size=30 style="height:30px; font-size:12pt;"><br><br>

<input type="submit" id="verify" value="Verify My Account" onclick="form.action ='RecoverCredentials.jsp';"
style="font-family: Backslash; 
font-size: 35px; 
padding: 5px; 
background-color: red; 
color: white;">

</form>



</body>
</html>