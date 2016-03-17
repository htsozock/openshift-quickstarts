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
 
 <img src="usaid_logo.png" alt="USAID Logo" style="width:128px;height:128px;">
  <B><p>Development Information Solution (DIS)</p></B>
    <B> <h2>Edit Project</h2></B>
    <form method="POST" action='MainServlet' name="frmAddProject">
    
        Project ID : <input type="text" readonly="readonly" name="id"  size="10" placeholder="Project ID is generated" disabled 
            value="<c:out value="${entry.id}" />" /> <br /> 
        Project  Name : <input
            type="text" name="name" size="50" 
            value="<c:out value="${entry.name}" />" /> 
        Organization : <select>
            	<option value="South Africa" selected>South Africa</option>
  				<option value="Mali">Mali</option>
  				<option value="Afghanistan">Afghanistan</option>
 			    <option value="Egypt">Egypt</option>
				</select>
  
        
        <input
            type="text" name="organization" size="30"
            value="<c:out value="${entry.organization}" />" /> <br /> 
            
       Project Manager : <input
            type="text" name="manager" size="50"
            value="<c:out value="${entry.manager}" />" /> 
       
       Status :
       
          <select>
            	<option value="Active" selected>Active</option>
  				<option value="Inactive">Inactive</option>
  				<option value="Unknown">Unknown</option>
 			 
				</select>
       
        <input
            type="text" name="status" size="30"
            value="<c:out value="${entry.status}" />" /> <br />    
            
        Start Date : <input
            type="text" name="startdt" size="30"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${entry.startdt}" />" /> 
        End  Date : <input
            type="text" name="enddt" size="30"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${entry.enddt}" />" /> <br /> 
     
            
            <label for="description">Description </label>
                     <textarea name="description" id="description"  placeholder="Full description of the project" rows="4"></textarea> 
             <input type="text" name="description" 
            value="<c:out value="${entry.description}" />" /> <br /> 
            
          <b> <button type="submit" class="btn btn-default">Save</button></b>
                <b> <button type="reset" class="btn btn-default">Reset</button></b>
    </form>


</body>
</html>

