package com.nkxgen.spring.jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.jdbc.model.Customer;
import com.nkxgen.spring.jdbc.model.CustomerDao;
import com.nkxgen.spring.jdbc.model.Customertrail;
import com.nkxgen.spring.jdbc.model.service;

@Controller
public class customercontroller {
	@Autowired
	private CustomerDao customer1;

	@RequestMapping(value = "/customer_data_trail_save", method = RequestMethod.POST)
	public String customer_data_trail_save(@Validated Customertrail customer, Model model) {
		customer1.save_trail(customer);
		return "Account_new_application_form";
	}

	// =================================================
	// real saving
	@RequestMapping(value = "/save_to_customer_database", method = RequestMethod.POST)
	public String save_to_customer_database(@RequestParam("CustomerId") Long customerId) {
		long customerid = customerId;
		System.out.println(customerid);
		Customertrail cus = customer1.getCustomerById(customerid);
		Customer customer = service.dotheservice(cus);
		customer1.save(customer);
		// change the return
		return "Account_new_application_form";
	}

}
