/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;

import foodwaste.domain.Food;
import foodwaste.domain.User;
import foodwaste.domain.EditUser;
import foodwaste.domain.Compgroup;
import foodwaste.domain.Component;
import foodwaste.domain.Wastestream;
import foodwaste.domain.Matrix;
import foodwaste.domain.Referencetype;
import foodwaste.domain.Unit;
import foodwaste.domain.WastestreamFood;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvalueResult;
import foodwaste.service.Service;
import foodwaste.service.ServiceImpl;

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
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.RedirectView;
import foodwaste.domain.WastreamPOSTClass;
import foodwaste.domain.Wsvalue;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author gorda
 */
@Controller("/print")

public class printController {
     protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public printController(){
 
    }

  
   
    

    @RequestMapping(value = "/print", method = RequestMethod.GET)
	public String print(ModelMap model, Food food, HttpServletRequest request, Integer page){
               
                User u=new User();
                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                Wastestream wastestream=new Wastestream();
                WastreamPOSTClass ws1=new WastreamPOSTClass();
                String foodname=(String)request.getParameter("foodname");
                request.getSession().setAttribute("foodname", foodname);
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);
                model.addAttribute("command1",food);
                model.addAttribute("command", wastestream);
                model.addAttribute("foodid",food.getFoodid());
		model.addAttribute("foodname",food.getFoodname());
                model.addAttribute("addWastestream",ws1);
                model.addAttribute("editWastestream",ws1);
                EditUser u1=new foodwaste.domain.EditUser();
                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                
                
                
                 
       List<Food> foodData=service.getDDFoods();
       List<String> foodList=new ArrayList();
       for(Food object:foodData)
       {
           foodList.add(object.getFoodname());
           
       }
       Collections.sort(foodList);
      model.addAttribute("foodList",foodList);
      Integer foodid=service.getFoodId(request.getParameter("foodname"));
      
       List<WastestreamFood> wsf=service.searchFood1(foodid);
       Map<String, WastestreamFood> map = new HashMap<String, WastestreamFood>();
       List<String> wastestreamList=new ArrayList();
       for (WastestreamFood w:wsf)
       {
           wastestreamList.add(w.getWastestream());
            String key = w.getWastestream();
            if (!map.containsKey(key)) {
            map.put(key, w);
                                       }
       }
       Set<String> hs = new HashSet<String>();
             hs.addAll(wastestreamList);
             wastestreamList.clear();
             wastestreamList.addAll(hs);
       Collections.sort(wastestreamList);
       model.addAttribute("wastestreamList",wastestreamList);
       
        
            
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

PagedListHolder<WastestreamFood> pagedListHolder = new PagedListHolder<>(wsf2);
        pagedListHolder.setPageSize(10);
        model.addAttribute("maxPages", pagedListHolder.getPageCount());

        if(page==null || page < 1 || page > pagedListHolder.getPageCount())page=1;

         model.addAttribute("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
            model.addAttribute("result", pagedListHolder.getPageList());
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
             model.addAttribute("result", pagedListHolder.getPageList());
             
        }
  


		return "print";
	}
 

   
    @RequestMapping(value = "/table", method = RequestMethod.POST)
      public String table(@ModelAttribute("SpringWeb") Food f, Wastestream w,  BindingResult bindingResult, 
   
      ModelMap model, HttpServletRequest request,    
   @RequestParam(value = "wastestream", required=false) String wstream,
   @RequestParam(value = "compgroup", required=false) String cgr,
   @RequestParam(value = "cmp", required=false) String comp){
      
      
       
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
      model.addAttribute("wastestream", w.getWastestream());

      
     return "redirect:/table";
   }   
   
      
      @RequestMapping(value="/addWastestream", method=RequestMethod.POST)
public String addWastestream(@ModelAttribute("SpringWeb") Food f, Wastestream ws, WastreamPOSTClass w, BindingResult result, ModelMap model, HttpServletRequest request) {

    Food food=(Food)request.getAttribute("command1");
    String wastestream=request.getParameter("wastestream");
    String foodname=request.getParameter("foodname");
    String edible=request.getParameter("edible");
    String ncf=request.getParameter("ncf");
    String gcf=request.getParameter("gcf");
    String email=(String)request.getSession().getAttribute("email");
    request.getSession().setAttribute("email", email);
    String specgravity=request.getParameter("specgravity");
    Integer foodid=service.getFoodId(foodname);
//    if((wastestream.equals(""))||(edible.equals(""))||(ncf.equals(""))||(gcf.equals(""))||(specgravity.equals("")))
//    {
//    
//      model.addAttribute("command1",f);
//      model.addAttribute("command", ws);
//      model.addAttribute("foodname",foodname);
//      model.addAttribute("foodid", foodid);
//        int i=0;
//       List<Food> foodData=service.getDDFoods();
//       String foodList[]=new String[foodData.size()];
//       for(Food object:foodData)
//       {
//           foodList[i]=object.getFoodname();
//           i++;
//       }
//      model.addAttribute("foodList",foodList);
//      model.addAttribute("ErrorMessage", "Provide data");
//        return "print";
//    }


                model.addAttribute("foodname",f.getFoodname());
                model.addAttribute("addWastestream",w);
                model.addAttribute("edible",w.getEdible());
                model.addAttribute("wastestream",w.getWastestream());
                model.addAttribute("ncf",w.getNcf());
                model.addAttribute("gcf",w.getGcf());    
                model.addAttribute("specgravity",w.getSpecgravity());





return "redirect:/addWastestream";
    
}


      @RequestMapping(value="/editWastestream", method=RequestMethod.POST)
public String editWastestream(@ModelAttribute("SpringWeb") Food f, Wastestream ws, WastreamPOSTClass w, BindingResult result, ModelMap model, HttpServletRequest request) {

    Food food=(Food)request.getAttribute("command1");
    String foodname=request.getParameter("foodname");
    Wastestream ws1=(Wastestream)request.getAttribute("command");
    String wastestream=request.getParameter("wastestream");
    String edible=request.getParameter("edible");
    String ncf=request.getParameter("ncf");
    String gcf=request.getParameter("gcf");
    String specgravity=request.getParameter("specgravity");
    Integer foodid=service.getFoodId(foodname);
    String email=(String)request.getSession().getAttribute("email");
    request.getSession().setAttribute("email", email);
   

                String email1=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email1);
                model.addAttribute("editWastestream",w);
                model.addAttribute("wsid",w.getWsid());
                model.addAttribute("edible",w.getEdible());
                model.addAttribute("wastestream",w.getWastestream());
                model.addAttribute("ncf",w.getNcf());
                model.addAttribute("gcf",w.getGcf());
                model.addAttribute("specgravity",w.getSpecgravity());



return "redirect:/editWastestream";
    
}

@RequestMapping(value="/foodwasteHomeprint", method=RequestMethod.POST)
public String foodwasteHome(@ModelAttribute("SpringWeb") User u, BindingResult result, ModelMap model, HttpServletRequest request) {
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);
                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());


return "redirect:/foodwasteHome";
}

         @RequestMapping(value = "/editUserprint", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") foodwaste.domain.EditUser u1, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);



return "redirect:/editUser";
}

    }