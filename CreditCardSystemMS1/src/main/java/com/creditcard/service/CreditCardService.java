package com.creditcard.service;

import com.creditcard.model.CreditCardRequest;
import com.creditcard.model.CreditCardResponse;

public interface CreditCardService {
	
	CreditCardResponse retrieveCreditCardInfo(CreditCardRequest creditCardRequest);

}
