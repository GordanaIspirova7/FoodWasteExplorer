
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



@Controller("/changePassword")

public class ChangePasswordController {
     protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public ChangePasswordController(){
 
    }


// 
      @RequestMapping(value = "/changePassword", method = RequestMethod.GET)
	public String print(ModelMap model, User u){
               
              
                model.addAttribute("changePassword",u);
                model.addAttribute("email",u.getEmail());
                
                
                return "changePassword";
        }
        
        
         @RequestMapping(value = "/changePassword1", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") User u1, BindingResult result, ModelMap model) {

                model.addAttribute("changePassword",u1);
                model.addAttribute("email",u1.getEmail());
return "redirect:/changePassword1";
}
        
}