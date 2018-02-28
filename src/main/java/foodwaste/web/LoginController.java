/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;

import foodwaste.domain.Food;
import foodwaste.domain.User;
import foodwaste.domain.Wastestream;
import foodwaste.service.ServiceImpl;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tome
 */
@Controller("/login")
public class LoginController {
     private ServiceImpl service=new ServiceImpl();
 
// @RequestMapping(value = "/login", method = RequestMethod.GET)
//   public ModelAndView user() {
//     User u = new User();	  
//     Food f=new Food();
//	  ModelAndView modelAndView = new ModelAndView("login", "command", u);
//          modelAndView.addObject(f);
//	  return modelAndView;
//   }
   
       @RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(){
                ModelAndView model=new ModelAndView();
                User user=new User();
                model.addObject("user", user);
		return model;
	}
        
        
        
    
 @RequestMapping(value = "/loginNEW", method = RequestMethod.POST)
 public String loginNew(@ModelAttribute("SpringWeb")User user, BindingResult bindingResult, 
    ModelMap model, HttpServletRequest request) {    
    ServiceImpl service=new ServiceImpl();
    String email=user.getEmail();
    String message=service.login(user);
    if(message.equals("fail")||(email.equals(""))){
        
        model.addAttribute("email",user.getEmail());
        model.addAttribute("user",user);
        model.addAttribute("password",user.getPassword());
        model.addAttribute("ErrorMessage", "To use FoodWasteExplorer you need to be registered.");
        return "login";
        
    }
    else{
        String email1=(String)request.getSession().getAttribute("email");
        request.getSession().setAttribute("email", email1);
        model.addAttribute(new Food());
        model.addAttribute("email",user.getEmail());
        model.addAttribute("user",user);
        return "redirect:/foodwasteHome";
    }

} 
 

}
