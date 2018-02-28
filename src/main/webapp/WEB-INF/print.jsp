
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
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
   <body >
    


        <% 
           ServiceImpl service= new ServiceImpl();
    
           HttpSession httpSession = request.getSession();
           String foodname = (String) request.getAttribute("foodname");
           Integer foodid=service.getFoodId(foodname);
           httpSession.setAttribute("foodid", foodid);
           httpSession.setAttribute("foodname", foodname);
           String email = (String) httpSession.getAttribute("email");
           httpSession.setAttribute("email", email);
           User user=service.user(email);
           httpSession.setAttribute("user", user);
           Integer userrole=service.getRole(email);


           %> 
 <header class="style-headder flex-container" width="100%" style="background-image: url('refresh_header.jpg'); height: 5.1vw; align-content: center; justify-content: center;">

    
        <div style="float:left;">
            <form:form method="POST" commandName="user" action="foodwasteHomeprint" >
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
            <form:form method="POST" commandName="editUser" action="editUserprint" >
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

         <div class="container-row row justify-content-between menu" style=" align-items: center;  padding-top: 2vw;" >
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
           <form:form  method="POST" commandName="command" action="table">
	

                    
                                          <span class="float-left titles">Select waste stream:</span>

                              <form:select name="wastestream" onchange="this.form.submit()" path="wastestream" class=" col-md-10 selectpicker style-select" data-live-search="true"  placeholder="Enter food name..." >
                            
                              <form:option  value="All waste streams">All waste streams</form:option>
                              <form:options data-tokens="${wastestreamList}" items="${wastestreamList}"/>
                              </form:select>  
                    
    
	    </form:form>
   </div>
             
<div class="row mainselectNA">
 <form:form  method="POST" commandName="command" action="table">
                   
                                          <span class="float-left titlesNA">Select component group:</span>

                              <form:select onchange="this.form.submit()" disabled="true" path="wastestream" class=" col-md-10 selectpicker style-select" data-live-search="true"  >
                              <form:option  value="" disabled="true" selected="true">Component group...</form:option>
                              <form:options data-tokens="${wastestreamList}" items="${wastestreamList}"/>
                              </form:select>  
           
 </form:form> 
                              
</div>
             
<div class="mainselectNA">
<form:form  method="POST" commandName="command" action="table">
                   
                                          <span class="float-left titlesNA">Select component:</span>

                              <form:select onchange="this.form.submit()" disabled="true"  path="wastestream" class=" col-md-10 selectpicker style-select" data-live-search="true"  >
                              <form:option  value="" disabled="true" selected="true">Component...</form:option>
                              <form:options data-tokens="${wastestreamList}" items="${wastestreamList}"/>
                              </form:select>  
           
</form:form>  
</div>
		
     
</div>
 
<div class="container style-6 selected" > <%out.println(foodname);%> </div>
    
                             

        <%
            if((userrole==0)||(userrole==1)||(userrole==2))
            {
        %>   
              

        <div class="container-row">
            <div style="text-align:center; outline:none; border:none; font-family: regular; color: red; font-size: 1vw;">
        <h4>
               ${ErrorMessage} 
        </h4>
            </div>
        
        </div>   
        
        <div id="table" class="table-editable container" style="flex-direction: column;">
 
             <form:form method="POST" commandname="addWastestream" action="addWastestream">
                
                 
    <table border="1" class="table tableview w-100 p-3 h-100 " style = "clear:both;" >
          
            
      
         <thead>
             <tr style="text-align:  center; ">
            <th>Waste stream</th> 
            <th>Edible proportion</th>
            <th>NCF</th>
            <th>GCF</th>
            <th>Specific gravity</th> 
            <th><div class="table-add glyphicon glyphicon-plus"></div></th>
              </tr>
         </thead>
         
        <tbody>
                   
           <tr  class="hide"> 
          
                 
            
            <td class="edit-link" contenteditable="false"> <form:input autocomplete="off" readonly="true" style="text-align: center; border:none; outline:none;" path="wastestream" placeholder="undefined"/> </td>      
            <td class="edit" contenteditable="false"> <form:input autocomplete="off" id="edible" readonly="true" style="text-align: center; border:none; outline:none;" path="edible" placeholder="undefined"/> </td>
            <td class="edit" contenteditable="false"> <form:input autocomplete="off" id="ncf" readonly="true" style="text-align: center; border:none; outline:none;" path="ncf" placeholder="undefined"/> </td>
            <td class="edit" contenteditable="false"> <form:input autocomplete="off" id="gcf" readonly="true" style="text-align: center; border:none; outline:none;" path="gcf" placeholder="undefined"/> </td>
            <td class="edit" contenteditable="false"> <form:input autocomplete="off" id="specgravity" readonly="true" style="text-align: center; border:none; outline:none;" path="specgravity" placeholder="undefined"/> </td>
            <td class="edit1"><form:button class="hide btn-transparent table-save"  type="submit" onclick="return confirm('Are you sure you want to save this change?')">
                                               <div class="glyphicon glyphicon-ok"></div> 
                              </form:button>             
                                                <div class="table-edit glyphicon glyphicon-pencil"></div> 
            </td>
            
           
          </tr>
     
              </form:form>
         

        <c:forEach items = "${result}" var="ws" varStatus="pStatus">
             
         
        <tr>
            <td>
                 
                <form:form  method="POST" commandName="command" action="table">
                <form:input autocomplete="off" path="wastestream" style="color: #95c11f; font-size: 0.9vw;" class="submitLink" type="submit" value = "${ws.getWastestream()}" />
                </form:form>
            </td>
            <form:form method="POST" id="form2" commandname="editWastestream" action="editWastestream"> 
            <form:input class="hide"  path="wsid" value = "${ws.getWsid()}" />
            <td class="hide ws" contenteditable="false"> <form:input id="wastestream1"  autocomplete="off" readonly="true" path="wastestream" style="color: #95c11f" value = "${ws.getWastestream()}" /></td>   
            <td class="edit" contenteditable="false"><form:input id="edible1"  autocomplete="off" readonly="true" style="text-align: center; border:none; outline:none;" path="edible" value = "${ws.getEdible()}" /></td>
            <td class="edit" contenteditable="false"><form:input id="ncf1"  autocomplete="off" readonly="true" style="text-align: center; border:none; outline:none;" path="ncf" value = "${ws.getNcf()}" /></td>
            <td class="edit" contenteditable="false"><form:input  id="gcf1"  autocomplete="off" readonly="true" style="text-align: center; border:none; outline:none;" path="gcf" value = "${ws.getGcf()}" /></td>
            <td class="edit" contenteditable="false"><form:input id="specgravity1"  autocomplete="off" readonly="true" style="text-align: center; border:none; outline:none;" path="specgravity" value = "${ws.getSpecgravity()}" /></td>
            <td class="edit1">                             
                <form:button class="hide btn-transparent table-save"  type="submit" onclick="return confirm('Are you sure you want to save this change?')">
                <div class="glyphicon glyphicon-ok">
                        
                </div> 
                </form:button>
                
                <div class=" table-edit glyphicon glyphicon-pencil">
                    
                </div>
                              
                                               
                                               
            </td>
            </form:form>
        </tr>
        </c:forEach>


            
        
         
       
        </tbody>



 
                    
    </table>
      
       </div>
        
           <%}%>
        <% 
