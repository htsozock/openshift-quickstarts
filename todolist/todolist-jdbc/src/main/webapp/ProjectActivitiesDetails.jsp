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
  
 <link href="//assets.cms.gov/Resources/libs/jquery-ui/1.10.3/css/jquery-ui.css" rel="stylesheet">
<link href="//assets.cms.gov/resources/libs/bootstrap/2.2.2/css/bootstrap.css" rel="stylesheet">
<link href="//assets.cms.gov/resources/libs/bootstrap/2.2.2/css/bootstrap-responsive.css" rel="stylesheet">
<link href="//assets.cms.gov/resources/libs/glyphicons/3.0/css/glyphicon.css" rel="stylesheet">
<link href="//assets.cms.gov/resources/libs/font-awesome/3.0.2/css/symbol.css" rel="stylesheet">

<link href="/resources/2.0/framework/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="//assets.cms.gov/resources/global/css/buttons-2.0.css" />
<link rel="stylesheet" href="//assets.cms.gov/resources/libs/datepicker/v6/css/datepicker.css" />
<link rel="stylesheet" href="//assets.cms.gov/resources/libs/datatables/1.9.1/css/datatables.css" />
<script src="//assets.cms.gov/resources/libs/datatables/1.9.1/js/datatableinitiate.js" ></script>
<link href="//assets.cms.gov/resources/libs/formvalidator/2.0/css/formvalidator.css" />
<script src="//assets.cms.gov/resources/libs/formvalidator/2.0/js/formvalidatorconfig.js"></script>	
<script src="//assets.cms.gov/resources/libs/formvalidator/2.0/js/formvalidator.js"></script>
<link href="//assets.cms.gov/resources/libs/sharewidget/2.0/css/sharewidget-2.0.css" rel="stylesheet" />
 

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->
    	
<!-- IE9 gradient support -->
  <!--[if gte IE 9]>
    <style type="text/css">
      .gradient {
        filter: none;
      }
    </style>
  <![endif]-->
<!--    <div id="container" style="text-align: left;">
  <img src="usaid_logo.png" alt="USAID Logo" style="width:440px;height:220px;">
    &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; <h3 Development Information Solution (DIS) </h3>
   </div> -->
 </head>
<body>
<div id="container" style="text-align: left;">
 <img src="usaid_logo.png" alt="USAID Logo" style="width:440px;height:220px;">
 &nbsp;&nbsp; &nbsp;&nbsp; <h2>  Development Information Solution (DIS) </h2>  
  
   </div>
    <div class="container" align ="center"> 
      <hr size="35">
 
<table style="width:95%"  border=2 align="center" frame="box" id="Projects_activitiesDetails"  >
   <div class="container" align ="left"> 
     <!-- <h4>  USAID - Development Information Solution (DIS) </h4> -->
     <b> <h3>Project Activities Details </h3></b>
     </div>
       <thead>
            <tr>
                <th scope="col"> Project ID </th>
                <th scope="col"> Activity ID </th>
                 <th scope="col"> Project Name </th>
                 <th scope="col"> Activity Name </th>
                <th scope="col"> Country </th>
                 <th scope="col"> Description </th> 
                 <th scope="col"> Award Number </th>
                <th scope="col"> Total Obligation Amount </th> 
               </tr>
      </thead> 
     
         <tbody>
            <c:forEach items="${list1}" var="entry">
                <tr>
                    <td><c:out value="${entry.id}" /></td>
                    <td><c:out value="${entry.id_activity}" /></td>
                    <td><c:out value="${entry.name}" /></td>
                    <td><c:out value="${entry.activity_name}" /></td>
                    <td><c:out value="${entry.country}" /></td>
                       <td><c:out value="${entry.description}" /></td>
                     <td><c:out value="${entry.award_number}" /></td>
                     <td><c:out value="${entry.obligation_amount}" /></td>
                               
                </tr>
            </c:forEach>
        </tbody>
    </table>
  
    <h5 align="left"> <a href="MainServlet?action=listProject" >[+] HOME</a> </h5> 

    
    
   </div>   
 <script src="//assets.cms.gov/resources/libs/jquery/1.8.2/js/jquery-1.8.2.js" type="text/javascript" />
<script src="//assets.cms.gov/resources/libs/jquery-ui/1.9.1/js/jquery-ui-1.9.1.js" type="text/javascript" />
<script src="//assets.cms.gov/resources/libs/bootstrap/2.1.1/js/bootstrap.js" type="text/javascript" />
<script src="//assets.cms.gov/resources/libs/hcmode-detection/js/hcmode-detection.js" type="text/javascript" />
   
  
</body>
</html>



