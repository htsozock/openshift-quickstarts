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
  <link type="text/css" rel="stylesheet" media="screen" href="../resources/css/bootstrap.min.css"/>
   <link type="text/css" rel="stylesheet" media="screen" href="../resources/css/bootstrap-theme.min.css"/>
     <link type="text/css" rel="stylesheet" media="screen" href="resources/css/container.css"/>
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
<link rel="stylesheet" href="//assets.cms.gov/resources/libs/datepicker/v6/css/datepicker.css" />
  <link href="//assets.cms.gov/resources/libs/sharewidget/2.0/css/sharewidget-2.0.css" rel="stylesheet" />
<title>  USAID - Development Information Solution (DIS) </title>

<div id="container" style="text-align: left;"> <img src="usaid_logo.png" alt="USAID Logo" style="width:440px;height:220px;"></div>
 <script>
        $(function() {
            $('input[name=startdt]').datepicker();
            $('input[name=enddt]').datepicker();
        });
    </script>
    
 </head>   
    
<body>

 
      <hr size="15">
  
    <B> <h2>Add Project</h2></B>
    
    <br />
        <big><p><a href="MainServlet?action=listProject" >Projects</a></p></big>
  <hr size="15">
  
  <div class="container-fluid">
    <div class="row">
        <div class="col-sm-6 col-sm-offset-3">
  
    <form method="POST" action='MainServlet' name="frmAddProject" role="form">
        
         <div class="form-group">
           <label class="col-sm-2 control-label" for="id">Project ID </label>
              <input type="text" readonly="readonly" name="id"  id="id"  class="form-control"   disabled  /> <br /> 
          </div>
             <br />
        <div class="form-group">
         <label class="col-sm-2 control-label" for="name">Project Name </label>
          <input type="text" name="name" id="name" class="form-control"  title ="Enter project name" >
         </div>
       <div class="form-group">
         <label class="col-sm-2 control-label" for="organization"> Organization </label>
        <input type="text" name="organization" id="organization" class="form-control"  title ="Enter project organization.." ><br />
        </div>
        <br />
        <div class="form-group">
        <label class="col-sm-2 control-label" for="organization"> Project Manager </label>
        <input type="text" name="manager" id="manager" class="form-control"  title ="Enter project manager.." ><br />
        </div>  
         <div class="form-group">
         <select name="status">
        <option value="Active">Active</option>
         <option value="Inactive">Inactive</option>
        <option value="Unknown">Unknown</option>
    
           </select>
        </div>
       <br> <br>
        <div class="form-group">
              <label class="col-sm-2 control-label" for="startdt">Start Date</label>
         <input type="text"    name="startdt" value="<fmt:formatDate pattern="MM/dd/yyyy"  />
      
        </div>  
        
        
        <div class="form-group">
              <label class="col-sm-2 control-label" for="enddt">End Date</label>
         <input type="text" class="form-control"  title ="Enter Project end  date .."  id="enddt" name="enddt" value="<fmt:formatDate pattern="MM/dd/yyyy"  />
         </div>  
             <br /> <br /> 
        
         <div class="form-group">
              <label class="col-sm-2 control-label" for="description">Description</label>
             <textarea name="description" id="description"  class="form-control"  rows="4" cols="95"></textarea> 
          <br /><br />
          
          
  
             <button type="submit"  class="btn app_button">SAVE &amp; CONTINUE</button>         
                 <b> <button type="reset" class="btn btn-default">Reset</button></b>
    </form>


</body>
</html>

