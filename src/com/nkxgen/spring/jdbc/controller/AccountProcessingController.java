package com.nkxgen.spring.jdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nkxgen.spring.jdbc.model.AccountProcessingDAO;
import com.nkxgen.spring.jdbc.model.InterestCal;

@Controller
public class AccountProcessingController {

	@Autowired
	private AccountProcessingDAO interestCalDao;

	@GetMapping("interesturl")
	public String calculate() {
		return "interest";
	}

	@PostMapping("/calculate")
	@ResponseBody
	public ResponseEntity<String> calculateInterest(@RequestParam("acctype") String acctype, Model model) {
		List<InterestCal> interestCalList = interestCalDao.getSavAcc(acctype);
		model.addAttribute("interestCal", interestCalList);
		System.out.println(interestCalList);
		return ResponseEntity.ok(" updated successfully");
	}
}
