package com.infy.employee.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infy.employee.dto.RestEmployeeDTO;

@FeignClient(name="InfyAllocation", url="http://localhost:8999/")
public interface InfyAllocationFeignClient {

	
	@RequestMapping(value="/manager/getEmployeeAndManager/{employeeId}")
	RestEmployeeDTO getEmployeeAndManager(@PathVariable("employeeId") Integer employeeId);
}
