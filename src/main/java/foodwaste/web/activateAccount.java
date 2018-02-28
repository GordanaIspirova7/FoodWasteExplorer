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

@Controller("/activateUser")

public class activateAccount {
     protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public activateAccount(){
 
    }


// 
      @RequestMapping(value = "/activateUser", method = RequestMethod.GET)
	public String print(ModelMap model,User u1){
               
                model.addAttribute("activateUser",u1);
                model.addAttribute("verificationToken",u1.getVerificationToken());
                
                return "activateUser";
        }
        

   
}