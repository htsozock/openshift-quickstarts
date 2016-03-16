<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add New Project</title>
</head>
<body>
 <script>
        $(function() {
            $('input[name=startdt]').datepicker();
            $('input[name=enddt]').datepicker();
        });
    </script>

    <form method="POST" action='MainServlet' name="frmAddProject">
        Project ID : <input type="text" readonly="readonly" name="id"
            value="<c:out value="${entry.id}" />" /> <br /> 
        Project  Name : <input
            type="text" name="name"
            value="<c:out value="${entry.name}" />" /> <br /> 
        Organization : <input
            type="text" name="organization"
            value="<c:out value="${entry.organization}" />" /> <br /> 
            
       Project Manager : <input
            type="text" name="manager"
            value="<c:out value="${entry.manager}" />" /> <br /> 
       
       Status : <input
            type="text" name="status"
            value="<c:out value="${entry.status}" />" /> <br />    
            
        Start Date : <input
            type="text" name="startdt"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${entry.startdt}" />" /> <br /> 
        End  Date : <input
            type="text" name="enddt"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${entry.enddt}" />" /> <br /> 
        Description : <input type="text" name="description"
            value="<c:out value="${entry.description}" />" /> <br /> <input
            type="submit" value="Submit" />
    </form>


</body>
</html>

