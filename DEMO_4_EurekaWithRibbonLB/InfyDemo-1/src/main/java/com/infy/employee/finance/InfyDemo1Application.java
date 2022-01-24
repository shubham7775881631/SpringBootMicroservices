package com.infy.employee.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class InfyDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(InfyDemo1Application.class, args);
	}

}
