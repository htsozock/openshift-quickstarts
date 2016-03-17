<!-- I am using JSTL to connect between the jsp and the servlet -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display  All Projects</title>
</head>
<body>
<table border=1>
        <thead>
            <tr>
                <th>Project ID</th>
                <th>Project Name</th>
                <th>Organization</th>
                <th>Project Manager</th>
                <th>Start Date</th>
                 <th>End Date</th>
                  <th>Status</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list}" var="entry">
                <tr>
                    <td><c:out value="${entry.id}" /></td>
                    <td><c:out value="${entry.name}" /></td>
                    <td><c:out value="${entry.organization}" /></td>
                    <td><c:out value="${entry.manager}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${entry.startdt}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${entry.enddt}" /></td>
                    <td><c:out value="${entry.status}" /></td>
                    <td><a href="MainServlet?action=edit&projectId=<c:out value="${entry.id}"/>">Update</a></td>
                    <td><a href="MainServlet?action=delete&projectId=<c:out value="${entry.id}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="MainServlet?action=insert">Add Project</a></p>
</body>
</html>



