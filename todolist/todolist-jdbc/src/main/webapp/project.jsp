<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link type="text/css"   href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
 <link type="text/css" rel="stylesheet" media="screen" href="resources/css/bootstrap.min.css"/>
 <link type="text/css" rel="stylesheet" media="screen" href="resources/css/bootstrap-theme.min.css"/>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  
  
<title>  USAID - Development Information Solution (DIS) </title>


 <script>
        $(function() {
            $('input[name=startdt]').datepicker();
            $('input[name=enddt]').datepicker();
        });
    </script>
    
 </head>   
    
<body>
 
 <img src="usaid_logo.png" alt="USAID Logo" style="width:228px;height:228px;">
  <big><h1 align="right" >Development Information Solution (DIS)  </h1></big>
    <B> <h2>Edit Project</h2></B>
    <br />
     <br />
    <form method="POST" action='MainServlet' name="frmAddProject">
    
        Project ID     <input type="text" readonly="readonly" name="id"  size="10"  disabled 
            value="<c:out value="${entry.id}" />" /> <br /> 
             <br />
        Project  Name   <input
            type="text" name="name" size="50" 
            value="<c:out value="${entry.name}" />" /> &nbsp;
            
         <!--  Organization  <select>
            	<option value="South Africa" selected>South Africa</option>
  				<option value="Mali">Mali</option>
  				<option value="Afghanistan">Afghanistan</option>
 			    <option value="Egypt">Egypt</option>
				</select>
   -->
        
        Organization   <input
            type="text" name="organization" size="40"
            value="<c:out value="${entry.organization}" />" /> <br /> 
            <br />
       Project Manager <input
            type="text" name="manager" size="50"
            value="<c:out value="${entry.manager}" />" /> 
       
      <!--  Status :
       
          <select>
            	<option value="Active" selected>Active</option>
  				<option value="Inactive">Inactive</option>
  				<option value="Unknown">Unknown</option>
 			 
				</select> -->
       
         Status   <input
            type="text" name="status" size="40"
            value="<c:out value="${entry.status}" />" /> <br />    
            <br />
        Start Date : <input
            type="text" name="startdt" size="40"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${entry.startdt}" />" /> &nbsp;&nbsp;
        End  Date : <input
            type="text" name="enddt" size="30"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${entry.enddt}" />" /> <br /> 
     
            
            <label for="description">Description </label>
                     <textarea name="description" id="description"  rows="4"></textarea> 
            <%--  <input type="text" name="description" 
            value="<c:out value="${entry.description}" />" />  --%><br /> 
            <br /><br />
          <b> <button type="submit" class="btn btn-default">Submit</button></b>
                <b> <button type="reset" formaction="project.jsp">Reset</button></b>
                 <b> <button type="submit" formaction="listProject.jsp">Return</button></b>
                
    </form>


</body>
</html>

