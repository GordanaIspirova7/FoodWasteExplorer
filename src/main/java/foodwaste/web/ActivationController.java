/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;

import foodwaste.domain.User;
import foodwaste.domain.UserPostClass;
import foodwaste.service.ServiceImpl;
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

@Controller("/activation")

public class ActivationController {
     protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public ActivationController(){
 
    }


// 
      @RequestMapping(value = "/activation", method = RequestMethod.GET)
	public String activation(ModelMap model){
                User u1=new User();
                model.addAttribute("activateUser",u1);
                model.addAttribute("verificationToken",u1.getVerificationToken());
                
                return "activation";
        }
        
         @RequestMapping(value = "/activateUser1", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") User u1, BindingResult result, ModelMap model) {

                model.addAttribute("activateUser",u1);
                model.addAttribute("verificationToken",u1.getVerificationToken());
              



return "redirect:/activateUser";
}
   
}