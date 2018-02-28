<%-- 
    Document   : login
    Created on : May 8, 2017, 3:42:24 PM
    Author     : Tome
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="foodwaste.service.ServiceImpl"%>
<html>

<head>
   <link rel="icon" type="image/png" href="REFRESH-logo-SM1.png"> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>FoodWaste Explorer Log in</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
   <link rel="stylesheet" type="text/css" href="style1.css">
<SCRIPT type="text/javascript">
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
</SCRIPT>
</head>


<body style="background-image: url(refresh_photo_web.jpg); background-size: cover;" >
      
    
    
    
    
    
    
    
    
       <% 
           ServiceImpl service= new ServiceImpl();
           String email = (String)request.getAttribute("email");
         
           HttpSession httpSession = request.getSession();
            httpSession.setAttribute("email", email);
        %>
    
    
    
    
    
    
     
    <div class="container" style="text-align:center; margin-bottom: 1%">
    <img class="img-responsive" src="logo_Refresh_RGB.png" style="  background:none;  width: 30%;" > 
 </div>
    <div class="container-fluid" style='padding-top: 3vw; padding-bottom: 2vw;'>
        

<table class="table tabletransperent container">
    <tr>	
        <td width="50%">
<!--<h2 style="text-align:center">User Information</h2>-->
<form:form method="POST" commandName="user" action="loginNEW" autocomplete="off">
   <table class="login table" style="vertical-align: middle; position: relative;
  width: 100%;
  margin: 0 auto;
  background: rgba(130,130,130,.3);
  padding: 20px 22px;
  border: 1px solid;
  border-top-color: rgba(255,255,255,.4);
  border-left-color: rgba(255,255,255,.4);
  border-bottom-color: rgba(255,255,255,.4);
  border-right-color: rgba(255,255,255,.4);
  text-align:center; ">
      <tr>
         
         <td><form:input  autocomplete="new-password" path="email" style="font-family: regular; width: 22vw; font-size:1.5vw; " placeholder="Email address"/></td>
      </tr>
      
      <tr>
         <td><form:password autocomplete="new-password" path="password"  style="font-family: regular; width: 22vw; font-size:1.5vw;" placeholder="Password"/></td>
      </tr>  
      
      <tr>
          
      </tr>
      
      <tr>
          <div class="errormessage"> ${ErrorMessage} </div>
      </tr>
      
    </table>
      
      
      <table class="login align-middle" width="100%">
          
 <tr>
         <td colspan="2">
                       
           <input type="submit" class="btn btn-success succ" value="Log in">
           
         </td>
      </tr>
      
      </table>
     </form:form> 
  <div class=" row login-r" >
      <a class="login-ra" href="activation.htm">Activate account</a>
  </div>
  <div class=" row login-r">
      <a class="login-ra" href="changePassword.htm">Forgot your password?</a>
  </div>   
  

         </td>
        <td style="text-align: left; padding-top:1vw;"  width="50%">
            
            <h3 style="color:white; font-family: bold; font-size:1.5vw;">Welcome to FoodWasteExplorer</h3>
            <h5 style="color:#95c11f; font-family: regular; font-size:1.5vw;">A new tool for exploring scientific data about food waste,</h5>
            <p style="color:white; font-family: regular; font-size: 1vw; padding-bottom: 2vw;">developed by the Jožef Stefan Institute, the Quadram Institute, and EuroFIR AISBL.</p>
            <a class="btn btn-success" style="background-color: #174c87; font-family:regular; font-size:1.5vw; border: none;"  href="registration.htm" value="Register now">Register now</a>


        </td>
     
        </tr>
   
    
</table>

    </div>
</body>
    <footer class="footer navbar navbar-default navbar-static-bottom">
           
     
        
            <div class="style-1">
     
<ul class="nav">
    

  <li class="nav-item">
      <a class="nav-link" href="about1.htm"><h4>About</h4></a>
  </li>
  <li class="nav-item">
      <a class="nav-link" href=""><h4>Contact us</h4></a>
  </li>
  <li class="nav-item">
      <a class="nav-link" href=""><h4>Resources</h4></a>
  </li>
   <li class="nav-item">
      <a class="nav-link" href=""><h4>Privacy policy</h4></a>
  </li>
  <li class="nav-item">
      <a class="nav-link" href=""><h4>Terms & Conditions</h4></a>
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



