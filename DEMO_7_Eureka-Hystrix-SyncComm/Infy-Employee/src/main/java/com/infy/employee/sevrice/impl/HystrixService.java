package com.infy.employee.sevrice.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.infy.employee.dto.FinanceDTO;
import com.infy.employee.dto.RestEmployeeDTO;
import com.infy.employee.exception.EmployeeException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HystrixService {
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getEmployeeAndManagerFallback", ignoreExceptions = IllegalStateException.class)
	public RestEmployeeDTO getEmployeeAndManager(Integer employeeId) throws EmployeeException
	{
		//Fetching the details from MS-Infy-Allocation 
		System.out.println("========= Inside Infy-Employee--> Calling the InfyAllocation Microservice=======");
		String allocationMsUrl = "http://InfyAllocation/manager/getEmployeeAndManager/"+employeeId;
		
		RestEmployeeDTO restEmployeeDTO = restTemplate.getForObject(allocationMsUrl, RestEmployeeDTO.class);
		
		return restEmployeeDTO; 
	}
	
	@HystrixCommand(fallbackMethod = "getFinanceDetailsFallback", ignoreExceptions = IllegalStateException.class)
	public FinanceDTO getFinanceDetails(Integer financeId) throws EmployeeException
	{
		//fetching the employee finance details from the MS-Infy-Finance
		System.out.println("========= Inside Infy-Employee--> Calling the InfyFinance Microservice=======");
			String financeMsUrl = "http://Infy-EmployeeFinance/finance/getFinance/"+financeId;
				
			FinanceDTO financeDTO = restTemplate.getForObject(financeMsUrl,FinanceDTO.class);
			
			return financeDTO;
	}
	
	
	
	//Fallback Method called by  Hystrix command
	public RestEmployeeDTO getEmployeeAndManagerFallback(Integer employeeId) throws EmployeeException
	{
		System.out.println("========= Inside Infy-Employee--> !!!!! Calling getEmployeeAndManagerFallback Method !!!!!=======");
		
	     return new RestEmployeeDTO();
	}
	
	public FinanceDTO getFinanceDetailsFallback(Integer financeId) throws EmployeeException
	{
		System.out.println("========= Inside Infy-Employee--> !!!!! Calling getFinanceDetailsFallback Method !!!!!=======");
		return new FinanceDTO();
	}
	
	
	
}
