/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;


import foodwaste.domain.User;
import foodwaste.domain.WastreamPOSTClass;
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

@Controller("/editWastestream")

public class editWastestreamContoller {
     protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
 
 public editWastestreamContoller(){
 
    }


// 
      @RequestMapping(value = "/editWastestream", method = RequestMethod.GET)
	public String editWastestream(ModelMap model,WastreamPOSTClass w, HttpServletRequest request){
     User u=new User();
                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
            String wastestreamname=(String)request.getAttribute("wastestream");
     Integer wsid=service.getWastestreamId(wastestreamname);
     String edible=(String)request.getAttribute("edible");
     Double gcf=(Double)request.getAttribute("gcf");
     Double ncf=(Double)request.getAttribute("ncf");
     Double specgravity=(Double)request.getAttribute("specgravity");
    
                model.addAttribute("editWastestream",w);
                model.addAttribute("wsid",w.getWsid());
                model.addAttribute("edible",w.getEdible());
                model.addAttribute("wastestream",w.getWastestream());
                model.addAttribute("ncf",w.getNcf());
                model.addAttribute("gcf",w.getGcf());
                model.addAttribute("specgravity",w.getSpecgravity());
                String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      foodwaste.domain.EditUser u1=new foodwaste.domain.EditUser();
      model.addAttribute("editUser",u1);
      model.addAttribute("email",u1.getEmail());
                return "editWastestream";
        }
                @RequestMapping(value="/foodwasteHomeeditWastestream", method=RequestMethod.POST)
public String foodwasteHome(@ModelAttribute("SpringWeb") User u, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("user",u);
                model.addAttribute("email",u.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);

return "redirect:/foodwasteHome";
}

               @RequestMapping(value = "/editUsereditWastestream", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") foodwaste.domain.EditUser u1, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);



return "redirect:/editUser";
}
}