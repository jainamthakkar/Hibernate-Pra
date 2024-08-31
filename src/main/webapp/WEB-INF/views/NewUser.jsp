<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New User</h1>
	
	<form action="loginuser" method="post">
		FirstName : <input type="text" name="firstname"/><br><br>
		Email : <input type="email" name="email"/><br><br>
		Password : <input type="password" name="password"/><br><br>
		<input type="submit" value="Login"/>
	</form>
</body>
</html>