package com.nkxgen.spring.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.jdbc.model.Loans;
import com.nkxgen.spring.jdbc.model.LoansDAO;
import com.nkxgen.spring.jdbc.model.LoansRepository;

@Controller
public class LoanController {
	@Autowired
	private LoansRepository rs;
	@Autowired
	private LoansDAO l;

	@RequestMapping(value = "/loan_data_save", method = RequestMethod.POST)
	public String loanApplicationSave(Loans loans, Model model) {
		System.out.println("hello");
		rs.save(loans);
		return "loan_master_entry";
	}

	@RequestMapping(value = "/get_loan_types", method = RequestMethod.GET)
	public String getLoans(Model model) {
		List<Loans> list = l.getAllLoans();
		for (Loans ll : list) {
			System.out.println(ll.getLoanType());
		}
		model.addAttribute("loans", list);
		return "getloans";
	}

	/*
	 * @RequestMapping(value = "/get_loan_details", method = RequestMethod.GET) public String getLoanDetails(Model
	 * model) { List<Loans> list = l.getAllLoanDetails(); for (Loans ll : list) {
	 * System.out.println(ll.getDescriptionForm()); } model.addAttribute("loans", list); return "loandetails"; }
	 */

	@RequestMapping(value = "/get_selected_loan_details", method = RequestMethod.GET)
	public String getSelectedLoanDetails(@RequestParam("loanType") int loanType, Model model) {

		// System.out.println("get selected loan controller");
		List<Loans> list = l.getSelectedLoanDetails(loanType);
		/*
		 * for (Loans ll : list) { System.out.println(ll.getDescriptionForm()); }
		 */
		model.addAttribute("loans", list);
		return "loandetails";
	}

}
