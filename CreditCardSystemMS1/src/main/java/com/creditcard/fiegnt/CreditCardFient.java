package com.creditcard.fiegnt;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="loan-service" , url="http://localhost:1972")
public interface CreditCardFient {
	
	@RequestMapping(value="/creditcard/{id}", method = RequestMethod.GET)
	public String getLaonInfo(@PathVariable("id") String id);

}
