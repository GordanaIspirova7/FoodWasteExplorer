/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;

import foodwaste.domain.Food;
import foodwaste.domain.Compgroup;
import foodwaste.domain.Component;
import foodwaste.domain.ComponentList;
import foodwaste.domain.Matrix;
import foodwaste.domain.Referencetype;
import foodwaste.domain.Unit;
import foodwaste.domain.User;
import foodwaste.domain.Wastestream;
import foodwaste.domain.WastestreamFood;
import foodwaste.domain.WastreamPOSTClass;
import foodwaste.domain.WsvaluePostAdd;
import foodwaste.domain.Wsvalue;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvalueResult;
import foodwaste.service.Service;
import foodwaste.service.ServiceImpl;
import foodwaste.domain.EditUser;
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
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author gorda
 */
@Controller("/table")

public class TableController {
     protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public TableController(){
 
    }


   
      

// 
      @RequestMapping(value = "/table", method = RequestMethod.GET)
	public String table(ModelMap model, Food food, Wastestream w, HttpServletRequest request, Integer page,     
   @RequestParam(value = "wastestream", required=false) String wstream,
   @RequestParam(value = "compgroup", required=false) String cgr,
   @RequestParam(value = "cmp", required=false) String comp){
      
            
            
         
                if((page==null))
                {
                    if(wstream.equals("All waste streams")){
      Wastestream ws = new Wastestream();
      User u=new User();
      model.addAttribute("user",u);
      String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      String foodname=(String)request.getSession().getAttribute("foodname");
      request.getSession().setAttribute("foodname", foodname);
      model.addAttribute("foodname", foodname);
      
      model.addAttribute(ws);
      model.addAttribute(food);
      
      model.addAttribute("id", food.getFoodid());
   

      return "redirect:/print";
                }
           
                else{
                User u=new User();
                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                Compgroup cg=new Compgroup();
                model.addAttribute("command1",food);
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);
                String foodname=(String)request.getSession().getAttribute("foodname");
                request.getSession().setAttribute("foodname", foodname);
                String wastestream=(String)request.getParameter("wastestream");
                request.getSession().setAttribute("wastestream", wastestream);
                model.addAttribute("wastestream", w.getWastestream());
                model.addAttribute("commandcg",cg);
                model.addAttribute("compgroup",cg.getCompgroup());
                WsvaluePostClass ws1=new WsvaluePostClass();
                WsvaluePostClass ws2=new WsvaluePostClass();
                model.addAttribute("commandw",w);
                model.addAttribute("command",ws1);
                model.addAttribute("deleteWastevalue",ws2);
                
                
                EditUser u1=new foodwaste.domain.EditUser();
                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                
                int i=0;
                
                
          List<WsvalueResult> wsvalues=service.searchWastestream(wastestream);
          List<ComponentList> list=service.getcomponentList();
          List<Unit> units=service.getDDUnit();
          
          model.addAttribute("units",units);
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
         
         model.addAttribute("result1size",result1.size());
         flag=0;
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
         
//             Set<WsvalueResult> hs = new HashSet<WsvalueResult>();
//             hs.addAll(result1);
//             result1.clear();
//             result1.addAll(hs);
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
        return s1.getCompgroup().compareToIgnoreCase(s2.getCompgroup());
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
        
           
    
      

     List<Compgroup> compgroupData=service.getDDCompgroups();
     List<String> compgroupList = new ArrayList();      
     
      for(Compgroup object : compgroupData){
         compgroupList.add(object.getCompgroup());
         
      }
      Collections.sort(compgroupList);
                model.addAttribute("compgroupList",compgroupList);
                
                
                  
     List<Unit> unitData=service.getDDUnit();
     String[] unitList = new String[unitData.size()];
      
     
      for(Unit object : unitData){
         unitList[i]=object.getFtc();
         i++;
      }
      
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
		return "table";
	}}
                    
                    
                    
                    //////////////////////////////
    else{
                User u=new User();
                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                Compgroup cg=new Compgroup();
                model.addAttribute("command1",food);
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);
                String foodname=(String)request.getSession().getAttribute("foodname");
                request.getSession().setAttribute("foodname", foodname);
                String wastestream=(String)request.getParameter("wastestream");
                request.getSession().setAttribute("wastestream", wastestream);
                model.addAttribute("wastestream", w.getWastestream());
                model.addAttribute("commandcg",cg);
                model.addAttribute("compgroup",cg.getCompgroup());
                WsvaluePostClass ws1=new WsvaluePostClass();
                WsvaluePostClass ws2=new WsvaluePostClass();
                model.addAttribute("commandw",w);
                model.addAttribute("command",ws1);
                model.addAttribute("deleteWastevalue",ws2);
                
                
                EditUser u1=new foodwaste.domain.EditUser();
                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                
                int i=0;
                
                
          List<WsvalueResult> wsvalues=service.searchWastestream(wastestream);
          List<ComponentList> list=service.getcomponentList();
          List<Unit> units=service.getDDUnit();
          
          model.addAttribute("units",units);
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
         
