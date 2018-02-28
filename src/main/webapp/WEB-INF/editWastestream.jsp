
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@page import="foodwaste.domain.UserRole"%>
<%@page import="foodwaste.domain.WastestreamFood"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="foodwaste.service.ServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="foodwaste.domain.WsvalueResult"%>
<%@page import="foodwaste.domain.Wastestream"%>
<%@page import="foodwaste.domain.WastreamPOSTClass"%>
<%@page import="foodwaste.domain.Food"%>
<%@page import="foodwaste.domain.User"%>

<!DOCTYPE html>
<html>
    <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>FoodWasteExplorer</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
   <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
   <link rel="stylesheet" type="text/css" href="style.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
    <head>
        <link rel="icon" type="image/png" href="REFRESH-logo-SM1.png"> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FoodWaste Explorer</title>
    </head>
   <body>
    
            <%String email=(String)request.getSession().getAttribute("email");%>
   <header class="style-headder flex-container" width="100%" style="background-image: url('refresh_header.jpg'); height: 5.1vw; align-content: center; justify-content: center;">
     <script> 
document.addEventListener("click", function(evt) {  
    var div = document.getElementById('dropdown-content'),
        targetElement = evt.target,
        dd=document.getElementById('dropdown');
   
        do {
        if (targetElement === dd) {
             if (div.style.display !== "none") {
        div.style.display = "none";
    }
    else {
        div.style.display = "block";
    }
            return;
        }
        else
        {
            div.style.display = "none";
        }
        // Go up the DOM
        targetElement = targetElement.parentNode;
    } while (targetElement);

    
        
        
        

});

         </script>
    
        <div style="float:left;">
           
            <form:form method="POST" commandName="user" action="foodwasteHomeeditWastestream"> 
            <form:input  path="email" class="hide" value="<%=email%>"/>
            <form:button class="btn-transparent" type="submit"> <img src="logo_Refresh_RGB.png" style="background: none; height: 5vw; " class="img-circle img-responsive"> </form:button>
            </form:form>
        </div>
    <div class="container-row" style="float:right;">
        <ul class="nav">
  <li class="tab">
      <a   href="about.htm"><span class="tab-link">About</span></a>
  </li>

   <li class="tab">
      <a   href=""><span class="tab-link">Contact</span></a>
  </li>

  <li id="dropdown" class="dropdown" >
       <a  href="javascript:void(0)"  class="dropbtn"> <span class="fa fa-user" style="font-size: 1.9vw; color: white; "></span>  </a>
       <ul class="nav dropdown-content" id="dropdown-content">
           
        <li>
            <form:form method="POST" commandName="editUser" action="editUsereditWastestream" >
                <input type="submit" style="border: none;
                   text-align: center;
                   background-color: inherit;
    display: block;
    color: #95c11f;
    font-family: regular;
    text-align: left;
    font-size: 1.2vw; height: 3vw; width: 17vw; padding-bottom: 0.5vw; padding-top: 0.7vw; padding-left: 1vw;" value="Edit user"/> 
            
            </form:form>
        </li>   
        <li><a href="login.html" style="
                   text-align: center;
    display: block;
    color: #95c11f;
    font-family: regular;
    text-align: left;
    border: none;  font-size: 1.2vw; height: 3vw; padding-bottom: 0.5vw; padding-top: 0.7vw; padding-left: 1vw;">Log out</a>
        </li>
        
      </ul>
  </li>
        </ul>
     </div>      

     </header>    
  
                        
<%
     ServiceImpl service= new ServiceImpl();
     WastreamPOSTClass wstream=new WastreamPOSTClass();
     String wastestreamname=(String)request.getAttribute("wastestream");
    //Integer wsid=service.getWastestreamId(wastestreamname);
     Integer wsid=(Integer)request.getAttribute("wsid");
     Double edible=(Double)request.getAttribute("edible");
     Double gcf=(Double)request.getAttribute("gcf");
     Double ncf=(Double)request.getAttribute("ncf");
     Double specgravity=(Double)request.getAttribute("specgravity");
     
     wstream.setWsid(wsid);
     wstream.setEdible(edible);
     wstream.setGcf(gcf);
     wstream.setNcf(ncf);
     wstream.setSpecgravity(specgravity);
     String message=service.editWastestream(wstream);
if(message.equals("edited"))
     {
%>

<div class="container">
    <h3 style="color:#174c87;">Waste stream edited.</h3>
</div> 
<div class="container">
    <h2>   <a href="#" onclick="location.href = document.referrer; return false;">Go Back </a> <h2>
</div>
<%        }
else
{
%>
<div class="container">
    <h3 style="color:red;">Something went wrong. Try again.</h3>
</div> 
<div class="container">
    <h2> <a href="#" onclick="location.href = document.referrer; return false;">Go Back</a> <h2>
</div>
<%
    }
%>
       
        <footer class="footer navbar navbar-default navbar-static-bottom " style="position:absolute;">
           
    <div class="style-1">
     
<ul class="nav" style="align-items: center;">
    

  <li class="nav-item">
      <a class="nav-link" href="about.htm"><h4 style="font-size: 1.3vw;" >About</h4></a>
  </li>
  <li class="nav-item">
      <a class="nav-link" href=""><h4 style="font-size: 1.3vw;">Contact us</h4></a>
  </li>
  <li class="nav-item">
      <a class="nav-link" href=""><h4 style="font-size: 1.3vw;">Resources</h4></a>
  </li>
   <li class="nav-item">
      <a class="nav-link" href=""><h4 style="font-size: 1.3vw;">Privacy policy</h4></a>
  </li>
  <li class="nav-item">
      <a class="nav-link" href=""><h4 style="font-size: 1.3vw;">Terms & Conditions</h4></a>
  </li>
  <li style="margin-left:1%; margin-right:1%;">
     
      <a target="_blank" href="https://www.facebook.com/eurefresh"> <span class="fa fa-facebook" style=" font-size: 2vw; color: #95c11f;"></span>  </a>
 
  </li>
  <li style="margin-right:1%;">
      <a target="_blank" href="https://twitter.com/EUrefresh"> <span class="fa fa-twitter" style="font-size: 2vw; color: #95c11f;"></span> </a>
  </li>
  <li style="margin-right:1%;">
      <a target="_blank" href="https://www.youtube.com/channel/UCxKOF-okk7H5giTzYBsdw3A"> <span class="fa fa-youtube-play" style="font-size: 2vw; color: #95c11f; "></span> </a> 
  </li>
</ul>
</div>       

   <div class="row footerRefresh" >

                                <img id="image1" src="eu.jpg" class="img-responsive" style="width: 50px; height: 25px; margin-top:0.5%; position: relative;">  
                                <span style="color: #174c87; padding-left: 10px; margin-top:1%; font-size: 1vw; font-family:regular;">REFRESH is funded by the Horizon 2020 Framework Programme of the European Union under Grant Agreement no. 641933. </span>
    </div> 
            
            
</footer>  
 
 
 
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
<script src="script.js"></script>
</body>
</html>
