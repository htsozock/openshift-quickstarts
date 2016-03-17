<!-- I am using JSTL to connect between the jsp and the servlet -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link type="text/css" rel="stylesheet" media="screen" href="resources/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" media="screen" href="resources/css/bootstrap-theme.min.css"/>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>  USAID - Development Information Solution (DIS) </title>
</head>
<body>
 
    <header>
    <h1><img src="usaid_logo.png" alt="USAID Logo" style="width:400px;height:280px;">  </h1>
    </header>
    <big> <h1><b><p>Development Information Solution (DIS)  </p></b</h1> </big>
      <hr size="15">
     <br />
  <h1 align="right"><big> <p><a href="MainServlet?action=insert" >[+]Add Project</a></p></big></h1> 
    <div class="container">
 
 
    <ul class="nav nav-tabs">
    <li class="active" <a href="MainServlet?action=listProject" >Projects</a></li>
    <li><a href="#">Activities</a></li>
    <li><a href="#">Indicators</a></li>
    <li><a href="#">Tags</a></li>
    <li><a href="#">Search</a></li>
    <li><a href="#">Reports</a></li>
  </ul>
 </div> 

 <hr size="15">
<table style="width:98%"  border=2>
       <thead>
            <tr>
                
                <th> ID</th>
                <th>Project Name</th>
                <th>Organization</th>
                <th>Project Manager</th>
                <th>Start Date</th>
                 <th>End Date</th>
                 <th>Status</th>
               <th colspan=3>Action</th>
            </tr>
      </thead> 
        <tbody>
            <c:forEach items="${list}" var="entry">
                <tr>
                    <td><c:out value="${entry.id}" /></td>
                    <td><c:out value="${entry.name}" /></td>
                    <td><c:out value="${entry.organization}" /></td>
                    <td><c:out value="${entry.manager}" /></td>
                    <td><fmt:formatDate pattern="dd-MMM-yyyy" value="${entry.startdt}" /></td>
                    <td><fmt:formatDate pattern="dd-MMM-yyyy" value="${entry.enddt}" /></td>
                    <td><c:out value="${entry.status}" /></td>
                 
                    <td><a href="MainServlet?action=delete&projectId=<c:out value="${entry.id}"/>">Delete</a></td>
                     <td><a href="MainServlet?action=edit&projectId=<c:out value="${entry.id}"/>">Edit</a></td>
                       <td><a href="MainServlet?action=edit&projectId=<c:out value="${entry.id}"/>">Update</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
   
  
</body>
</html>



