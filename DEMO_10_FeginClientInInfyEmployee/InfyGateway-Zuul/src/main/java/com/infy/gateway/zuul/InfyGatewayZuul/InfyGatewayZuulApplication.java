package com.infy.gateway.zuul.InfyGatewayZuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class InfyGatewayZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyGatewayZuulApplication.class, args);
	}

}
