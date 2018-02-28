

<%@page import="foodwaste.service.ServiceImpl"%>
<%@page import="foodwaste.domain.User"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>

<head>
    <link rel="icon" type="image/png" href="REFRESH-logo-SM1.png"> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>FoodWaste Explorer</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" type="text/css" href="style2.css">
</head>
<body style="background-image: url(refresh_photo_web.jpg); ">
    <div class="container" style="text-align:center; margin-top: 1%; margin-bottom: 1%">
        <a href="foodwasteHome.htm"><img class="img-responsive" src="logo_Refresh_RGB.png" style="  background:none;  width: 15vw;" > </a>
    </div>
  
       <%
           HttpSession httpSession = request.getSession();
           ServiceImpl service= new ServiceImpl();
           String email = (String) httpSession.getAttribute("email");
           httpSession.setAttribute("email", email);
           User user=service.user(email);
           httpSession.setAttribute("user", user);
           
       %>

    
    
     
        <div class="container register">
           <form:form method="POST" commandName="userEdited" action="userEdited"> 

<table class="table container tabletransperent">
        <div style=" margin-top:2%; width: 100%; text-align:center">
        <h3 style="color:#ffffff; font-size: 2vw; font-family:medium;">User Information</h3>
        </div>
    <tr colspan='2'>
     <div style="text-align:center; font-family: bold; font-size: 1.5vw; color: red; "> ${ErrorMessage} </div>
    <tr>
    <tr class="tr">	
        <td><label path="name"><h4>Name</h4></label></td>
          <td><form:input  path="name"  value="<%=user.getName()%>"/></td>
    </tr>
    
    <tr class="tr">
         <td><label path="surname"><h4>Surname</h4></label></td>
         <td><form:input  path="surname" value="<%=user.getSurname()%>"/></td>
    </tr>
    <tr class="tr">
         <td><label path="oldPassword"><h4>Old password</h4></label></td>
         <td><form:input autocomplete="new-password" type="password"  path="oldPassword" /></td>
    </tr>
    <tr class="tr">
         <td><label path="password"><h4>New password</h4></label></td>
         <td><form:input autocomplete="new-password" type="password"  path="password" /></td>
    </tr>
    <tr class="tr">
        <td><label path="confPassword"><h4>Confirm password</h4></label></td>
         <td><form:input autocomplete="new-password" type="password"  path="confPassword" /></td>
    </tr>
      
 <tr>
         <td colspan="2" style="text-align: center;">
                       
           <input type="submit" class="btn btn-success btn-lg" style="text-align: center; background-color: #95c11f; height: 4vw; font-family:regular; border: none; font-size:2vw;" value="Save">
           
         </td>
      </tr>
</table>
</form:form>
    </div>
    
 </body>
      
       <footer class="footer navbar navbar-default navbar-static-bottom">
           
     
        
            <div class="style-1">
     
<ul class="nav">
    

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
  <li style="margin-top: 0.3%; margin-left:1%; margin-right:1%;">
     
     <a target="_blank" href="https://www.facebook.com/eurefresh"> <span class="fa fa-facebook" style=" font-size: 2vw; color: #95c11f;"></span> </a> 
 
  </li>
  <li style="margin-top: 0.3%; margin-right:1%;">
      <a target="_blank" href="https://twitter.com/EUrefresh"> <span class="fa fa-twitter" style="font-size: 2vw; color: #95c11f;"></span> </a>  
  </li>
  <li style="margin-top: 0.3%; margin-right:1%;">
      <a target="_blank" href="https://www.youtube.com/channel/UCxKOF-okk7H5giTzYBsdw3A"> <span class="fa fa-youtube-play" style="font-size: 2vw; color: #95c11f; "></span> </a>
  </li>
</ul>
</div>       

    <div class="row footerRefresh" >

                                <img id="image1" src="eu.jpg" class="img-responsive" style="width: 50px; height: 25px; margin-top:0.5%; position: relative;" >  
                                <span style="padding-left: 10px; margin-top:1%; font-size: 1vw; font-family:regular;">REFRESH is funded by the Horizon 2020 Framework Programme of the European Union under Grant Agreement no. 641933. </span>
                              
        </div>
</footer>


    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>



</html>
