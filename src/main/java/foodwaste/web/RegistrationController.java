/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwaste.web;

import foodwaste.domain.Areofinterest;
import foodwaste.domain.Country;
import foodwaste.domain.Food;
import foodwaste.domain.Institution;
import foodwaste.domain.Institutiontype;
import foodwaste.domain.User;
import foodwaste.domain.UserPostClass;
import foodwaste.service.ServiceImpl;
import foodwaste.dao.DAOImpl;
import foodwaste.domain.ConfirmPassword;
import foodwaste.domain.WastreamPOSTClass;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Tome
 */
@Controller("/registration")
public class RegistrationController {
    
     private ServiceImpl service=new ServiceImpl();
     @RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(ModelMap model){
       
       ConfirmPassword u=new ConfirmPassword();
       
       
       model.addAttribute("registration",u);
       
       
    

	 
       return "registration";
   }
   
   
   @ModelAttribute("areaList")
   public Map<String, String> getAreaList()
   {
      Map<String, String> areaList = new HashMap<String, String>();
      List<Areofinterest> areaData=service.getDDAreofinterest();
     
      for(Areofinterest object : areaData){
          areaList.put(object.getInterestarea(),object.getInterestarea());
      }
      return areaList;
   }
   
    @ModelAttribute("institutionList")
   public Map<String, String> getInstitutionList()
   {
      Map<String, String> institutionList = new HashMap<String, String>();
      List<Institution> institutionData=service.getDDInstitution();
     
      for(Institution object : institutionData){
          institutionList.put(object.getInsname(),object.getInsname());
      }
      return institutionList;
   }
    @ModelAttribute("institutiontypeList")
   public Map<String, String> getInstitutiontypeList()
   {
      Map<String, String> institutiontypeList = new HashMap<String, String>();
      List<Institutiontype> institutiontypeData=service.getDDInstitutiontype();
     
      for(Institutiontype object : institutiontypeData){
          institutiontypeList.put(object.getInsttype(),object.getInsttype());
      }
      return institutiontypeList;
   }
     @ModelAttribute("countryList")
   public Map<String, String> getCountryList()
   {
      Map<String, String> countryList = new HashMap<String, String>();
      List<Country> countryData=service.getDDCountry();
     
      for(Country object : countryData){
          countryList.put(object.getCountrycode(),object.getCountrycode());
      }
      return countryList;
   }
   
 @RequestMapping(value = "/registrationNEW", method = RequestMethod.POST)
  public String register(@ModelAttribute("SpringWeb") ConfirmPassword u, BindingResult bindingResult, 
    ModelMap model, HttpServletRequest request) {

                if(u.getPassword().equals(u.getconfPassword()))
                {
                    
               
                model.addAttribute("registration",u);
                model.addAttribute("name",u.getName());
                model.addAttribute("surname",u.getSurname());
                model.addAttribute("email",u.getEmail());
                model.addAttribute("password",u.getPassword());
                model.addAttribute("interestarea",u.getInterestarea());
                model.addAttribute("insname",u.getInsname());
                model.addAttribute("insttype",u.getInsttype());
                model.addAttribute("countrycode",u.getCountrycode());
                model.addAttribute("confPassword",u.getconfPassword());
                return "redirect:/registrationNEW";
                }
                else
                {
                model.addAttribute("ErrorMessage", "Password does not match the confirm password!");
                model.addAttribute("ErrorMessage1", "!");
                model.addAttribute("registration",u);
                model.addAttribute("name",u.getName());
                model.addAttribute("surname",u.getSurname());
                model.addAttribute("email",u.getEmail());
                model.addAttribute("password","");
                model.addAttribute("interestarea",u.getInterestarea());
                model.addAttribute("insname",u.getInsname());
                model.addAttribute("insttype",u.getInsttype());
                model.addAttribute("countrycode",u.getCountrycode());
                model.addAttribute("confPassword","");
                return "registration";
                
                }
                




}

}
