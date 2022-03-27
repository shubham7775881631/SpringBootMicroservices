package com.infy.zipin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class InfyZipkinServerTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyZipkinServerTracingApplication.class, args);
	}

}
