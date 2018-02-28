/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;

import foodwaste.domain.User;
import foodwaste.domain.WsvaluePostClass;
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
@Controller("/deleteWastevalue1")
public class deleteWastevalue1 {
    
 protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public deleteWastevalue1(){
 
    }


// 
      @RequestMapping(value = "/deleteWastevalue1", method = RequestMethod.GET)
	public String deleteWastevalue(ModelMap model, WsvaluePostClass w, HttpServletRequest request){
               
                   User u=new User();
                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                model.addAttribute("valueid",w.getValueid());

String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      foodwaste.domain.EditUser u1=new foodwaste.domain.EditUser();
      model.addAttribute("editUser",u1);
      model.addAttribute("email",u1.getEmail());
return "deleteWastevalue1";
        }
        
        
        @RequestMapping(value="/foodwasteHomedeleteWastevalue1", method=RequestMethod.POST)
public String foodwasteHome(@ModelAttribute("SpringWeb")  BindingResult result, ModelMap model, HttpServletRequest request) {
               User u=new User();
                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);

return "redirect:/foodwasteHome";
}
               @RequestMapping(value = "/editUserdeleteWastevalue1", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") foodwaste.domain.EditUser u1, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);



return "redirect:/editUser";
}
}

