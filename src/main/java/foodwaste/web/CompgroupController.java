/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;


import foodwaste.domain.Compgroup;
import foodwaste.domain.Component;
import foodwaste.domain.ComponentList;
import foodwaste.domain.Compsubgroup;
import foodwaste.domain.Food;
import foodwaste.domain.Unit;
import foodwaste.domain.User;
import foodwaste.domain.EditUser;
import foodwaste.domain.Wastestream;
import foodwaste.domain.WastestreamFood;
import foodwaste.domain.Wsvalue;
import foodwaste.domain.WsvaluePostAdd;
import foodwaste.domain.WsvalueResult;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.service.Service;
import foodwaste.service.ServiceImpl;
import foodwaste.domain.WsvalueResult;
import org.springframework.web.servlet.ModelAndView; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory; 
import java.io.IOException;
import java.net.BindException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.HashSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.view.RedirectView;

@Controller("/compgroup")
public class CompgroupController{
    
    protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
    
    public CompgroupController(){
 
    }
    
   @RequestMapping(value = "/compgroup", method = RequestMethod.GET)
      
      public String compgroup(ModelMap model, Food f, User u, Integer page, Compgroup cg, Wastestream w, HttpServletRequest request,  HttpSession httpSession ,
      @RequestParam(value = "wastestream", required=false) String wstream,
   @RequestParam(value = "compgroup", required=false) String cgr,
   @RequestParam(value = "cmp", required=false) String comp){
      
          if(page==null){
      if(cgr.equals("All component groups"))
      {
      String foodname=(String)request.getSession().getAttribute("foodname");
      request.getSession().setAttribute("foodname", foodname);
      model.addAttribute("foodname",foodname);
      String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      Compgroup compgroup=new Compgroup();
      model.addAttribute("commandcg",compgroup);
      model.addAttribute("command",w);
      String wastestream=(String)request.getSession().getAttribute("wastestream");
      request.getSession().setAttribute("wastestream", wastestream);
      model.addAttribute("wastestream", wastestream);
     
      
     return "redirect:/table";
      }
      else{
      model.addAttribute("user",u);
      model.addAttribute("email",u.getEmail());
      model.addAttribute("command1",f);
      String foodname=(String)request.getSession().getAttribute("foodname");
      request.getSession().setAttribute("foodname", foodname);
      model.addAttribute("foodname",foodname);
      model.addAttribute("commandcg",cg);
      model.addAttribute("commandw",w);
      model.addAttribute("foodname",foodname);
      String wastestream=(String)request.getSession().getAttribute("wastestream");
      request.getSession().setAttribute("wastestream", wastestream);
      model.addAttribute("wastestream", wastestream);
      Component c=new Component();
      model.addAttribute("component",c);
      model.addAttribute("commandNA",cg);
      model.addAttribute("ftc",c.getFtc());
      WsvaluePostClass ws1=new WsvaluePostClass();
      model.addAttribute("command",ws1);
      WsvaluePostClass wsp2=new WsvaluePostClass();
      model.addAttribute("deleteWastevalue",wsp2);
      String compgroup=(String)request.getParameter("compgroup");
      request.getSession().setAttribute("compgroup", compgroup);
      model.addAttribute("compgroup",compgroup);
     // model.addAttribute("compgroup",cg.getCompgroup());
      List<WsvalueResult> wsvalues=service.searchWastestream(wastestream);
      String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      
      
      
      EditUser u1=new foodwaste.domain.EditUser();
      model.addAttribute("editUser",u1);
      model.addAttribute("email",u1.getEmail());
          
          List<ComponentList> list=service.searchCompgroup(compgroup);
          List<WsvalueResult> result1=new ArrayList<WsvalueResult>();
          List<ComponentList> result2=new ArrayList<ComponentList>();
          Integer flag=0;
         for(ComponentList cl: list) {
             for (WsvalueResult ws: wsvalues){
                if((ws.getCompid()==cl.getCompid()) && (flag==0))
                { flag=1;
                  result1.add(ws);
                  }}
                if(flag==0){
                    result2.add(cl);

                }
                if(flag==1) 
                { flag=0; }  }
       ///////////////////////////////////////////////////////
                   Map<Integer, WsvalueResult> map = new HashMap<Integer, WsvalueResult>();
            for (WsvalueResult r : result1) {
            Integer key = r.getCompid();
            if (!map.containsKey(key)) {
          map.put(key, r);
                                        }
                                            }
            
Collection<WsvalueResult> result11 = map.values();
List<WsvalueResult> result12=new ArrayList();
for(WsvalueResult r1:result11)
{
   result12.add(r1);
}
Collections.sort(result12, new Comparator<WsvalueResult>() {
    @Override
    public int compare(WsvalueResult s1, WsvalueResult s2) {
        return s1.getCftc().compareToIgnoreCase(s2.getCftc());
    }
});


 
          PagedListHolder<WsvalueResult> pagedListHolder = new PagedListHolder<>(result12);
        pagedListHolder.setPageSize(20);
        model.addAttribute("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

         model.addAttribute("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            model.addAttribute("result1", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
             model.addAttribute("result1", pagedListHolder.getPageList());
        }
    
         
         
         
         
         
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
      return "compgroup";
   }}
           else{
      model.addAttribute("user",u);
      model.addAttribute("email",u.getEmail());
      model.addAttribute("command1",f);
      String foodname=(String)request.getSession().getAttribute("foodname");
      request.getSession().setAttribute("foodname", foodname);
      model.addAttribute("foodname",foodname);
      model.addAttribute("commandcg",cg);
      model.addAttribute("commandw",w);
      model.addAttribute("foodname",foodname);
      String wastestream=(String)request.getSession().getAttribute("wastestream");
      request.getSession().setAttribute("wastestream", wastestream);
      model.addAttribute("wastestream", wastestream);
      Component c=new Component();
      model.addAttribute("component",c);
      model.addAttribute("commandNA",cg);
      model.addAttribute("ftc",c.getFtc());
      WsvaluePostClass ws1=new WsvaluePostClass();
      model.addAttribute("command",ws1);
      WsvaluePostClass wsp2=new WsvaluePostClass();
      model.addAttribute("deleteWastevalue",wsp2);
      String compgroup=(String)request.getParameter("compgroup");
      request.getSession().setAttribute("compgroup", compgroup);
      model.addAttribute("compgroup",compgroup);
     // model.addAttribute("compgroup",cg.getCompgroup());
      List<WsvalueResult> wsvalues=service.searchWastestream(wastestream);
      String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      
      
      
      EditUser u1=new foodwaste.domain.EditUser();
      model.addAttribute("editUser",u1);
      model.addAttribute("email",u1.getEmail());
          
          List<ComponentList> list=service.searchCompgroup(compgroup);
          List<WsvalueResult> result1=new ArrayList<WsvalueResult>();
          List<ComponentList> result2=new ArrayList<ComponentList>();
          Integer flag=0;
         for(ComponentList cl: list) {
             for (WsvalueResult ws: wsvalues){
                if((ws.getCompid()==cl.getCompid()) && (flag==0))
                { flag=1;
                  result1.add(ws);
                  }}
                if(flag==0){
                    result2.add(cl);

                }
                if(flag==1) 
                { flag=0; }  }
       ///////////////////////////////////////////////////////
                   Map<Integer, WsvalueResult> map = new HashMap<Integer, WsvalueResult>();
            for (WsvalueResult r : result1) {
            Integer key = r.getCompid();
            if (!map.containsKey(key)) {
          map.put(key, r);
                                        }
                                            }
            
Collection<WsvalueResult> result11 = map.values();
List<WsvalueResult> result12=new ArrayList();
for(WsvalueResult r1:result11)
{
   result12.add(r1);
}
Collections.sort(result12, new Comparator<WsvalueResult>() {
    @Override
    public int compare(WsvalueResult s1, WsvalueResult s2) {
        return s1.getCftc().compareToIgnoreCase(s2.getCftc());
    }
});


 
          PagedListHolder<WsvalueResult> pagedListHolder = new PagedListHolder<>(result12);
        pagedListHolder.setPageSize(20);
        model.addAttribute("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

         model.addAttribute("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            model.addAttribute("result1", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
             model.addAttribute("result1", pagedListHolder.getPageList());
        }
    
         
         
         
         
         
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
      return "compgroup";
   }}
  

      
                      @RequestMapping(value = "/componentHome", method = RequestMethod.POST)
     public String componentHome (@ModelAttribute("SpringWeb") Food f, User u,  Wastestream w, Compgroup cg, Component c, BindingResult bindingResult, 
   
   ModelMap model, HttpServletRequest request, HttpSession httpSession,          
   @RequestParam(value = "wastestream", required=false) String wstream,
   @RequestParam(value = "compgroup", required=false) String cgr,
   @RequestParam(value = "cmp", required=false) String comp
      ){

         String component=c.getFtc();
         String wastestream=(String)request.getSession().getAttribute("wastestream");
         model.addAttribute("wastestream",wastestream); 
         request.getSession().setAttribute("wastestream", wastestream);
         
         String compgroup=(String)request.getSession().getAttribute("compgroup");
         request.getSession().setAttribute("compgroup", compgroup);
         model.addAttribute("compgroup",compgroup);
        
         String foodname=(String)request.getSession().getAttribute("foodname");
         request.getSession().setAttribute("foodname", foodname);
         model.addAttribute("foodname",foodname);
    
         
         List<WsvalueResult> wsvalues=service.searchWastestream(wastestream);
         List<ComponentList> list=service.searchCompgroup(compgroup);
         Integer flag=0, flag1=0;
         for (WsvalueResult ws: wsvalues){
                 
                  if((ws.getCftc().equals(component))&&(flag==0))
                { flag=1; flag1=1;}}
         if(flag1==0){
         for(ComponentList cl:list)
{
if(cl.getCftc().equals(component))
{
    flag=2;
}}}

   if((flag==1)&&(flag1==1)){
       
      model.addAttribute("user",u);
      model.addAttribute("email",u.getEmail());
      String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      model.addAttribute("commandw",w);
      model.addAttribute("command1",f);
      model.addAttribute("commandcg",cg);
      model.addAttribute("component",c);
      model.addAttribute("ftc",c.getFtc());
      model.addAttribute("commandNA",cg);
      WsvaluePostClass ws1=new WsvaluePostClass();
      model.addAttribute("edit",ws1);
      WsvaluePostClass wsp2=new WsvaluePostClass();
      model.addAttribute("command",wsp2);
      WsvaluePostAdd ws3=new WsvaluePostAdd();
      model.addAttribute("add",ws3);
       request.getSession().setAttribute("compgroup", compgroup);

      return "redirect:/componentHome";
   }
   else if ((flag==2)&&(flag1==0)){
      
      model.addAttribute("user",u);
      model.addAttribute("email",u.getEmail());
      String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      request.getSession().setAttribute("compgroup", compgroup);
      model.addAttribute("commandw",w);
      model.addAttribute("command1",f);
      model.addAttribute("commandcg",cg);
      model.addAttribute("component",c);
      model.addAttribute("ftc",c.getFtc());
      model.addAttribute("commandNA",cg);
      WsvaluePostClass ws1=new WsvaluePostClass();
      model.addAttribute("edit",ws1);
      WsvaluePostClass wsp2=new WsvaluePostClass();
      model.addAttribute("command",wsp2);
      WsvaluePostAdd ws3=new WsvaluePostAdd();
      model.addAttribute("add",ws3);
      

      return "redirect:/componentHome1";
   }
   return "redirect:/componentHome";
     }
   
      //////////////////////////////////
      
@RequestMapping(value="/editWastevalue1", params="action", method=RequestMethod.POST)
public String editWastevalue(@ModelAttribute("SpringWeb") WsvaluePostClass w, BindingResult result, ModelMap model, HttpServletRequest request)
{

    
                model.addAttribute("editWastevalue",w);
                model.addAttribute("value",w.getValue());
                model.addAttribute("ftc",w.getFtc());
                model.addAttribute("citation",w.getCitation());
                model.addAttribute("email",w.getEmail());
                model.addAttribute("valueid",w.getValueid());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);

return "redirect:/editWastevalue";
} 
@RequestMapping(value="/editWastevalue1", params="action1", method=RequestMethod.POST)
public String deleteWastevalue(@ModelAttribute("SpringWeb") WsvaluePostClass w, BindingResult result, ModelMap model, HttpServletRequest request)
{
               model.addAttribute("editWastevalue",w);
                model.addAttribute("value",w.getValue());
                model.addAttribute("ftc",w.getFtc());
                model.addAttribute("citation",w.getCitation());
                model.addAttribute("email",w.getEmail());
                model.addAttribute("valueid",w.getValueid());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);
return "redirect:/deleteWastevalue1";
}




@RequestMapping(value="/foodwasteHomecompgroup", method=RequestMethod.POST)
public String foodwasteHome(@ModelAttribute("SpringWeb") User u, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);

return "redirect:/foodwasteHome";
}











    @RequestMapping(value = "/notentered1", method = RequestMethod.POST)
      public String compgroup(@ModelAttribute("SpringWeb") Food f, WsvaluePostClass ws1, WsvaluePostClass wsp2, Wastestream w, Compgroup cg, BindingResult bindingResult, 
   
   ModelMap model, HttpServletRequest request, HttpSession httpSession, @RequestParam(value = "wastestream", required=false) String wstream,
    @RequestParam(value = "compgroup", required=false) String cgr, @RequestParam(value = "cmp", required=false) String comp){
         

                model.addAttribute("commandNA",cg);
                model.addAttribute("compgroup",cg.getCompgroup());
      model.addAttribute("commandw",w);
      model.addAttribute("command1",f);
     String foodname=(String)request.getSession().getAttribute("foodname");
     request.getSession().setAttribute("foodname", foodname);
     model.addAttribute("foodname", foodname);
      String compgroup=(String)request.getSession().getAttribute("compgroup");
      request.getSession().setAttribute("compgroup", compgroup);
      
      Component c=new Component();
      model.addAttribute("component",c);
      model.addAttribute("ftc",c.getFtc());
      model.addAttribute("command",ws1);
      model.addAttribute("deleteWastevalue",wsp2);
      WsvaluePostAdd ws2=new WsvaluePostAdd();
      model.addAttribute("addWastevalue",ws2);
      
      String wastestream=(String)request.getSession().getAttribute("wastestream");
       model.addAttribute("wastestream",wastestream);
      request.getSession().setAttribute("wastestream", wastestream);
       String email=(String)request.getSession().getAttribute("email");
       request.getSession().setAttribute("email", email);  
       

   
      return "redirect:/compgroupNA";
   }
         @RequestMapping(value = "/editUsercompgroup", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") foodwaste.domain.EditUser u1, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);



return "redirect:/editUser";
}

}

    
