package com.creditcard;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.loaninfo.controller.CreditCardController;
import com.loaninfo.model.Abc;
import com.loaninfo.service.CreditCardServiceImpl;

@RunWith(SpringRunner.class)
public class CreditCardSystemMs2ApplicationTests {

	@Test
	public void loanRejectionTestCase() {

		CreditCardServiceImpl creditCardServiceImpl = new CreditCardServiceImpl();
		String ActualResult = "Loan Rejected - Rejected";
		assertEquals(creditCardServiceImpl.getLoanInfo("101"), ActualResult);
	}

	@Test
	public void loanApprovedTestCase() {

		CreditCardServiceImpl creditCardServiceImpl = new CreditCardServiceImpl();
		String ActualResult = "Loan Approved - SELECT";
		assertEquals(creditCardServiceImpl.getLoanInfo("102"), ActualResult);

	}

	@Test
	public void creditCardIdNotFoundTestCase() {

		CreditCardServiceImpl creditCardServiceImpl = new CreditCardServiceImpl();
		String ActualResult = "Credit Card Id Not Found - Rejected";
		assertEquals(creditCardServiceImpl.getLoanInfo("103"), ActualResult);

	}

}
