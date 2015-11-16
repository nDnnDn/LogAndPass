<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LogPassServlet" method=Post> 
 		Enter login:
 		<input type="text" name="login"><br>
		Enter password:
		<input type="text" name="password"><br>
		Enter your first name:
		<input type="text" name="firstname"><br>
		Enter your last name:
		<input type="text" name="lastname"><br>
		Enter your email:
		<input type="text" name="email"><br>
		<input type="submit" value="Register" name="registerInDB">	
	</form>
</body>
</html>