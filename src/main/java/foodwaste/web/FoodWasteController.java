/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;

import foodwaste.domain.EditUser;
import foodwaste.domain.Food;
import foodwaste.domain.User;
import foodwaste.domain.Matrix;
import foodwaste.domain.Wastestream;
import foodwaste.domain.Referencetype;
import foodwaste.domain.Unit;
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
@Controller("/foodwasteHome")
public class FoodWasteController{
    
    protected final Log logger = LogFactory.getLog(getClass()); 

    
    private ServiceImpl service=new ServiceImpl();
    
    public FoodWasteController(){
 
    }
    

   
//  @RequestMapping(value = "/foodwasteHome", method = RequestMethod.GET)
//   public ModelAndView foodwasteHome() {
//    	  
//          Food f=new Food();
//	  ModelAndView modelAndView = new ModelAndView("foodwasteHome", "command", f);
//         
//	  return modelAndView;
//   }
   
   @RequestMapping(value="/foodwasteHome", method = RequestMethod.GET)
	public String foodwasteHome(ModelMap model, User u, HttpServletRequest request){
            Food food=new Food();
        model.addAttribute("command",food);
       String email=(String)request.getParameter("email");
       request.getSession().setAttribute("email", email);
       List<Food> foodData=service.getDDFoods();
       List<String> foodList=new ArrayList();
       for(Food object:foodData)
       {
           foodList.add(object.getFoodname());
           
       }
       Collections.sort(foodList);
     model.addAttribute("foodList",foodList);
     model.addAttribute("user",u);
     model.addAttribute("email",u.getEmail());
     EditUser u1=new EditUser();
     model.addAttribute("editUser",u1);
     model.addAttribute("email",u1.getEmail());
		return "foodwasteHome";
	}

// @RequestMapping(value = "/print", method = RequestMethod.POST)
// public String print(@ModelAttribute("SpringWeb")Food food, 
//    ModelMap model) {    
//    model.addAttribute("foodname", food.getFoodname());
//    model.addAttribute("foodid", food.getFoodid());
//    
//    return "print";
//
//
//}
//  
//  @ModelAttribute("foodid")
//  public int setFoodId(@ModelAttribute("SpringWeb")Food food){
//      return food.getFoodid();
//  }
//  


 

// @RequestMapping(value = "/print", method = RequestMethod.POST)
// public String print(@ModelAttribute("SpringWeb")Food food, 
//    ModelMap model) {    
//    model.addAttribute("foodname", food.getFoodname());
//    model.addAttribute("foodid", food.getFoodid());
//    
//    return "print";
//
//
//}


 
    
//    @RequestMapping(value = "/print",method = RequestMethod.POST)
//    public ModelAndView print() {
//    
//          Food f=new Food();
//	  ModelAndView modelAndView = new ModelAndView("print", "command", f);
//       
//	  return modelAndView;
//   }
    
    
    @RequestMapping(value = "/print", method = RequestMethod.POST)
      public String print(@ModelAttribute("SpringWeb")Food f, User u, BindingResult bindingResult, 
   
   ModelMap model, HttpServletRequest request) {
      Wastestream w = new Wastestream();
      model.addAttribute("user",u);
     model.addAttribute("email",u.getEmail());
      String email=(String)request.getSession().getAttribute("email");
      request.getSession().setAttribute("email", email);
      String foodname=(String)request.getSession().getAttribute("foodname");
      request.getSession().setAttribute("foodname", foodname);
      model.addAttribute("foodname", f.getFoodname());
      
      model.addAttribute(w);
      model.addAttribute(f);
      
      model.addAttribute("id", f.getFoodid());
   

      return "redirect:/print";
   }


         @RequestMapping(value = "/editUser", method = RequestMethod.POST)
  public String activateUser(@ModelAttribute("SpringWeb") EditUser u1, BindingResult result, ModelMap model, HttpServletRequest request) {

                model.addAttribute("editUser",u1);
                model.addAttribute("email",u1.getEmail());
                String email=(String)request.getSession().getAttribute("email");
                request.getSession().setAttribute("email", email);



return "redirect:/editUser";
}

  
}

    
