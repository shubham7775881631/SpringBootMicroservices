package com.infy.employee.finance.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class MyController {
	
	
	@GetMapping("/getData")
	public String getDetails()
	{
		return "Hey! Your service is called";
	}

}
