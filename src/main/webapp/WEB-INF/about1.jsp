
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
  
       

    
    
     
        <div class="container" style="padding-bottom: 2vw;">
<table class="table container" style="  position: relative;
  width: 100%;
  margin: 0 auto;
  background: rgba(130,130,130,.8);
  border: 1px solid;
  border-top-color: rgba(255,255,255,.4);
  border-left-color: rgba(255,255,255,.4);
  border-bottom-color: rgba(255,255,255,.4);
  border-right-color: rgba(255,255,255,.4);">
            <div style="text-align: center; color: #95c11f; font-family: medium; font-size: 1.5vw;" >  FoodWasteEXplorer: Exploring the nutrient content of food waste streams <br> </div>
         
            <tr>       <td colspan="2" style="color:white; font-family: regular; font-size: 1.2vw;" >         FoodWasteEXplorer (Food Waste Stream Compositional Data Maintenance & Explorer Tool) is the first online tool that allows the composition (e.g. nutrients, bioactives, toxicants) of food waste streams to be explored, based on food type and component groups, and the search results exported as ExcelTM for further offline analysis. 

                    FoodWasteEXplorer was developed by REFRESH (641933, Resource efficient food and drink for the entire supply chain), which aims to help reduce food waste across the EU by 30% in 2025 (~ 25-40 million tonnes of food not wasted) and maximise the value of unavoidable food waste and packaging materials.

One-third of food produced for human consumption is lost or wasted globally, which amounts to ca. 1.3 billion tonnes annually. As part of the EU-side efforts to valorise food waste streams, REFRESH identified the top 80 products and their associated 291 waste streams, based on consumption volume and environmental impact.

This information was used to develop FoodWasteEXplorer, providing immediate compositional (e.g. nutrients, bioactives, toxicants) data for these waste streams. 
This tool supports better evaluation (quality, safety, sustainability, legislation and costs) and exploitation of food waste. 
                </td>  </tr>
            <tr > 
                <td style="text-align: center; font-size: 1.2vw; color: white">
                    Acknowledgments: <a href="https://www.ijs.si/ijsw/JSI" style="color:#95c11f; ">Jožef Stefan Institute, </a> <a href="https://quadram.ac.uk" style="color:#95c11f; ">Quadram Institute Bioscience, </a> <a href="www.eurofir.org" style="color:#95c11f; ">  EuroFIR AISBL. </a>
                </td> </tr>
             <tr >   <td style="color:white; font-family: regular; font-size: 1.2vw;">
Resource efficient food and drink for the entire supply chain (REFRESH) received funding from the European Union's Horizon 2020 research and innovation programme under grant agreement No. 641933.
This database is provided for information purposes only and, while every effort has been made to ensure information contained therein is accurate and up-to-date, REFRESH (hereafter referred to as ‘the Project’) and partner organisations (‘the Partners’) cannot guarantee accuracy and are not responsible for any errors or omissions. The Project and Partners are not liable for any damages whatsoever in connection with the use of this database. This database contains links to content provided or operated by other parties. The inclusion of such links does not imply endorsement of any or all of the material or opinion expressed on these reports or websites or of the other parties. The Project and Partners are not responsible for the content and will admit no liability for their use. 
The information provided on the website, and in the database, does not necessarily reflect the official opinion of the European Union. Neither the European Union institutions and bodies nor any person acting on their behalf nor the 
Partners may be held responsible for the use(s) made of the information contained therein.
            </td>   </tr>  

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
  bottom:0;
  left:0;">
           
     
        
            <div class="style-1">
     
<ul class="nav">
    

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
