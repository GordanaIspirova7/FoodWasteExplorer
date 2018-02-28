
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



@Controller("/changePassword1")

public class changePassword1 {
     protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public changePassword1(){
 
    }


// 
      @RequestMapping(value = "/changePassword1", method = RequestMethod.GET)
	public String print(ModelMap model, User u){
               
              
                model.addAttribute("changePassword",u);
                model.addAttribute("email",u.getEmail());
                
                
                return "changePassword1";
        }
        
        

        
}