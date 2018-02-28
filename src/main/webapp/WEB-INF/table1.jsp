<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="foodwaste.service.ServiceImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="foodwaste.domain.WsvalueResult"%>
<%@page import="foodwaste.domain.Wastestream"%>
<%@page import="foodwaste.domain.WastreamPOSTClass"%>
<%@page import="foodwaste.domain.Food"%>
<%@page import="foodwaste.domain.User"%>
<%@page import="foodwaste.domain.UserRole"%>
<%@page import="foodwaste.domain.Component"%>
<%@page import="foodwaste.domain.ComponentList"%>
<%@page import="foodwaste.domain.Unit"%>

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
    

    
                <% 
           HttpSession httpSession=request.getSession();
           String foodname = (String) httpSession.getAttribute("foodname");
           ServiceImpl service= new ServiceImpl();
           String wastestream = (String)httpSession.getAttribute("wastestream"); 
           httpSession.setAttribute("wastestream", wastestream);
           String email = (String) httpSession.getAttribute("email");
           httpSession.setAttribute("email", email);
           User user=service.user(email);
           httpSession.setAttribute("user", user);
           Integer userrole=service.getRole(email);
          
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

         </script>
    
        <div style="float:left;">
            <form:form method="POST" commandName="user" action="foodwasteHometable1" >
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
            <form:form method="POST" commandName="editUser" action="editUsertable1" >
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


           
              
         <div class="container-row row justify-content-between menu" style="align-items: center;  margin-top: 5%; " >
             <div class="mainselect">
                   <form:form method="POST" commandName="command1" action="print">
	
	

                          
                 
                    <span class="float-left titles">Select food:</span>

  <form:select onchange="this.form.submit()" path="foodname" class=" col-md-10 selectpicker style-select" data-live-search="true"  >       
      <form:option  value="" disabled="true" selected="true">Food...</form:option>                      
      <form:options data-tokens="${foodList}" items="${foodList}"/>
                        </form:select>                      
          
       </form:form>
         </div>
                  <div class="mainselect">
           <form:form  method="POST" commandName="commandw" action="table">
	

                    
                                          <span class="float-left titles">Select waste stream:</span>

                              <form:select onchange="this.form.submit()" path="wastestream" class=" col-md-10 selectpicker style-select" data-live-search="true"  placeholder="Enter food name..." >
                              <form:option  value="All waste streams">All waste streams</form:option>
                              <form:options data-tokens="${wastestreamList}" items="${wastestreamList}"/>
                              </form:select>  
                    
    
	</form:form>
     </div>
           <div class="mainselect">
  <form:form method="POST" commandName="commandcg"  action="compgroup1">
                   
                                          <span class="float-left titles">Select component group:</span>

                              <form:select name="wastestream" onchange="this.form.submit()"  path="compgroup" class=" col-md-10 selectpicker style-select" data-live-search="true"  >
                              <form:option  value="All component groups" >All component groups</form:option>
                              <form:options data-tokens="${compgroupList}" items="${compgroupList}"/>
                              </form:select>  
           
  </form:form> 
        </div>
           <div class="mainselectNA">
   <form:form method="POST" commandName="commandcg"  action="compgroup1">
                   
                                          <span class="float-left titlesNA">Select component:</span>

                              <form:select onchange="this.form.submit()" disabled="true" path="compgroup" class=" col-md-10 selectpicker style-select" data-live-search="true"  >
                                  <form:option  value="" disabled="true" selected="true">Component...</form:option>
                               <form:options data-tokens="${compgroupList}" items="${compgroupList}"/>
                              </form:select>
   </form:form> 
           </div>
		
		
	
	
        
