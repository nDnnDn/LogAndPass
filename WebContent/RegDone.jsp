<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="database.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
TableDB tab = new TableDB();
String log = (String)request.getAttribute("log");
String name = tab.getField("first_name", log);
%>
Welcome <%=request.getAttribute("log") %> !!!<br>
Your first name is <%=tab.getField("first_name", log) %><br>
Your last name is <%=tab.getField("last_name", log) %><br>
<a href="Error.jsp">Watch your personal data</a>
</body>
</html>