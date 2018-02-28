/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;

import foodwaste.domain.EditUser;
import foodwaste.service.ServiceImpl;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author gorda
 */
@Controller("/userEdited")

public class userEdited {
     protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public userEdited(){
 
    }


// 
      @RequestMapping(value = "/userEdited", method = RequestMethod.GET)
	public String print(ModelMap model, EditUser u, HttpServletRequest request){
               
              
             model.addAttribute("userEdited",u);
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);
                model.addAttribute("name",u.getName());
                model.addAttribute("surname",u.getSurname());
                model.addAttribute("email",u.getEmail());
                model.addAttribute("password",u.getPassword());
                model.addAttribute("oldPassword",u.getOldPassword());
                model.addAttribute("confPassword",u.getConfPassword());
                
                
                return "userEdited";
        }
        

}