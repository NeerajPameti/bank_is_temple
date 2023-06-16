package com.nkxgen.spring.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.AccountApplication;
import com.nkxgen.spring.jdbc.model.AccountRepository;
import com.nkxgen.spring.jdbc.model.Accounts;
import com.nkxgen.spring.jdbc.model.AccountsDAO;
import com.nkxgen.spring.jdbc.model.Types;
import com.nkxgen.spring.jdbc.model.accountApplicationDAO;

@Controller
public class AccountController {
	@Autowired
	private accountApplicationDAO ac;
	@Autowired
	private AccountRepository rs;
	@Autowired
	private AccountsDAO l;

	@RequestMapping("/master_account")
	public String masterAccount(Model model) {
		return "account_master_entry";
	}

	@RequestMapping(value = "/New_account_application", method = RequestMethod.POST)
	// public String newAccountApplication(@Validated Types t, Model model) {
	// String value =t.gethrefvalue();
	// List<AccountApplication> list1 = ac.getAccountsappByType(value);
	//
	// model.addAttribute("list_of_account_applications", list1);
	// return "New_account_application";
	// }

	public String newAccountApplication(@Validated Types t, Model model) {
		String value = t.gethrefvalue();
		System.out.println("neeraj control mapping loki vachav " + value);
		List<AccountApplication> list1 = ac.getAccountsappByType(value);

		// Check if the list is not empty before accessing the first object
		if (!list1.isEmpty()) {
			AccountApplication firstAccount = list1.get(0);
			String acapActyId = firstAccount.getacap_acty_id();
			System.out.println("acap_acty_id of first object: " + acapActyId);
		}

		model.addAttribute("list_of_account_applications", list1);
		return "New_account_application";
	}

	@RequestMapping("/result")
	public String ne(Model model) {
		return "New_account_application";
	}

	// ===========================================================================================
	@RequestMapping("/Account_new_application_form")
	public String accountNewApplicationForm(Model model) {
		return "Account_new_application_form";
	}

	// ===========================================================================================
	@RequestMapping("/Any_Type_account_info")
	public String anyTypeAccountInfo(Model model) {
		return "Any_Type_account_info";
	}
	// ===========================================================================================

	@RequestMapping(value = "/account_application_save", method = RequestMethod.POST)
	public String accountApplicationSave(@Validated AccountApplication accountApplication, Model model) {
		System.out.println("hello");
		ac.save(accountApplication);
		return "Account_new_application_form";
	}
	// ===========================================================================================

	// @RequestMapping(value = "/view_the_newly_applications", method = RequestMethod.POST)
	// public String acc3(@Validated idvalue v, Model model) {
	// // id value should be get from the accountapplication.gettypeid();
	// String type = v.getValue();
	// List<AccountApplication> list1 = acco.getAccountsappByType(type);
	// model.addAttribute("list_of_account_applications", list1);
	// return "New_account_application";
	//
	// }

	// @RequestMapping(value = "/view_the_accounts", method = RequestMethod.POST)
	// public String acc3(@Validated idvalue v, Model model) {
	// // id value should be get from the accountapplication.gettypeid();
	// String type = v.getValue();
	// List<Account> list2 = acco.getAccountsByType(type);
	// model.addAttribute("list_of_account", list2);
	// return "Any_Type_account_info";
	//
	// }

	// ===================================================================================================
	@RequestMapping("/save_to_account_database")
	public String save_to_account_database(@Validated Account account, Model model) {
		ac.save1(account);
		// change the return
		return "Account_new_application_form";
	}

	// @RequestMapping("/save_to_account_documents_database")
	// public String save_to_account_documents_database(@Validated Accountdocument accountdocument, Model model) {
	// acco.save(accountdocument);
	// // change the return
	// return "Account_new_application_form";
	// }
	// // ======================================================================================================

	@RequestMapping(value = "/account_data_save", method = RequestMethod.POST)
	public String accountApplicationSave(Accounts accounts, Model model) {
		System.out.println("hello");
		rs.save(accounts);
		return "account_master_entry";
	}

	@RequestMapping(value = "/get_account_types", method = RequestMethod.GET)
	public String getAccounts(Model model) {
		List<Accounts> list = l.getAllAccounts();
		for (Accounts ll : list) {
			System.out.println(ll.getAccountType());
		}
		model.addAttribute("accounts", list);
		return "getaccounts";
	}

	/*
	 * @RequestMapping(value = "/get_loan_details", method = RequestMethod.GET) public String getLoanDetails(Model
	 * model) { List<Loans> list = l.getAllLoanDetails(); for (Loans ll : list) {
	 * System.out.println(ll.getDescriptionForm()); } model.addAttribute("loans", list); return "loandetails"; }
	 */

	@RequestMapping(value = "/get_selected_account_details", method = RequestMethod.GET)
	public String getSelectedAccountDetails(@RequestParam("accountType") int accountType, Model model) {

		System.out.println("get selected loan controller");
		List<Accounts> list = l.getSelectedAccountDetails(accountType);
		/*
		 * for (Loans ll : list) { System.out.println(ll.getDescriptionForm()); }
		 */
		model.addAttribute("accounts", list);
		return "accountdetails";
	}

}
