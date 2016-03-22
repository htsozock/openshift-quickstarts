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
   <big><p><a href="MainServletActivities?action=listProjectActivities" >HOME</a></p></big>  
    <hr size="15">
 </div>
 
 <div id="container" style="text-align: center;">
 
        
    <div id="q28" class="q full_width">
<a class="item_anchor" name="ItemAnchor2"></a>
<div class="segment_header" style="background:#0000FF;width:60%;text-align:left;"><h1 style="font-size:30px;padding:10px 1em 10px ;">Add / Edit Project Activity</h1></div>
</div></div>
<div id="container" style="text-align: left;">
    <hr size="35">           
   <form method="POST" action='MainServletActivities' name="frmAddProject_activities">
    
       Activity ID     &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;  &nbsp;&nbsp; &nbsp;  <input type="text" readonly="readonly" name="id_activity"  size="10"  disabled  value="<c:out value="${entry.id_activity}" />" 

/> <br /> <br> <br>
 
       Project ID     &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;  &nbsp;&nbsp; &nbsp;  <input type="text"  name="id"  size="10"   value="<c:out value="${entry.id}" />" 

/> <br /> 
             <br />
        Activity  Name &nbsp;&nbsp; &nbsp;&nbsp;  <input       type="text" name="activity_name" size="40"       value="<c:out value="${entry.activity_name}" />" /> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
      Project  Name &nbsp;&nbsp; &nbsp;&nbsp;  <input       type="text" name="name" size="40"       value="<c:out value="${entry.name}" />" /> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;           
        <br>
         &nbsp;&nbsp; Country   &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <input        type="text" name="country" size="40"      value="<c:out value="${entry.country}" />" /> <br /> 
            <br />
       Award Amount  <label>$</label> &nbsp; <input   type="text" name="award_amount" size="50"  value="<c:out value="${entry.award_amount}" />" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 

&nbsp;&nbsp;
         Obligation Amount  <label>$</label> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<input   type="text" name="obligation_amount" size="40"  value="<c:out value="${entry.obligation_amount}" />" /> <br />    
            <br />
                  --%>
                    <br /> <br /> 
         Description &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;     <textarea name="description" id="description"  rows="4" cols="95"></textarea> 
   
     
 <br /> <br /> 
   
          
          <hr size="35">
       <div id="container" style="text-align: left;">
 
          <big><button type="submit"  class="btn app_button">SAVE &amp; CONTINUE</button>  </big>             </div>
               
    </form>
    
  
     </div>
    
</body>
</html>

