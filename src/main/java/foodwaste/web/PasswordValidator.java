package foodwaste.web;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import foodwaste.domain.Areofinterest;
import foodwaste.domain.Country;
import foodwaste.domain.Food;
import foodwaste.domain.Institution;
import foodwaste.domain.Institutiontype;
import foodwaste.domain.User;
import foodwaste.domain.UserPostClass;
import foodwaste.service.ServiceImpl;
import foodwaste.dao.DAOImpl;
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
public class PasswordValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
			"required.password", "Field name is required.");

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
				"required.confirmPassword", "Field name is required.");

		User cust = (User)target;

//		if(!(cust.getPassword().equals(cust.getConfirmPassword()))){
//			errors.rejectValue("password", "notmatch.password");
//		}

	}

}