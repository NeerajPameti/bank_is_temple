package com.nkxgen.spring.jdbc.controller;




import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class neerajController {
	


	@RequestMapping(value = "/master_loan", method = RequestMethod.GET)
	public String master_loan(Model model) {

		return "loan_master_entry";

	}
	
	@RequestMapping(value = "/permission_management", method = RequestMethod.GET)
	public String permission_management(Model model) {

		return "Permission_management";

	}
	
	@RequestMapping(value = "/loan_new_application_form", method = RequestMethod.GET)
	public String loan_new_application_form(Model model) {
		return "loan_new_application_form";
	}
	
	@RequestMapping(value = "/New_loan_application", method = RequestMethod.GET)
	public String New_loan_application(Model model) {
		return "New_loan_application";
	}
	
	
}
