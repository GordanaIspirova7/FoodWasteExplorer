/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;

import foodwaste.domain.Compgroup;
import foodwaste.domain.Component;
import foodwaste.domain.ComponentList;
import foodwaste.domain.Food;
import foodwaste.domain.User;
import foodwaste.domain.EditUser;
import foodwaste.domain.Unit;
import foodwaste.domain.Wastestream;
import foodwaste.domain.WastestreamFood;
import foodwaste.domain.Wsvalue;
import foodwaste.domain.WsvaluePostAdd;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvalueResult;
import foodwaste.service.ServiceImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author gorda
 */
@Controller("/componentHome1")
public class ComponentHome1{
    
    protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
    
    public ComponentHome1(){
 
    }
    

    @RequestMapping(value = "/componentHome1", method = RequestMethod.GET)
      
      public String componentHome(ModelMap model, Food f, Integer page, Compgroup cg, Component c, Wastestream w, HttpServletRequest request,  HttpSession httpSession,
   @RequestParam(value = "wastestream", required=false) String wstream,
   @RequestParam(value = "compgroup", required=false) String cgr,
   @RequestParam(value = "cmp", required=false) String comp
      ){
      
        Integer compgroupid1=0, flag1=0;
          String group=(String)request.getSession().getAttribute("compgroup");
          List<Compgroup> compgroupData12=service.getDDCompgroups();
         for(Compgroup object:compgroupData12)
         {
             if(object.getCompgroup().equals(group))
                 compgroupid1=object.getCompgroupid();
         }
     
     List<ComponentList> cl12=service.searchCompgroup(group);
     List<WsvalueResult> cl21=service.searchCompgroup(compgroupid1);
      List<String> componentList1=new ArrayList();
      for(ComponentList object: cl12)
      {
          componentList1.add(object.getCftc());
      }
      for(WsvalueResult object:cl21)
      {
          componentList1.add(object.getCftc());
      }
      for(String s:componentList1)
      {
          if(s.equals(c.getFtc()))
          {
              flag1=1;
          }
              
      }
      
      if(flag1==0)
      {
      User u=new User();
      model.addAttribute("user",u);
      model.addAttribute("email",u.getEmail());     
      String foodname=(String)request.getSession().getAttribute("foodname");
      request.getSession().setAttribute("foodname", foodname);
      model.addAttribute("foodname",foodname);
      String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      String component = (String)request.getParameter("ftc"); 
      request.getSession().setAttribute("ftc", component);
      model.addAttribute("commandw",w);
      model.addAttribute("command1",f);
      model.addAttribute("commandcg",cg);
      Component c1=new Component();
      model.addAttribute("component",c1);
      model.addAttribute("commandNA",cg);
      WsvaluePostClass ws1=new WsvaluePostClass();
      model.addAttribute("command",ws1);
      WsvaluePostClass wsp2=new WsvaluePostClass();
      model.addAttribute("deleteWastevalue",wsp2);
      String wastestream=(String)request.getSession().getAttribute("wastestream");
      request.getSession().setAttribute("wastestream", wastestream);
      model.addAttribute("wastestream",wastestream);
      String compgroup=(String)request.getSession().getAttribute("compgroup");
      request.getSession().setAttribute("compgroup", compgroup);
      model.addAttribute("compgroup", compgroup);
      return "redirect:/compgroup";
      }
      else{
      User u=new User();
      model.addAttribute("user",u);
      model.addAttribute("email",u.getEmail());
      WsvaluePostAdd ws3=new WsvaluePostAdd();
      model.addAttribute("command",ws3);
    
      model.addAttribute("command1",f);
      String foodname=(String)request.getSession().getAttribute("foodname");
      request.getSession().setAttribute("foodname", foodname);
      model.addAttribute("foodname",foodname);
      model.addAttribute("commandcg",cg);
      model.addAttribute("commandw",w);
      String component1 = (String)request.getParameter("ftc"); 
      request.getSession().setAttribute("ftc", component1);
      model.addAttribute("compsubgroups", cg.getCompsubgroups());
      model.addAttribute("component",c);
      model.addAttribute("commandNA",cg);
      model.addAttribute("ftc",c.getFtc());
      String compgroup=(String)request.getSession().getAttribute("compgroup");
      request.getSession().setAttribute("compgroup", compgroup);
      model.addAttribute("compgroup", compgroup);
   
      String wastestream=(String)request.getSession().getAttribute("wastestream");
      request.getSession().setAttribute("wastestream", wastestream);
      model.addAttribute("wastestream",wastestream);
      List<WsvalueResult> wsvalues=service.searchWastestream(wastestream);
      String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);

      
      EditUser u1=new foodwaste.domain.EditUser();
      model.addAttribute("editUser",u1);
      model.addAttribute("email",u1.getEmail());
      String component=c.getFtc();     
      List<ComponentList> list=service.searchCompgroup(compgroup);
          Integer flag=0;
  for(ComponentList cll: list) {
                 for (WsvalueResult ws: wsvalues){
                if((ws.getCompid()==cll.getCompid()) && (ws.getCftc().equals(component))&&(flag==0))
                { flag=1;
               
                }}
   
            
                if((cll.getCftc().equals(component)) && (flag==0))
                { flag=1;
                   model.addAttribute("cl",cll);
                  }}

 

    
         
         
         
         
         
         Integer compgroupid=0;
         List<Compgroup> compgroupData1=service.getDDCompgroups();
         for(Compgroup object:compgroupData1)
         {
             if(object.getCompgroup().equals(compgroup))
                 compgroupid=object.getCompgroupid();
         }
     
     List<ComponentList> cl=service.searchCompgroup(compgroup);
     List<WsvalueResult> cl1=service.searchCompgroup(compgroupid);
      List<String> componentList=new ArrayList();
      for(ComponentList object: cl)
      {
          componentList.add(object.getCftc());
      }
      for(WsvalueResult object:cl1)
      {
          componentList.add(object.getCftc());
      }
              Set<String> hs = new HashSet<String>();
             hs.addAll(componentList);
             componentList.clear();
             componentList.addAll(hs);
             Collections.sort(componentList);
           model.addAttribute("componentList",componentList);
           
    
        int i=0;

     List<Compgroup> compgroupData=service.getDDCompgroups();
     List<String> compgroupList = new ArrayList();      
     
      for(Compgroup object : compgroupData){
         compgroupList.add(object.getCompgroup());
         
      }
      Collections.sort(compgroupList);
      model.addAttribute("compgroupList",compgroupList);
                
       i=0;
     List<Unit> unitData=service.getDDUnit();
     List<String> unitList = new ArrayList();
      
     
      for(Unit object : unitData){
         unitList.add(object.getFtc());
         
      }
      Set<String> hsunit = new HashSet<String>();
      hsunit.addAll(unitList);
      unitList.clear();
      unitList.addAll(hsunit);
      Collections.sort(unitList);
      model.addAttribute("unitList",unitList);
     List<Food> foodData=service.getDDFoods();
       List<String> foodList=new ArrayList();
       for(Food object:foodData)
       {
           foodList.add(object.getFoodname());
           
       }
       Collections.sort(foodList);
      model.addAttribute("foodList",foodList);
        Integer foodid=service.getFoodId(foodname);
      List<WastestreamFood> wsf=service.searchFood1(foodid);
       
       List<String> wastestreamList=new ArrayList();
       for (WastestreamFood wf:wsf)
       {
           wastestreamList.add(wf.getWastestream());
         
       }
       Set<String> hs1 = new HashSet<String>();
             hs1.addAll(wastestreamList);
             wastestreamList.clear();
             wastestreamList.addAll(hs1);
       Collections.sort(wastestreamList);
       model.addAttribute("wastestreamList",wastestreamList);
      return "componentHome1";
   }}
    ///////////////////////////////////////
@RequestMapping(value="/foodwasteHomecomponent1", method=RequestMethod.POST)
public String foodwasteHome(@ModelAttribute("SpringWeb") User u, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);

return "redirect:/foodwasteHome";
}
@RequestMapping(value="/addWastevalue3", method=RequestMethod.POST)
public String addWastevalue(@ModelAttribute("SpringWeb") WsvaluePostAdd w, BindingResult result, ModelMap model, HttpServletRequest request) {
                User u=new User();
                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                model.addAttribute("addWastevalue",w);
                model.addAttribute("value",w.getValue());
                model.addAttribute("uftc",w.getUftc());
                model.addAttribute("citation",w.getCitation());
                model.addAttribute("compid",w.getCompid());
                model.addAttribute("wastestream",w.getWastestream());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);

return "redirect:/addWastevalue1";
}



         @RequestMapping(value = "/editUsercomponent1", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") EditUser u1, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);


return "redirect:/editUser";
}

}
