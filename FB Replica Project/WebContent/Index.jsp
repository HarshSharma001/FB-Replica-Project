<!DOCTYPE html>
<html>
<head>
<title>FB Replica Login</title>
<link rel="stylesheet" type="text/css" href="Style.css">
</head>
<body>

<img src="images.png" border="0" height="300"  width="500" align="left">

<form align="center" method="get">

<p id="newAccount" align="right"><a href="CreateNewAccount.jsp">Create New Account</a></p>

Username : <input type="text" id="user" name="uname" size=30> <br><br>

Password : <input type="password" id="pass" name="pass" size=30><br>

&nbsp <p id="forgot"> <a href="Forgot.jsp">Forgot Username/Password</a></p> <br>

<input type="submit" id="userlog" value="User Login" onclick="form.action='User.jsp';">

<input type="submit" id="adminlog" value="Admin Login" onclick="form.action='Admin.jsp';">

</form>


</body>
</html>