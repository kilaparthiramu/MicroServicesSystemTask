package com.loaninfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.loaninfo.service.CreditCardService;

@RestController
public class CreditCardController {
	
	@Autowired
	CreditCardService creditCardService;

	@RequestMapping(value = "/creditcard/{id}", method = RequestMethod.GET)
	public ResponseEntity<String> readLoanInfo(@PathVariable("id") String id) {
		String response = creditCardService.getLoanInfo(id);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
