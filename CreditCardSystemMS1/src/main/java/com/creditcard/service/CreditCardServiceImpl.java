package com.creditcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.fiegnt.CreditCardFient;
import com.creditcard.model.CreditCardRequest;
import com.creditcard.model.CreditCardResponse;

@Service
public class CreditCardServiceImpl implements CreditCardService{

	@Autowired
	CreditCardFient creditCardFient;

	public CreditCardResponse retrieveCreditCardInfo(CreditCardRequest creditCardRequest) {
		
		System.out.println(creditCardRequest.getAge()+"...."+creditCardRequest.getClass());
		
		CreditCardResponse creditCardResponse = new CreditCardResponse();
		if (creditCardRequest.getAge() >= 20 && creditCardRequest.getAge() <= 60) {
			creditCardResponse.setMessage(creditCardFient.getLaonInfo(creditCardRequest.getCardId()));
			return creditCardResponse;
		} else {
			creditCardResponse.setMessage("Customer Age between 20 to 60years - Rejected");
			return creditCardResponse;
		}
	}
}
