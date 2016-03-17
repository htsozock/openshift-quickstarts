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
 
<header>
    <h1><img src="usaid_logo.png" alt="USAID Logo" style="width:400px;height:280px;">  <b><p>Development Information Solution (DIS)  </p></b></h1>
  
  </header>
  <hr>
  
    <B> <h2>Edit Project</h2></B>
    <br />
  <hr size="15">
    <form method="POST" action='MainServlet' name="frmAddProject">
    
        Project ID    &nbsp;&nbsp;    <input type="text" readonly="readonly" name="id"  size="10"  disabled 
            value="<c:out value="${entry.id}" />" /> <br /> 
             <br />
        Project  Name &nbsp;&nbsp;  <input       type="text" name="name" size="50" 
            value="<c:out value="${entry.name}" />" /> &nbsp;
         Organization   <input
            type="text" name="organization" size="40"
            value="<c:out value="${entry.organization}" />" /> <br /> 
            <br />
         Project Manager  <input      type="text" name="manager" size="50"
                    value="<c:out value="${entry.manager}" />" /> 
                   
         Status    <input
            type="text" name="status" size="40"
            value="<c:out value="${entry.status}" />" /> <br />    
            <br />
        Start Date    <input
            type="text" name="startdt" size="40"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${entry.startdt}" />" /> &nbsp;&nbsp;
        End  Date     <input
            type="text" name="enddt" size="40"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${entry.enddt}" />" /> <br /> 
     
            
            <label for="description">Description </label>
                     <textarea name="description" id="description"  rows="4" cols="80"></textarea> 
     
            <br /><br />
          <hr size="15">
          <b> <button type="submit" class="btn btn-default">Submit</button></b>
               <button type="reset" formaction="/MainServlet?action=project">Reset</button>
                 <button type="submit" formaction="/MainServlet?action=listProject" >Return</button>
                
    </form>


</body>
</html>

