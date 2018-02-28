
package foodwaste.web;
import foodwaste.domain.EditUser;
import foodwaste.domain.Food;
import foodwaste.domain.Wastestream;
import foodwaste.domain.Referencetype;
import foodwaste.domain.Unit;
import foodwaste.domain.User;
import foodwaste.domain.WsvaluePostClass;
import foodwaste.domain.WsvalueResult;
import foodwaste.service.Service;
import foodwaste.service.ServiceImpl;
import org.springframework.validation.BindingResult;
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
import java.util.Collections;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Tome
 */
@Controller("/about1")
public class About1Controller{
    
    protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
    
    public About1Controller(){
 
    }
    

   
//  @RequestMapping(value = "/foodwasteHome", method = RequestMethod.GET)
//   public ModelAndView foodwasteHome() {
//    	  
//          Food f=new Food();
//	  ModelAndView modelAndView = new ModelAndView("foodwasteHome", "command", f);
//         
//	  return modelAndView;
//   }
   
   @RequestMapping(value="/about1", method = RequestMethod.GET)
	public String about(ModelMap model, User u, HttpServletRequest request){
            Food food=new Food();
        model.addAttribute("command",food);
       String email=(String)request.getParameter("email");
       request.getSession().setAttribute("email", email);
 
     model.addAttribute("user",u);
     model.addAttribute("email",u.getEmail());
     EditUser u1=new EditUser();
     model.addAttribute("editUser",u1);
     model.addAttribute("email",u1.getEmail());
		return "about1";
	}
        
        
        
}