

<%@page import="foodwaste.domain.EditUser"%>
<%@page import="foodwaste.dao.DAOImpl"%>
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
<body style="background-image: url(refresh_photo_web.jpg); ">
    <div class="container" style="text-align:center; margin-top: 1%; margin-bottom: 1%">
        <a href="login.htm"><img class="img-responsive" src="logo_Refresh_RGB.png" style="  background:none;  width: 15vw;" > </a>
    </div>
  
       <%
           HttpSession httpSession = request.getSession();
           ServiceImpl service= new ServiceImpl();
           String email = (String) httpSession.getAttribute("email");
           httpSession.setAttribute("email", email);
           User user1=service.user(email);
           httpSession.setAttribute("user", user1);
           String name=(String)request.getAttribute("name");
           String surname=(String)request.getAttribute("surname");
           String password=(String)request.getAttribute("password");
           String confPassword=(String)request.getAttribute("confPassword");
           String oldPassword=(String)request.getAttribute("oldPassword");
           EditUser user=new EditUser();
           user.setName(name);
           user.setSurname(surname);
           user.setPassword(password);
           user.setEmail(email);
           user.setOldPassword(oldPassword);
           user.setUserid(user1.getUserid());
           
           DAOImpl dao= new DAOImpl();
           String message=dao.editUser(user);
         
         if(message.equals("edited")){
           


       %>

    
    
            <div class="container register">
<table class="table container tabletransperent">
<tr>
    <td style="text-align:center; font-family: regular; color:whitesmoke; font-size:1.5vw;">
 User information saved!
 
    </td>

</tr>
<tr>
    <td style="text-align:center; color: #95c11f; font-family: medium;">
     <a href="login.htm" style="text-align:center; color: #95c11f; font-size: 2vw; font-family: medium;">Log in</a>
    </td>
</tr>


  </table>

    </div>
       <%}
else{%>
      
            <div class="container register">
<table class="table container tabletransperent">
<tr>
   <td style="text-align:center; font-family: regular; color:whitesmoke; font-size:1.5vw;">
Something went wrong!
 
    </td>

</tr>
<tr>
    <td style="text-align:center; color: #95c11f; font-size: 3vw; font-family: medium;">
     <a href="#" onclick="history.go(-1)" style="text-align:center; color: #95c11f; font-size: 2vw; font-family: medium;">Go back</a>
    </td>
</tr>


  </table>

    </div>  
 <%}%>
      
       <footer class="footer navbar navbar-default navbar-static-bottom" style="position: absolute;">
           
     
        
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
