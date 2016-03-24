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
   <big><p><a href="MainServletIndicators?action=listProjectIndicators" >HOME</a></p></big>  
    <hr size="45">
 </div>

 <div id="container" style="text-align: center;">
 
        
    <div id="q28" class="q full_width">
<a class="item_anchor" name="ItemAnchor2"></a>
<div class="segment_header" style="background:#0000FF;width:60%;text-align:left;"><h1 style="font-size:30px;padding:10px 1em 10px ;">Add / Edit Project Indicator</h1></div>
</div></div>
<div id="container" style="text-align: left;">
    <hr size="45">           
   <form method="POST" action='MainServletIndicators' name="frmAddProject_INDICATORS">
    
  Indicator ID     &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;  &nbsp;&nbsp; &nbsp;  <input type="text" readonly="readonly" name="id_indicator"  size="10"  disabled  value="<c:out value="${entry.id_indicator}" />" /> 
            <br />
            
  Activity ID     &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;  &nbsp;&nbsp; &nbsp;  <input type="text"  name="id_activity"  size="10"    value="<c:out value="${entry.id_activity}" />" /> 
            <br />          
  Activity  Name  &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;  <input       type="text" name="activity_name" size="40"       value="<c:out value="${entry.activity_name}" />" /> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
       <br />
  Project  Name &nbsp; &nbsp;&nbsp;   <input       type="text" name="name" size="40"       value="<c:out value="${entry.name}" />" /> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;           
     
  Indicator Name   &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <input        type="text" name="country" size="40"      value="<c:out value="${entry.indicator_name}" />" /> <br /> 
            <br />
  Indicator Category &nbsp; &nbsp; <input   type="text" name="indicator_category" size="40"  value="<c:out value="${entry.indicator_category}" />" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 

  Value  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<input   type="text" name="indicator_type" size="40"  value="<c:out value="${entry.value}" />" /> <br />    
            <br />
       
 Period    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;  &nbsp;&nbsp; &nbsp;  <input   type="text" name="period" size="30"  value="<fmt:formatDate pattern="MMM-YYYY" 

value="${entry.period}" />" /> &nbsp;&nbsp;&nbsp;
   
         <br /> <br /> 
      Data Type  &nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;     <input type="text" name="data_type" size="40"  value="<c:out value="${entry.data_type}" />" /> <br />    
   
 <br /> <br /> 
  
          
          <hr size="45">
       <div id="container" style="text-align: left;">
 
          <big><button type="submit"  class="btn app_button">SAVE &amp; CONTINUE</button>  </big>             </div>
               
    </form>
    
  
     </div>
     
   
</body>
</html>

