package com.infy.employee.sevrice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.infy.employee.dto.EmployeeDTO;
import com.infy.employee.entity.Employee;
import com.infy.employee.exception.EmployeeException;
import com.infy.employee.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private Environment env;
	

	@Override
	public Integer addEmployeeDetails(EmployeeDTO employeeDTO) throws EmployeeException {
		
		Optional<Employee> employeeEnt = employeeRepository.findById(employeeDTO.getEmployeeId());
		
//		Employee employee = employeeEnt.orElseThrow(() -> new EmployeeException("SERVICE.EMPLOYEE_ALREADY_EXIST"));
		if(employeeEnt.isPresent())
		{
			throw new EmployeeException("SERVICE.EMPLOYEE_ALREADY_EXIST");
		}else {
			Employee employee = new Employee();
			
			employee = employeeDTO.getEmployeeEnt(employeeDTO);
			employeeRepository.save(employee);
		}
		
		return employeeDTO.getEmployeeId();
	}

	@Override
	public List<EmployeeDTO> getAllEmployeeDetails() throws EmployeeException {
		
		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
		
		List<Employee> employeeEntList = employeeRepository.findAll();
		
		if(employeeEntList.isEmpty()) {
			throw new EmployeeException("SERVICE.EMPLOYEE_NOT_EXIST");		
		}else {
			
			for(Employee emp:employeeEntList)
			{
				EmployeeDTO employeeDTO = new EmployeeDTO();
				
				employeeDTO = emp.getEmployeeDTO(emp);	
				
				employeeDTOs.add(employeeDTO);
			}
			
		}	
		return employeeDTOs;
	}

	@Override
	public Integer updatePhoneNo(Long phoneNo, Integer employeeId) throws EmployeeException {
		
		Optional<Employee> empEnt = employeeRepository.findById(employeeId);
		
		Employee emp = empEnt.orElseThrow(() -> new EmployeeException("Employee not found!"));
		
		emp.setPhoneNo(phoneNo);
		
		employeeRepository.save(emp);
		
		return emp.getEmployeeId();
	}

	@Override
	public Integer deleteEmployeeDetails(Integer employeeId) throws EmployeeException {
        Optional<Employee> empEnt = employeeRepository.findById(employeeId);
		
		Employee emp = empEnt.orElseThrow(() -> new EmployeeException("Employee alreday deleted!"));
		
		employeeRepository.delete(emp);
		return employeeId;
	}

	@Override
	public EmployeeDTO viewEmployeeProfile(Integer employeeId) throws EmployeeException {
		
		Optional<Employee> empEnt = employeeRepository.findById(employeeId);
		
		Employee emp = empEnt.orElseThrow(() -> new EmployeeException("Employee not found!"));
		
		EmployeeDTO employeeDTO  = emp.getEmployeeDTO(emp);
		
		return employeeDTO;
		
		
	}

}
