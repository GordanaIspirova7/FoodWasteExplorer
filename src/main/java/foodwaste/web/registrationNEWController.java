
package foodwaste.web;

import foodwaste.domain.ConfirmPassword;
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



@Controller("/registrationNEW")

public class registrationNEWController {
     protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public registrationNEWController(){
 
    }


// 
      @RequestMapping(value = "/registrationNEW", method = RequestMethod.GET)
	public String registrationNEW(ModelMap model, ConfirmPassword u){
               
                User u1=new User();
                model.addAttribute("registration",u);
                model.addAttribute("name",u.getName());
                model.addAttribute("surname",u.getSurname());
                model.addAttribute("email",u.getEmail());
                model.addAttribute("password",u.getPassword());
                model.addAttribute("interestarea",u.getInterestarea());
                model.addAttribute("insname",u.getInsname());
                model.addAttribute("insttype",u.getInsttype());
                model.addAttribute("countrycode",u.getCountrycode());
                model.addAttribute("activateUser",u1);
                model.addAttribute("verificationToken",u1.getVerificationToken());
                model.addAttribute("confPassword",u.getconfPassword());
                return "registrationNEW";
        }
        
        
         @RequestMapping(value = "/activateUser", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") User u1, BindingResult result, ModelMap model) {

                model.addAttribute("activateUser",u1);
                model.addAttribute("verificationToken",u1.getVerificationToken());
              



return "redirect:/activateUser";
}
        
}