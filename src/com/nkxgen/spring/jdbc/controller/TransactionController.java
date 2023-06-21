package com.nkxgen.spring.jdbc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;;

@Controller
public class TransactionController {

	// ================================================================================================================================

	@RequestMapping(value = "/moneydeposit", method = RequestMethod.GET)
	public String money(Model model) {
		return "Money_Deposit";
	}

	@RequestMapping(value = "/loanrepay", method = RequestMethod.GET)
	public String loan(Model model) {
		return "Loan_Repayment";
	}

	@RequestMapping(value = "/interest", method = RequestMethod.GET)
	public String interest(Model model) {
		return "Interest_Deposit";
	}

	@RequestMapping(value = "/withdrawl", method = RequestMethod.GET)
	public String moneywid(Model model) {
		return "money_withdrawl_form";
	}

	@RequestMapping(value = "/lowid", method = RequestMethod.GET)
	public String lowid(Model model) {
		return "loan_withdrawl_form";
	}
	// =============================================================================

	// ===========================================================================

}