         model.addAttribute("result1size",result1.size());
         flag=0;
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
         
//             Set<WsvalueResult> hs = new HashSet<WsvalueResult>();
//             hs.addAll(result1);
//             result1.clear();
//             result1.addAll(hs);
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
        return s1.getCompgroup().compareToIgnoreCase(s2.getCompgroup());
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
        
           
    
        i=0;

     List<Compgroup> compgroupData=service.getDDCompgroups();
     List<String> compgroupList = new ArrayList();      
     
      for(Compgroup object : compgroupData){
         compgroupList.add(object.getCompgroup());
         i++;
      }
      Collections.sort(compgroupList);
                model.addAttribute("compgroupList",compgroupList);
                
                
                   i=0;
     List<Unit> unitData=service.getDDUnit();
     String[] unitList = new String[unitData.size()];
      
     
      for(Unit object : unitData){
         unitList[i]=object.getFtc();
         i++;
      }
      
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
		return "table";
	}
        }
        
        
        //////
        
          @RequestMapping(value = "/compgroup", method = RequestMethod.POST)
      public String compgroup(@ModelAttribute("SpringWeb") Food f, Integer page, Wastestream w, Compgroup cg, BindingResult bindingResult, 
   
   ModelMap model, HttpServletRequest request, HttpSession httpSession,    
   @RequestParam(value = "wastestream", required=false) String wstream,
   @RequestParam(value = "compgroup", required=false) String cgr,
   @RequestParam(value = "cmp", required=false) String comp){
      
         
          String foodname=(String)request.getSession().getAttribute("foodname");
      request.getSession().setAttribute("foodname", foodname);
      model.addAttribute("foodname",foodname);
      String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);

      model.addAttribute("commandw",w);
      model.addAttribute("command1",f);
      model.addAttribute("commandcg",cg);
      Component c=new Component();
      model.addAttribute("component",c);
      model.addAttribute("ftc",c.getFtc());
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
      model.addAttribute("compgroup", cg.getCompgroup());
     
    
      return "redirect:/compgroup";
   }
      //////////////////////
      

  
   
@RequestMapping(value="/editWastevalue", params="action", method=RequestMethod.POST)
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
@RequestMapping(value="/editWastevalue", params="action1", method=RequestMethod.POST)
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
 



    @RequestMapping(value = "/table1", method = RequestMethod.POST)
      public String table1(@ModelAttribute("SpringWeb") Food f,  Wastestream w, Integer page,  BindingResult bindingResult, 
   
   ModelMap model, HttpServletRequest request,   
   @RequestParam(value = "wastestream", required=false) String wstream,
   @RequestParam(value = "compgroup", required=false) String cgr,
   @RequestParam(value = "cmp", required=false) String comp){
      
          
         
    
               model.addAttribute("command1",f);
                Compgroup cg=new Compgroup();
                model.addAttribute("commandcg",cg);
                model.addAttribute("compgroup",cg.getCompgroup());
               
                model.addAttribute("commandw",w);
                String foodname=(String)request.getSession().getAttribute("foodname");
                request.getSession().setAttribute("foodname", foodname);
                model.addAttribute("foodname", foodname);
                WsvaluePostAdd ws1=new WsvaluePostAdd();
                model.addAttribute("command",ws1);
                String wastestream=(String)request.getSession().getAttribute("wastestream");
                request.getSession().setAttribute("wastestream", wastestream);
                model.addAttribute("wastestream",w.getWastestream());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);
                        
                        
                        
                EditUser u1=new foodwaste.domain.EditUser();
                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                
          List<WsvalueResult> wsvalues=service.searchWastestream(wastestream);
          List<ComponentList> list=service.getcomponentList();
          List<Unit> units=service.getDDUnit();
          
          model.addAttribute("units",units);
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
         
//             Set<ComponentList> hs = new HashSet<ComponentList>();
//             hs.addAll(result2);
//             result2.clear();
//             result2.addAll(hs);


            Map<Integer, ComponentList> map = new HashMap<Integer, ComponentList>();
            for (ComponentList r : result2) {
            Integer key = r.getCompid();
            if (!map.containsKey(key)) {
          map.put(key, r);
     }
}
            
Collection<ComponentList> result11 = map.values();
List<ComponentList> result12=new ArrayList();
for(ComponentList r1:result11)
{
   result12.add(r1);
}
Collections.sort(result12, new Comparator<ComponentList>() {
    @Override
    public int compare(ComponentList s1, ComponentList s2) {
        return s1.getCompsubgroup().compareToIgnoreCase(s2.getCompsubgroup());
    }
});



        
        PagedListHolder<ComponentList> pagedListHolder = new PagedListHolder<>(result12);
        pagedListHolder.setPageSize(20);
        model.addAttribute("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

         model.addAttribute("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            model.addAttribute("result2", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
             model.addAttribute("result2", pagedListHolder.getPageList());
        }


        
		return "redirect:/table1";
	}

@RequestMapping(value="/foodwasteHome", method=RequestMethod.POST)
public String foodwasteHome(@ModelAttribute("SpringWeb") User u, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);

return "redirect:/foodwasteHome";
}



         @RequestMapping(value = "/editUsertable", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") foodwaste.domain.EditUser u1, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);



return "redirect:/editUser";
}


  
    }