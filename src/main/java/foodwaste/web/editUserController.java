
package foodwaste.web;

import foodwaste.domain.EditUser;
import foodwaste.domain.User;
import foodwaste.domain.UserPostClass;
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



@Controller("/editUser")

public class editUserController {
     protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public editUserController(){
 
    }


// 
      @RequestMapping(value = "/editUser", method = RequestMethod.GET)
	public String print(ModelMap model, EditUser u, HttpServletRequest request){
               
              
                model.addAttribute("editUser",u);
                
                model.addAttribute("email",u.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);
                model.addAttribute("userEdited",u);
                
                return "editUser";
        }
        
        
        @RequestMapping(value = "/userEdited", method = RequestMethod.POST)
  public String edited(@ModelAttribute("SpringWeb") EditUser u, BindingResult bindingResult, 
    ModelMap model, HttpServletRequest request) {

                if(u.getPassword().equals(u.getConfPassword()))
                {
                
                model.addAttribute("userEdited",u);
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);
                model.addAttribute("name",u.getName());
                model.addAttribute("surname",u.getSurname());
                model.addAttribute("email",u.getEmail());
                model.addAttribute("password",u.getPassword());
                model.addAttribute("oldPassword",u.getOldPassword());
                model.addAttribute("confPassword",u.getConfPassword());
                return "redirect:/userEdited";
                }
                else
                {
                model.addAttribute("ErrorMessage", "Password does not match the confirm password!");
                model.addAttribute("ErrorMessage1", "!");
                model.addAttribute("editUser",u);
                model.addAttribute("name",u.getName());
                model.addAttribute("surname",u.getSurname());
                model.addAttribute("email",u.getEmail());
                model.addAttribute("password","");
                model.addAttribute("confPassword","");
                model.addAttribute("oldPassword",u.getOldPassword());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);
                model.addAttribute("userEdited",u);
                return "editUser";
                
                }
                
        
        

  }    
}