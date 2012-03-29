package com.myjavasolutions.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myjavasolutions.form.RegistrationCommand;
 
/**
 * This controller class shows the basic concepts of the spring 3 mvc features. 
 * @author npinar
 *
 */
@Controller
public class RegistrationController {
 
	/**
	 * 
	 * @param registrationCommand
	 * 		contains submitted data
	 * @param result
	 * 		contains errors of submitted data
	 * @param model
	 * 		model to prepare data for view
	 * @return
	 * 		display thankyou.jsp
	 */
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("registration") @Valid RegistrationCommand registrationCommand, BindingResult result, ModelMap model) {
    	
    	if(result.hasErrors()) {
    		
    		return "registration";
    	}
 
    	//do not do this in production code. this is just to show how to add data to model.
    	model.addAttribute("welcome", "Welcome and thank you for registering with us.");
    	
    	//do not return hard coded strings in production code.
        return "thankyou";
    }
 
    /*
     * This method displays empty form when user refreshes the index.jsp page
     */
    @RequestMapping(value="/register", method = RequestMethod.GET)
    public String setupForm(ModelMap model) {

    	RegistrationCommand registrationCommand =  new RegistrationCommand();
    	//registration object will be available in view page.
    	model.addAttribute("registration", registrationCommand);
    	
        return "registration";
      
    }
}