</div>

 <div class="row  container-row style-6 available" style="margin-top:2%; margin-bottom:1%;" >
          
        <div>
           <form:form  method="POST" commandName="commandw" action="entered">
           <form:input class="hide"  path="wastestream" value = "<%=wastestream%>"/>
              <form:button class="btn btn-succes" autocomplete="off" path="wastestream" type="submit"> Available </form:button>
                 </form:form>

            
                 
           
        </div>
       <div>
                   
                <a class="btn btn-success" disabled href="#">Not Available</a>
             </div>
    </div>
        <div class="row container-row style-6 selected" style="margin-top:1%;">
            <div>
          <%out.println(foodname);%> <a> >> </a> <%out.println(wastestream); %>
        
       
            </div> </div>
  <c:if test="${result2.size() == 0}" >
             
                <div class="table-editable container" style="padding-top: 1vw; font-family: regular; color: red; font-size: 2vw;">

          
            
        No data available.
     
       
            </div>
         </c:if>
     
      <c:if test="${result2.size() > 0}" >


        <%
            if((userrole==0)||(userrole==1)||(userrole==2))
            {
        %>   

                
                 <div id="notentered" >
                 
       <div id="table" class="table-editable container" >

          <table border="1" class="table tableview w-100 p-3 h-100 ">
         
         <thead>
            <tr style="text-align:  center;">
            <th>Component group</th>
            <th>Component</th>
            <th>Value</th>
            <th>Unit</th>
            <th>Reference</th>
            <th colspan="2"></span></th>
            </tr>
         </thead>
         
         <tbody>
           
             <c:forEach items = "${result2}" var="cl" varStatus="pStatus">
                
                <tr>
                    <form:form method="POST" id="form2" commandname="command" action="addWastevalue"> 
                        <form:input class="hide"   path="compid" value = "${cl.getCompid()}"/>
                        <form:input class="hide"   path="wastestream" value ="<%=wastestream%>"/>
                        
             <td style="width: 150px;">${cl.getCompsubgroup()}</td>
             <td style="width: 150px;">${cl.getCftc()}</td>   
             <td class="edit" contenteditable="false"><form:input autocomplete="off" readonly="true" path="value" value="N/A" /></td>
           <td class="edit" contenteditable="false">
              <form:select id="select" disabled="true" path="uftc" name="unit">
                              <form:option value="">Unit:</form:option>
                              <form:options data-tokens="${unitList}" items="${unitList}"/>
                              </form:select> 
          </td>
             <td class="edit citation" contenteditable="false"><form:input autocomplete="off" readonly="true" path="citation" value="N/A" /></td>

           <td class="edit1">
                                             <form:button class="hide btn-transparent table-save"  type="submit" onclick="return confirm('Are you sure you want to save this change?')">
                                               <div class="glyphicon glyphicon-ok"></div> 
                              </form:button>
                                         
                                               <div class="table-edit glyphicon glyphicon-pencil"></div>
            </td>
              

         
         </form:form>
               </tr>
          </c:forEach>   
                                              </tbody>
             
        </table>
       </div> 
                 </div>
      

             <%}%>
        <% 
if(userrole==3)
{%>
        <div id="table" class="table-editable container" style="text-align:center; margin-top:2%;">
              
          <table border="1" class="table tableview w-100 p-3 h-100 ">
         
         <thead>
            <tr style="text-align:  center;">
            <th>Component group</th>
            <th>Component</th>
            <th>Value</th>
            <th>Unit</th>
            <th>Reference</th>
            </tr>
         </thead>
         
         <tbody>
              <c:forEach items = "${result2}" var="cl" varStatus="pStatus">
             
              <tr>
       
           <td class="editn" contenteditable="false" >${cl.getCompsubgroup()}</td>
           <td class="editn" contenteditable="false" >${cl.getCftc()}</td>   
           <td class="edit" contenteditable="false" > N/A </td>
           <td class="edit" contenteditable="false" > N/A </td>
           <td class="edit" contenteditable="false" > N/A </td>

   
              </tr>
              
            </c:forEach>
             
         </tbody>       
        </table>
       </div> 
             
             <%}%>
             
      </c:if>
               <div class="contrainer text-center" >
                   <%String value="/table1?wastestream="+wastestream+"&foodname="+foodname; %> 
<c:if test="${maxPages > 1}"> 
<c:url value="<%=value%>"  var="prev">
        <c:param name="page" value="${page-1}"/>
    </c:url>
                   
                  
    <c:if test="${page > 1}">
        <a href="<c:out value="${prev}" />" class="pn prev pageing">Prev</a>
    </c:if>
            <c:if test="${maxPages > 10}">
      <c:forEach begin="${page}" end="${page+9}" step="1" varStatus="i">
        <c:choose>
            <c:when test="${page == i.index}">
                <span class="pageing">${i.index}</span>
            </c:when>
            <c:otherwise>
                <c:url value="<%=value%>"  var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href='<c:out value="${url}" />' class="pageing" >${i.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
                ...
    </c:if>
         <c:if test="${maxPages <= 10}">
          <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
        <c:choose>
            <c:when test="${page == i.index}">
                <span class="pageing">${i.index}</span>
            </c:when>
            <c:otherwise>
                <c:url value="<%=value%>"  var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href='<c:out value="${url}" />' class="pageing" >${i.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
                </c:if>
    <c:url value="<%=value%>" var="next">
        <c:param name="page" value="${page + 1}"/>
    </c:url>
    <c:if test="${page + 1 <= maxPages}">
        <a href='<c:out value="${next}" />' class="pn next pageing">Next</a>
    </c:if>
        </c:if>
             </div>
       </body>
        <footer class="footer navbar navbar-default navbar-static-bottom ">
           
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

</html>