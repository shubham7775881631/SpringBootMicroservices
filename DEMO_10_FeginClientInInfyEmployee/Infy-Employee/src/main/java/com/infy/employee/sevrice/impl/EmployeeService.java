package com.infy.employee.sevrice.impl;

import java.util.List;

import com.infy.employee.dto.EmployeeDTO;
import com.infy.employee.exception.EmployeeException;

public interface EmployeeService {
	
public Integer addEmployeeDetails(EmployeeDTO employeeDTO) throws EmployeeException;
	
	public List<EmployeeDTO> getAllEmployeeDetails() throws EmployeeException;
	
	public Integer updatePhoneNo(Long phoneNo,Integer employeeId) throws EmployeeException;
	
	public Integer deleteEmployeeDetails(Integer employeeId) throws EmployeeException;
	
	public EmployeeDTO viewEmployeeProfile(Integer employeeId) throws EmployeeException;


}
