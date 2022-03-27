package com.infy.employee.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:validation.properties")
@EnableEurekaClient
public class InfyEmployeeFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyEmployeeFinanceApplication.class, args);
	}

}
