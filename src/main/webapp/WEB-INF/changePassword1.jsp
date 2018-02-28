
<%@page isELIgnored = "false" %>
<%@page import="foodwaste.service.ServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="foodwaste.domain.WsvalueResult"%>
<%@page import="foodwaste.domain.Wastestream"%>
<%@page import="foodwaste.domain.UserPostClass"%>
<%@page import="foodwaste.dao.DAOImpl"%>
<%@page import="foodwaste.domain.User"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="foodwaste.service.ServiceImpl"%>
<html>
           <style>
    @font-face {
    font-family: regular;
    src: url(Raleway-Regular.ttf);
}
    @font-face {
    font-family: medium;
    src: url(Raleway-Medium.ttf);
}
    @font-face {
    font-family: bold;
    src: url(Raleway-ExtraBold.ttf);
}

        body::before {
    background: rgba(0,0,0, .5);
    background-size: cover; 
    content: "";
    display: block;
    left: 0; right: 0; top: 0; bottom: 0;
    transition: background .5s;
    position:fixed;
    padding:0;
    margin:0;

    top:0;
    left:0;

    width: 100%;
    height: 100%;
}


.login h4{
font-family: regular;
color: whitesmoke;

}
.login-r h5{
    color: whitesmoke;
    font-family: regular;
}
.login-r{
    margin-top: 1%;
    display: flex;
    justify-content: center;
    align-items: center;
}
.login-r h4
{   
    color: whitesmoke;
    font-family: medium;
}
.style-1 h4{
   color: whitesmoke;
    font-family: regular;

}
.style-1 h4:hover{
    color: #5ea03f;
}

.footerRefresh {
    
    float: left;
    width: 100%;
    color: #eeeae9;
    font-family: regular;
    font-size: 15px;
    font-weight: 400;
    line-height: 17px;
    padding-left: 33px;
    bottom:0;
    left:0; 
}
    </style>
    <head>
   <link rel="icon" type="image/png" href="REFRESH-logo-SM1.png"> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>FoodWaste Explorer</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body style="background-image: url(refresh_photo_web.jpg); background-size: cover; width: 100%; ">
    <div class="container" style="text-align:center; margin-top: 1%; margin-bottom: 1%">
        <a href="login.htm"> <img class="img-responsive" src="logo_Refresh_RGB.png" style="  background:none;  width: 30%;" > </a>
    </div>
  
       

    
    
     
        <div class="container register">
          

<table class="table container" style="  vertical-align: middle; position: relative;
  width: 100%;
  margin: 0 auto;
  background: rgba(130,130,130,.3);
  padding: 20px 22px;
  border: 1px solid;
  border-top-color: rgba(255,255,255,.4);
  border-left-color: rgba(255,255,255,.4);
  border-bottom-color: rgba(255,255,255,.4);
  border-right-color: rgba(255,255,255,.4);">
                       
<%
    
    
     DAOImpl dao=new DAOImpl();

     String email=(String)request.getAttribute("email");
     User u=new User();
     u.setEmail(email);

     String message=dao.ChangePassword(u);
   if(message.equals("fail")){
%>
<tr>
    <td style="text-align:center">
 <h4 style="color:#ffffff">Something went wrong.</h4>
 
    </td>

</tr>
<tr>
    <td style="text-align:center">
     <a href="#" onclick="history.go(-1)">Try again</a>
    </td>
</tr>


  
 <%}

if(message.equals("edited"))
{
 %>
 <tr>
     <td style="text-align:center; font-family: regular; color:whitesmoke; font-size:1.5vw;">
Please check your email and log in with the provided password.
     </td>
</tr>
<tr>
   <td style="text-align:center; color: #95c11f; font-size: 2vw; font-family: medium;">
     <a href="login.htm" style="text-align:center; color: #95c11f; font-size: 2vw; font-family: medium;"> Log in</a> 
    </td>
</tr>
    <%}%>
</table>

    </div>
    
 
    
    
    
      <footer class="navbar navbar-default navbar-static-bottom" style="  vertical-align: middle; 
  width: 100%;
  margin: 0 auto;
  background: rgba(130,130,130,.3);
  border: 1px solid;
  padding-bottom: 10px; 
  border-top-color: rgba(255,255,255,.4);
  border-left-color: rgba(255,255,255,.4);
  border-bottom-color: rgba(60,60,60,.4);
  border-right-color: rgba(60,60,60,.4);
  position: fixed;
  bottom:0;
  left:0;">
           
     
        
            <div class="style-1">
     
<ul class="nav">
    

  <li class="nav-item">
      <a class="nav-link" href="about1.htm"><h4 style="font-size: 1.3vw;" >About</h4></a>
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
</body>

</html>
