<%-- 
    Document   : printW
    Created on : Aug 22, 2017, 9:40:39 AM
    Author     : gorda
--%>


<%@page import="foodwaste.domain.UserRole"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="foodwaste.service.ServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="foodwaste.domain.WsvalueResult"%>
<%@page import="foodwaste.domain.Wastestream"%>
<%@page import="foodwaste.domain.Food"%>
<%@page import="foodwaste.domain.User"%>
<%@page import="foodwaste.domain.Role"%>
<!DOCTYPE html>
<html>
    <head>
   <link rel="icon" type="image/png" href="REFRESH-logo-SM1.png"> 
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>FoodWasteExplorer</title>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
   <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"/>
   <link rel="stylesheet" type="text/css" href="style.css">
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>FoodWaste Explorer</title>
    </head>
    <body id="body">
       
       
        <% 
            HttpSession httpSession=request.getSession();
           String email = (String) httpSession.getAttribute("email");
           httpSession.setAttribute("email", email);
           ServiceImpl service= new ServiceImpl();
           User u=service.user(email);
           httpSession.setAttribute("user", u);
           List<UserRole> userroles=service.getUserRole();
           int userrole=3;
           for(UserRole object:userroles)
           {
               if(object.getEmail().equals(email))
               {
                   userrole=object.getRoleid();
                   
               }
           }
           String foodname=(String)request.getAttribute("foodname");
         httpSession.setAttribute("foodname",foodname);
           

        %>
       
       
      
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
    
        <div style="float:left;">
            <form:form method="POST" commandName="user" action="foodwasteHomeabout" >
            <form:input  path="email" class="hide" value="<%=email%>"/>
            <form:button class="btn-transparent" type="submit"> <img src="logo_Refresh_RGB.png" style="background: none; height: 5vw; " class="img-circle img-responsive"> </form:button>
            </form:form>
        </div>
    <div class="container-row" style="float:right;">
        <ul class="nav">
  <li class="tab">
      <a   href="#"><span class="tab-link">About</span></a>
  </li>

   <li class="tab">
      <a   href=""><span class="tab-link">Contact</span></a>
  </li>

  <li id="dropdown" class="dropdown" >
       <a  href="javascript:void(0)"  class="dropbtn"> <span class="fa fa-user" style="font-size: 1.9vw; color: white; "></span>  </a>
       <ul class="nav dropdown-content" id="dropdown-content">
           
        <li>
            <form:form method="POST" commandName="editUser" action="editUserabout" >
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
                    <div style="text-align: center; color: #95c11f; font-family: medium; font-size: 1.5vw; padding-top: 2vw;" >  FoodWasteEXplorer: Exploring the nutrient content of food waste streams <br> </div>

 <div class="container" style="padding-top: 1vw; padding-bottom: 2vw;">
<table class="container" style="  position: relative; border:none; outline: none;
  width: 100%;">
         
            <tr>       <td border="0" colspan="2" style="color:#174c87; font-family: regular; font-size: 1.2vw;" >         FoodWasteEXplorer (Food Waste Stream Compositional Data Maintenance & Explorer Tool) is the first online tool that allows the composition (e.g. nutrients, bioactives, toxicants) of food waste streams to be explored, based on food type and component groups, and the search results exported as ExcelTM for further offline analysis. 

                    FoodWasteEXplorer was developed by REFRESH (641933, Resource efficient food and drink for the entire supply chain), which aims to help reduce food waste across the EU by 30% in 2025 (~ 25-40 million tonnes of food not wasted) and maximise the value of unavoidable food waste and packaging materials.

One-third of food produced for human consumption is lost or wasted globally, which amounts to ca. 1.3 billion tonnes annually. As part of the EU-side efforts to valorise food waste streams, REFRESH identified the top 80 products and their associated 291 waste streams, based on consumption volume and environmental impact.

This information was used to develop FoodWasteEXplorer, providing immediate compositional (e.g. nutrients, bioactives, toxicants) data for these waste streams. 
This tool supports better evaluation (quality, safety, sustainability, legislation and costs) and exploitation of food waste. 
                </td>  </tr>
            <tr > 
                <td style="text-align: center; font-size: 1.2vw; color:#174c87;">
                    Acknowledgments: <a href="https://www.ijs.si/ijsw/JSI" style="color:#95c11f; ">Jožef Stefan Institute, </a> <a href="https://quadram.ac.uk" style="color:#95c11f; ">Quadram Institute Bioscience, </a> <a href="www.eurofir.org" style="color:#95c11f; ">  EuroFIR AISBL. </a>
                </td> </tr>
             <tr >   <td style="color:#174c87; font-family: regular; font-size: 1.2vw;">
Resource efficient food and drink for the entire supply chain (REFRESH) received funding from the European Union's Horizon 2020 research and innovation programme under grant agreement No. 641933.
This database is provided for information purposes only and, while every effort has been made to ensure information contained therein is accurate and up-to-date, REFRESH (hereafter referred to as ‘the Project’) and partner organisations (‘the Partners’) cannot guarantee accuracy and are not responsible for any errors or omissions. The Project and Partners are not liable for any damages whatsoever in connection with the use of this database. This database contains links to content provided or operated by other parties. The inclusion of such links does not imply endorsement of any or all of the material or opinion expressed on these reports or websites or of the other parties. The Project and Partners are not responsible for the content and will admit no liability for their use. 
The information provided on the website, and in the database, does not necessarily reflect the official opinion of the European Union. Neither the European Union institutions and bodies nor any person acting on their behalf nor the 
Partners may be held responsible for the use(s) made of the information contained therein.
            </td>   </tr>  

          </table>
    </div>
       
    </body>
                <footer class="navbar navbar-default navbar-static-bottom" style="  vertical-align: middle; position: relative;
  width: 100%;
  margin: 0 auto;
  background: #eeeae9;
  padding: 20px 22px;
  border: 1px solid;
  margin-top: 2%;
  border-top-color: #eeeae9;
  border-left-color: #eeeae9;
  border-bottom-color: #eeeae9;
  border-right-color: rgba(60,60,60,.4);
  
  bottom:0;
  left:0;">
    <div class="style-1">
     
<ul class="nav" style="align-items: center;">
    

  <li class="nav-item">
      <a class="nav-link" href=""><h4 style="font-size: 1.3vw;" >About</h4></a>
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


</html>

