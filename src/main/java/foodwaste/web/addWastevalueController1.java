/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;

import foodwaste.domain.Compgroup;
import foodwaste.domain.Component;
import foodwaste.domain.ComponentList;
import foodwaste.domain.User;
import foodwaste.domain.EditUser;
import foodwaste.domain.Food;
import foodwaste.domain.Wastestream;
import foodwaste.domain.WsvaluePostAdd;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvalueResult;
import foodwaste.service.ServiceImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
@Controller("/addWastevalue1")
public class addWastevalueController1 {
    
 protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public addWastevalueController1(){
 
    }


// 
      @RequestMapping(value = "/addWastevalue1", method = RequestMethod.GET)
	public String addWastevalue(ModelMap model, WsvaluePostAdd w, HttpServletRequest request){
               
                User u=new User();
                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                model.addAttribute("addWastevalue",w);
                model.addAttribute("value",w.getValue());
                model.addAttribute("uftc",w.getUftc());
                model.addAttribute("citation",w.getCitation());
                model.addAttribute("compid",w.getCompid());
                model.addAttribute("wastestream",w.getWastestream());
                Component c=new Component();
                model.addAttribute("component",c);
                String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      foodwaste.domain.EditUser u1=new foodwaste.domain.EditUser();
      model.addAttribute("editUser",u1);
      model.addAttribute("email",u1.getEmail());
                return "addWastevalue1";
        }
        
        
                
        @RequestMapping(value="/foodwasteHomeaddWastevalue1", method=RequestMethod.POST)
public String foodwasteHome(@ModelAttribute("SpringWeb") User u, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);

return "redirect:/foodwasteHome";
}

               @RequestMapping(value = "/editUseraddWastevalue1", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") EditUser u1, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);



return "redirect:/editUser";
}
  
   @RequestMapping(value = "/componentHome2", method = RequestMethod.POST)
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
  
        
}
