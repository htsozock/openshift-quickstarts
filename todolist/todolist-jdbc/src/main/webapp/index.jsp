<!-- This jsp serves as the entry point for our application. In this case, it will redirect the request to our servlet to list all the projects in the database. -->


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>  USAID - Development Information Solution (DIS) </title>
</head>
<body>
   <jsp:forward page="/MainServlet?action=listProject" />
</body>
</html>

