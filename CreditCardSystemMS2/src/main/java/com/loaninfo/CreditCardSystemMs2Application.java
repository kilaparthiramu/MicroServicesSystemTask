package com.loaninfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.loaninfo.*")
public class CreditCardSystemMs2Application {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardSystemMs2Application.class, args);
	}

}
