<!-- I am using JSTL to connect between the jsp and the servlet -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link type="text/css" rel="stylesheet" media="screen" href="../resources/css/bootstrap.min.css"/>
    <link type="text/css" rel="stylesheet" media="screen" href="../resources/css/bootstrap-theme.min.css"/>

<title>  USAID - Development Information Solution (DIS) </title>
</head>
<body>
 <B> <h1>USAID</h1></B>
 <img src="usaid_logo.png" alt="USAID Logo" style="width:128px;height:128px;">
  <B><p>Development Information Solution (DIS)</p></B>
<table style="width:100%"  border=1>
       <thead>
            <tr>
                <th colspan=3>Action</th>
                <th> ID</th>
                <th>Project Name</th>
                <th>Organization</th>
                <th>Project Manager</th>
                <th>Start Date</th>
                 <th>End Date</th>
                 <th>Status</th>
               
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
                    <td><a href="MainServlet?action=edit&projectId=<c:out value="${entry.id}"/>">Update</a></td>
                    <td><a href="MainServlet?action=delete&projectId=<c:out value="${entry.id}"/>">Delete</a></td>
                    <td><a href="MainServlet?action=edit&projectId=<c:out value="${entry.id}"/>">Edit</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
   <b> <p><a href="MainServlet?action=insert" target="_ref">[+]Add Project</a></p></b>
</body>
</html>



