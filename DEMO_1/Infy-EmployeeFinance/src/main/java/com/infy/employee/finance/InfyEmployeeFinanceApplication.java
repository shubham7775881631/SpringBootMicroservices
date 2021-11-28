package com.infy.employee.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:validation.properties")
public class InfyEmployeeFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyEmployeeFinanceApplication.class, args);
	}

}
