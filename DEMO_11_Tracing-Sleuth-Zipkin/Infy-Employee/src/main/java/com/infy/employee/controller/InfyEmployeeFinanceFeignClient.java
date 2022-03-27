package com.infy.employee.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.employee.dto.FinanceDTO;


@FeignClient(name="Infy-EmployeeFinance", url="http://localhost:8999/")
public interface InfyEmployeeFinanceFeignClient {

	
	
	@RequestMapping(value="/finance/getFinance/{financeId}")
	FinanceDTO getEmployeeFinance(@PathVariable("financeId") Integer financeId);
}


