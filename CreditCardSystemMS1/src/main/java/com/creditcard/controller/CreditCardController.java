package com.creditcard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.model.CreditCardRequest;
import com.creditcard.model.CreditCardResponse;
import com.creditcard.service.CreditCardService;

@RestController
public class CreditCardController {

	@Autowired
	CreditCardService creditCardService;

	@PostMapping(path = "/creditcard")
	public ResponseEntity<Object> readCreditCardInfo(@RequestBody CreditCardRequest creditCardRequest) throws Exception {
		CreditCardResponse creditCardResponse =  creditCardService.retrieveCreditCardInfo(creditCardRequest);
		return new ResponseEntity<Object>(creditCardResponse, HttpStatus.OK);

	}
}
