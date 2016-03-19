<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css"   href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
 <link type="text/css" rel="stylesheet" media="screen" href="resources/css/bootstrap.min.css"/>
 <link type="text/css" rel="stylesheet" media="screen" href="resources/css/bootstrap-theme.min.css"/>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
 <link type="text/css" rel="stylesheet" media="screen" href="resources/css/bootstrap.min.css"/>
 <link type="text/css" rel="stylesheet" media="screen" href="resources/css/bootstrap-theme.min.css"/>
  
  <link type="text/css" rel="stylesheet" media="screen" href="resources/css/container.css"/>
 
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
 
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  
  <link href="//assets.cms.gov/Resources/libs/jquery-ui/1.10.3/css/jquery-ui.css" rel="stylesheet">
<link href="//assets.cms.gov/resources/libs/bootstrap/2.2.2/css/bootstrap.css" rel="stylesheet">
<link href="//assets.cms.gov/resources/libs/bootstrap/2.2.2/css/bootstrap-responsive.css" rel="stylesheet">
<link href="//assets.cms.gov/resources/libs/glyphicons/3.0/css/glyphicon.css" rel="stylesheet">
<link href="//assets.cms.gov/resources/libs/font-awesome/3.0.2/css/symbol.css" rel="stylesheet">
<link href="/resources/2.0/framework/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="//assets.cms.gov/resources/global/css/buttons-2.0.css" />
<!-- <link rel="stylesheet" href="//assets.cms.gov/resources/libs/datepicker/v6/css/datepicker.css" /> -->
  <link href="//assets.cms.gov/resources/libs/sharewidget/2.0/css/sharewidget-2.0.css" rel="stylesheet" />
  
<title>  USAID - Development Information Solution (DIS) </title>

<!-- <div id="container" style="text-align: left;"> <img src="usaid_logo.png" alt="USAID Logo" style="width:440px;height:220px;"></div>
<div id="container" style="text-align: center;"> <img src="usaid_logo5.png" alt="USAID Logo"  alt=" Development Information Solution (DIS)" style="width:440px;height:220px;"></div> -->

 <script>
        $(function() {
            $('input[name=startdt]').datepicker();
            $('input[name=enddt]').datepicker();
        });
    </script>
    
 </head>   
    
<body>

 <div id="header" style="text-align: left >
 <img src="usaid_logo.png" alt="USAID Logo" style="width:440px;height:220px;"></div>
</div>
  <div id="header" style="text-align: center >
  <h1> Development Information Solution (DIS)</h1>
</div>
      <!-- <hr size="15"> -->
      <B> <h2>Add Project</h2></B>
       <br />
        <big><p><a href="MainServlet?action=listProject" >HOME</a></p></big>
        
  <div class="container-fluid">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
  
   <form method="POST" action='MainServlet' name="frmAddProject">
    
         Project ID :  <input type="text" readonly="readonly" name="id"  size="10"  disabled  value="<c:out value="${entry.id}" />" /> &nbsp;&nbsp; &nbsp;&nbsp;
          
         Project  Name : &nbsp;&nbsp; &nbsp;&nbsp;  <input       type="text" name="name" size="40"  title="Enter the project name..."      value="<c:out value="${entry.name}" />" /> &nbsp;&nbsp;
                
         Organization :  <input   type="text" name="organization" size="40"      value="<c:out value="${entry.organization}" />" /> <br /> 
         
         Project Manager : &nbsp; <input   type="text" name="manager" size="50"  value="<c:out value="${entry.manager}" />" /> &nbsp;&nbsp;&nbsp;&nbsp;
         
         Status : &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input   type="text" name="status" size="40"  value="<c:out value="${entry.status}" />" /> <br />    
        
         Start Date :   <input   type="text" name="startdt" size="50"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${entry.startdt}" />" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
         
         End  Date  :     &nbsp;&nbsp;&nbsp; &nbsp;  <input    type="text" name="enddt" size="40"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${entry.enddt}" />" /> <br /> 
           <br /> <br /> 
        
         Description :  &nbsp;&nbsp; &nbsp; &nbsp;     <textarea name="description"  rows="4" cols="95"></textarea> 
          <br /><br />
          <hr size="15">
        <!--   <b> <button type="submit" class="btn btn-default">Save</button></b> -->
             <button type="submit"  class="btn app_button">SAVE &amp; CONTINUE</button>         
                
    </form>
    
    
    
</body>
</html>

