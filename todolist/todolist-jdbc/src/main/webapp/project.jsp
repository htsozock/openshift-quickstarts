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
  <link rel="stylesheet" href="//assets.cms.gov/resources/libs/datepicker/v6/css/datepicker.css" />
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> 
  
<!--  <link href="//assets.cms.gov/Resources/libs/jquery-ui/1.10.3/css/jquery-ui.css" rel="stylesheet"> -->
<!-- <link href="//assets.cms.gov/resources/libs/bootstrap/2.2.2/css/bootstrap.css" rel="stylesheet"> -->
<!-- <link href="//assets.cms.gov/resources/libs/bootstrap/2.2.2/css/bootstrap-responsive.css" rel="stylesheet"> -->
<!-- <link href="//assets.cms.gov/resources/libs/glyphicons/3.0/css/glyphicon.css" rel="stylesheet"> -->
<!-- <link href="//assets.cms.gov/resources/libs/font-awesome/3.0.2/css/symbol.css" rel="stylesheet"> -->

<!-- <link href="/resources/2.0/framework/css/style.css" rel="stylesheet"> -->
<!-- <link rel="stylesheet" href="//assets.cms.gov/resources/global/css/buttons-2.0.css" /> -->
<!-- <link rel="stylesheet" href="//assets.cms.gov/resources/libs/datepicker/v6/css/datepicker.css" /> -->
<!-- <link rel="stylesheet" href="//assets.cms.gov/resources/libs/datatables/1.9.1/css/datatables.css" /> -->
<!-- <script src="//assets.cms.gov/resources/libs/datatables/1.9.1/js/datatableinitiate.js" ></script> -->
<!-- <link href="//assets.cms.gov/resources/libs/formvalidator/2.0/css/formvalidator.css" /> -->
<!-- <script src="//assets.cms.gov/resources/libs/formvalidator/2.0/js/formvalidatorconfig.js"></script>	 -->
<!-- <script src="//assets.cms.gov/resources/libs/formvalidator/2.0/js/formvalidator.js"></script> -->
<!-- <link href="//assets.cms.gov/resources/libs/sharewidget/2.0/css/sharewidget-2.0.css" rel="stylesheet" />  -->
  <title>  USAID - Development Information Solution (DIS) </title>
 <script>
 
        $(function() {
            $('input[name=startdt]').datepicker();
            $('input[name=enddt]').datepicker();
        });
    </script>
</head>   
    
<body>


<div id="container" style="text-align: left;">
 <img src="usaid_logo.png" alt="USAID Logo" style="width:440px;height:220px;">
 &nbsp;&nbsp; &nbsp;&nbsp; <h2>  Development Information Solution (DIS) </h2>  
   <big><p><a href="MainServlet?action=listProject" >HOME</a></p></big>  
    <hr size="15">
 </div>
 
 <div id="container" style="text-align: center;">
 
     
       
    <div id="q28" class="q full_width">
<a class="item_anchor" name="ItemAnchor2"></a>
<div class="segment_header" style="background:#0000FF;width:60%;text-align:left;"><h1 style="font-size:30px;padding:10px 1em 10px ;">Add / Edit Project</h1></div>
</div></div>
<div id="container" style="text-align: left;">
    <hr size="35">           
   <form method="POST" action='MainServlet' name="frmAddProject">
    
        Project ID     &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;  &nbsp;&nbsp; &nbsp;  <input type="text" readonly="readonly" name="id"  size="10"  disabled  value="<c:out value="${entry.id}" />" 

/> <br /> 
             <br />
         Project  Name &nbsp;&nbsp; &nbsp;&nbsp;  <input       type="text" name="name" size="40"  title="Enter the project name..."      value="<c:out value="${entry.name}" 

/>" /> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
                
         &nbsp;&nbsp; Organization   &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <input        type="text" name="organization" size="40"      value="<c:out 

value="${entry.organization}" />" /> <br /> 
            <br />
         Project Manager &nbsp; <input   type="text" name="manager" size="50"  value="<c:out value="${entry.manager}" />" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 

&nbsp;&nbsp;
         Status  &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<input   type="text" name="status" size="40"  value="<c:out value="${entry.status}" />" /> <br />    
            <br />
                 
         
         Start Date    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;  &nbsp;&nbsp; &nbsp;  <input   type="text" name="startdt" size="50"  value="<fmt:formatDate pattern="MM/dd/yyyy" 

value="${entry.startdt}" />" /> &nbsp;&nbsp;&nbsp;
         End  Date    &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;  <input    type="text" name="enddt" size="40"  value="<fmt:formatDate pattern="MM/dd/yyyy" value="${entry.enddt}" />" /> <br 

/> 
           <br /> <br /> 
         Description &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;     <textarea name="description" id="description"  rows="4" cols="95"></textarea> 
   
      <div class="clear"></div>
 <br /> <br /> 
<div id="q29" class="q">
<a class="item_anchor" name="ItemAnchor12"></a>
<label class="question top_question" for="RESULT_FileUpload-12">Upload Documents</label>
<div class=""><input type="file" name="RESULT_FileUpload-12" size="40" class="file_upload" id="RESULT_FileUpload-12" /><br/><span class="file_upload_info"></span>&nbsp;<input type="submit" name="Upload-12" value="Upload" class="file_upload_button" /> <input type="submit" name="Delete-12" value="Delete" class="file_upload_button" /></div>
</div>

<div class="clear"></div>
   
          
          <hr size="35">
       <div id="container" style="text-align: left;">
 
          <big><button type="submit"  class="btn app_button">SAVE &amp; CONTINUE</button>  </big>         
     
   <big><p><a href="MainServlet?action=ProjectActivitiesDetails.jsp" >Project Activities Details</a></p></big>  
    <hr size="35">
 </div>    
          
          
              </div>
               
    </form>
    
  
     </div>
    
</body>
</html>

