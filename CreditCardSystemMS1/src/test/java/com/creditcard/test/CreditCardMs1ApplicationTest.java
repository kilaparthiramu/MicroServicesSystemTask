package com.creditcard.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.creditcard.controller.CreditCardController;
import com.creditcard.model.CreditCardRequest;
import com.creditcard.model.CreditCardResponse;
import com.creditcard.service.CreditCardServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class CreditCardMs1ApplicationTest {

	private MockMvc mockMvc;

	@InjectMocks
	private CreditCardController creditCardController;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(creditCardController).build();
	}
	
	@Test
	public void ageBelowTestCase() {
		
		CreditCardServiceImpl creditCardServiceImpl = new CreditCardServiceImpl();
		String ActualResult = "Customer Age between 20 to 60years - Rejected";
		
		CreditCardRequest creditCardRequest = new CreditCardRequest();
		creditCardRequest.setCardId("102");
		creditCardRequest.setCardName("Rama");
		creditCardRequest.setAge(19);
		assertEquals(creditCardServiceImpl.retrieveCreditCardInfo(creditCardRequest).getMessage(), ActualResult);
	}
	
	@Test
	public void ageAboveTestCase() {
		
		CreditCardServiceImpl creditCardServiceImpl = new CreditCardServiceImpl();
		String ActualResult = "Customer Age between 20 to 60years - Rejected";
		
		CreditCardRequest creditCardRequest = new CreditCardRequest();
		creditCardRequest.setCardId("102");
		creditCardRequest.setCardName("Rama");
		creditCardRequest.setAge(69);
		assertEquals(creditCardServiceImpl.retrieveCreditCardInfo(creditCardRequest).getMessage(), ActualResult);
	}
	

	@Test
	public void readCreditCardInfoTest() throws Exception {

		CreditCardRequest creditCardRequest = new CreditCardRequest();
		creditCardRequest.setCardId("102");
		creditCardRequest.setCardName("Rama");
		creditCardRequest.setAge(45);

		CreditCardServiceImpl creditCardService = new CreditCardServiceImpl();
		
		String exampleCourseJson = "{\"cardId\":\"101\",\"cardName\":\"Rama\",\"age\":\"45\"}";

		CreditCardResponse creditCardResponse = new CreditCardResponse();
		creditCardResponse.setMessage("Loan Approved - SELECT");
		Mockito.when(creditCardService.retrieveCreditCardInfo(Mockito.any(CreditCardRequest.class)))
				.thenReturn(creditCardResponse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/creditcard").accept(MediaType.APPLICATION_JSON)
				.content(exampleCourseJson).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		System.out.println(response.getContentAsString());

	}
}