
<%@page import="foodwaste.domain.ConfirmPassword"%>
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
        <a href="login.htm"><img class="img-responsive" src="logo_Refresh_RGB.png" style="  background:none;  width: 15vw;" > </a>
    </div>
           <script type="text/javascript">

document.ready(function(){    


    if ((e.which || e.keyCode) === 116 || ((e.which || e.keyCode) === 82)) {
       
        e.preventDefault();
   
};

if(window.history && history.pushState){ // check for history api support
	window.addEventListener('load', function(){
		// create history states
		history.pushState(-1, null); // back state
		history.pushState(0, null); // main state
		history.pushState(1, null); // forward state
		history.go(-1); // start in main state
				
		this.addEventListener('popstate', function(event, state){
			// check history state and fire custom events
			if(state === event.state){
	
				event = document.createEvent('Event');
				event.initEvent(state > 0 ? 'next' : 'previous', true, true);
				this.dispatchEvent(event);
				
				// reset state
				history.go(-state);
			}
		}, false);
	}, false);
}
        </script>

    
    
     
        
          


                       
<%
    
     UserPostClass u=new UserPostClass();
     DAOImpl dao=new DAOImpl();
     ConfirmPassword cf=new ConfirmPassword();
     String name=(String)request.getAttribute("name");
     String surname=(String)request.getAttribute("surname");
     String email=(String)request.getAttribute("email");
     String password=(String)request.getAttribute("password");
     String confPassword=(String)request.getAttribute("confPassword");
     String insterestarea=(String)request.getAttribute("interestarea");
     String insname=(String)request.getAttribute("insname");
     String insttype=(String)request.getAttribute("insttype");
     String countrycode=(String)request.getAttribute("countrycode");
     
     u.setName(name);
     u.setSurname(surname);
     u.setEmail(email);
     u.setPassword(password);
     u.setInsname(insname);
     u.setInsttype(insttype);
     u.setInterestarea(insterestarea);
     u.setCountrycode(countrycode);
   
  
    
   if(name.equals("")||surname.equals("")||email.equals("")||password.equals("")||confPassword.equals("")||insterestarea.equals("")||insname.equals("")||insttype.equals("")||countrycode.equals("")){
       %>
       
       
       <div class="container register">
<table class="table container tabletransperent">
<tr>
    <td style="text-align:center; font-family: regular; color:whitesmoke; font-size:1.5vw;">
 Please fill in all required fields!
 
    </td>

</tr>
<tr>
    <td style="text-align:center; color: #95c11f;  font-family: medium;">
     <a href="#" onclick="history.go(-1)" style="text-align:center; color: #95c11f; font-size: 2vw; font-family: medium;">Try again</a>
    </td>
</tr>


  </table>

    </div>
       <%}
else{
            String message=dao.register(u);
   if(message.equals("Invalid username")){
%>

<div class="container register">
<table class="table container tabletransperent" >
<tr >
    <td colspan="2" style="text-align:center; font-family: regular; color:whitesmoke; font-size:1.5vw;">
 The email is already used. Use another email to register. If your previously registered with this email, please activate your account. 
    </td>

</tr>
<tr >
    <td colspan="2" style="text-align:center; color: #95c11f;  font-family: medium;">
     <a href="#" onclick="history.go(-1)" style="text-align:center; color: #95c11f; font-size: 2vw; font-family: medium;">Try again</a>
    </td>
</tr>


  </table>

    </div>
 
 <%}
else{
if(message.equals("Success")){
 %>
  <form:form method="POST" commandName="activateUser" action="activateUser" >
 <div class="container register">
<table class="table container tabletransperent" >
 <tr>
       <td colspan="2" style="text-align:center; font-family: regular; color:whitesmoke; font-size: 1.5vw;">
Please, check your email and enter the received token.
     </td>
</tr>

<tr>	  


          <td colspan="2" style="text-align: center; "><form:input style="width: 15vw;  height: 2vw; font-family: regular;  " path="verificationToken" /></td>
        
</tr>
<tr>
   <td colspan="2" style="text-align: center;">
                       
           <input type="submit" class="btn btn-success" style="text-align: center; background-color: #95c11f; font-family:regular; border: none; font-size:1.5vw;" value="Activate User">
           
   </td>

</tr>
    
  </table>

    </div>
          </form:form>
    <%}
else{%>
<div class="container register">
<table class="table container tabletransperent">
<tr>
    <td style="text-align:center; font-family: regular; color:whitesmoke; font-size: 1.5vw;">
 You are already register, but your account is not activated. Please, check your email for the activation token.
 
    </td>

</tr>
<tr>
    <td style="text-align:center;">
     <a href="login.htm" style="color: #95c11f; font-size: 2vw; font-family: medium;">Log in</a>
    </td>
</tr>


  </table>

    </div>
 <%

}}}%>

    
 
    
    
    
      <footer class="navbar footer navbar-default navbar-static-bottom" style="position:absolute;" >
           
     
        
            <div class="style-1">
     
<ul class="nav">
    

  <li class="nav-item">
      <a class="nav-link" href="about1.htm"><h4 style="font-size: 1.3vw;" >About</h4></a>
  </li>
  <li class="nav-item">
      <a class="nav-link" ><h4 style="font-size: 1.3vw;">Contact us</h4></a>
  </li>
  <li class="nav-item">
      <a class="nav-link"><h4 style="font-size: 1.3vw;">Resources</h4></a>
  </li>
   <li class="nav-item">
      <a class="nav-link" ><h4 style="font-size: 1.3vw;">Privacy policy</h4></a>
  </li>
  <li class="nav-item">
      <a class="nav-link"><h4 style="font-size: 1.3vw;">Terms & Conditions</h4></a>
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
