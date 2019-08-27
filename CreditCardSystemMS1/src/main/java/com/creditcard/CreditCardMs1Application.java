package com.creditcard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CreditCardMs1Application {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardMs1Application.class, args);
	}

}