if(userrole==3)
{%>
 <div id="table" class="table-editable container" >
             
          <table border="1" class="table tableview w-100 p-3 h-100 ">
          
            
       
         <thead>
            <tr style="text-align:  center;">
            <th>Waste stream</th> 
            <th>Edible proportion</th>
            <th>NCF</th>
            <th>GCF</th>
            <th>Specific gravity</th> 
            
            </tr>
         </thead>
         
         <tbody>
<% 
   List<WastestreamFood> wsf=service.searchFood1(foodid);
           int index=0;
           
           Map<String, WastestreamFood> map = new HashMap<String, WastestreamFood>();
            for (WastestreamFood ws : wsf) {
            String key = ws.getWastestream();
            if (!map.containsKey(key)) {
          map.put(key, ws);
     }
}
            
Collection<WastestreamFood> wsf1 = map.values();
List<WastestreamFood> wsf2=new ArrayList();
for(WastestreamFood ws:wsf1)
{
    wsf2.add(ws);
}
Collections.sort(wsf2, new Comparator<WastestreamFood>() {
    @Override
    public int compare(WastestreamFood s1, WastestreamFood s2) {
        return s1.getWastestream().compareToIgnoreCase(s2.getWastestream());
    }
});
         for(WastestreamFood ws: wsf2) { 
                 index=index+1; %>

         <%  String wastestream=ws.getWastestream();
         String gcf;
         String specgravity;
         String edible;
         String ncf;
                if(ws.getEdible()==null)
                {
                    edible="N/A";
                }
                else
                {
                    edible=ws.getEdible().toString();
                }
                if(ws.getNcf()==null)
                {
                    ncf="N/A";
                }
                else
                {
                    ncf=ws.getNcf().toString();
                }
                if(ws.getGcf()==null)
                { gcf="N/A";}
                else
                { gcf=ws.getGcf().toString();}
                if(ws.getSpecgravity()==null)
                { specgravity="N/A";}
                else
                { specgravity=ws.getSpecgravity().toString();}
%>

                
  <tr>
           
                 
                

                 
            
             <td>
                 
                 <form:form  method="POST" commandName="command" action="table">
                 <form:input autocomplete="off" path="wastestream" style="color: #95c11f" class="submitLink" type="submit" value="<%=wastestream%>" />
                 </form:form>
             </td>
             <td contenteditable="false"><% out.println(edible);%></td>
             <td contenteditable="false"><% out.println(ncf);%></td>
             <td contenteditable="false"><% out.println(gcf);%></td>
             <td contenteditable="false"><% out.println(specgravity);%></td>
       </tr>    
          
        <% }
      %>

            
        
         
       
         
             </tbody>



 
                    
        </table>
       </div>
            <%}%>
         
<div class="contrainer text-center" >
                                         <%String value="/print?foodname="+foodname; %> 
<c:if test="${maxPages > 1}"> 
<c:url value="<%=value%>" var="prev">
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
                <c:url value="<%=value%>" var="url">
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
                <c:url value="<%=value%>" var="url">
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

