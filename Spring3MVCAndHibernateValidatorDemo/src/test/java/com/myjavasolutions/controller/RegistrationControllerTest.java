package com.myjavasolutions.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.myjavasolutions.controller.RegistrationController;
import com.myjavasolutions.form.RegistrationCommand;

public class RegistrationControllerTest {

	private RegistrationController registrationController;
	private ModelMap modelMap;
	
	@Before
	public void setup() {
		 registrationController = new RegistrationController();
		 modelMap = new ModelMap();
	}
	
	@Test
	public void setupForm() {
		
		String expectedViewName = "registration";
		String actualViewName = registrationController.setupForm(modelMap);
		
		assertEquals(expectedViewName, actualViewName);
		assertEquals(((RegistrationCommand)modelMap.get("registration")).getFirstname(), null);
		assertEquals(((RegistrationCommand)modelMap.get("registration")).getLastname(), null);
		assertEquals(((RegistrationCommand)modelMap.get("registration")).getTelephone(), null);
		assertEquals(((RegistrationCommand)modelMap.get("registration")).getEmail(), null);		
	}
	
	@Test
	public void addContact_with_no_validation_errors() {
		
		String expectedViewName = "thankyou";
		
		RegistrationCommand registrationCommand = new RegistrationCommand();
		registrationCommand.setFirstname("nev");
		
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(false);
		String actualViewName = registrationController.addContact(registrationCommand, bindingResult, modelMap);
		assertEquals(expectedViewName, actualViewName);
	}
	
	@Test
	public void addContact_with_validation_errors() {
		
		String expectedViewName = "registration";
		
		RegistrationCommand registrationCommand = new RegistrationCommand();
		registrationCommand.setFirstname("nev");
		
		BindingResult bindingResult = mock(BindingResult.class);
		when(bindingResult.hasErrors()).thenReturn(true);
		String actualViewName = registrationController.addContact(registrationCommand, bindingResult, modelMap);
		assertEquals(expectedViewName, actualViewName);
	}
}
