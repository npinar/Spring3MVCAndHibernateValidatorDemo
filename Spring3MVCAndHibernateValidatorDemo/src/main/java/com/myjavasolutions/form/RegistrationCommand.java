package com.myjavasolutions.form;

import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class RegistrationCommand {

	//validation rule annotations are added to data members
	//see Hibernate Validator documentation for more validators
	@NotEmpty(message="please enter your first name")
	private String firstname;
	
	@NotEmpty(message="please enter your last name")
	private String lastname;
	
	@NotEmpty(message="please enter your email address")
	@Email
	private String email;
	
	@Size(min = 10, max=14, message="phone number has to be minumum 10 digits, but no more than 14")
	private String telephone;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
