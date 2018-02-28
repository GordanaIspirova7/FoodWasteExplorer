/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;

import foodwaste.domain.User;
import foodwaste.domain.EditUser;
import foodwaste.domain.WsvaluePostAdd;
import foodwaste.service.ServiceImpl;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gorda
 */
@Controller("/addWastevalue")
public class addWastevalueController {
    
 protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public addWastevalueController(){
 
    }


// 
      @RequestMapping(value = "/addWastevalue", method = RequestMethod.GET)
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
                String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      foodwaste.domain.EditUser u1=new foodwaste.domain.EditUser();
      model.addAttribute("editUser",u1);
      model.addAttribute("email",u1.getEmail());
                return "addWastevalue";
        }
        
        
                
        @RequestMapping(value="/foodwasteHomeaddWastevalue", method=RequestMethod.POST)
public String foodwasteHome(@ModelAttribute("SpringWeb") User u, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);

return "redirect:/foodwasteHome";
}

               @RequestMapping(value = "/editUseraddWastevalue", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") EditUser u1, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);



return "redirect:/editUser";
}
        
}
