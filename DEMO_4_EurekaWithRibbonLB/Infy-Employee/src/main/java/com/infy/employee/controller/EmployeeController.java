package com.infy.employee.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.infy.employee.config.ribbon.loadbalancing.InfyEmployeeRibbonLBConfig;
import com.infy.employee.dto.EmployeeDTO;
import com.infy.employee.dto.FinanceDTO;
import com.infy.employee.dto.RestEmployeeDTO;
import com.infy.employee.exception.EmployeeException;
import com.infy.employee.sevrice.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/infytel-employee")
@Validated
//@RibbonClient(name="empribbon", configuration=InfyEmployeeRibbonLBConfig.class)
public class EmployeeController {

	private static final Logger logger = Logger.getLogger("EmployeeController");

	@Autowired
	private EmployeeServiceImpl employeeService;

	@Autowired
	private Environment env;
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addEmployeeDetails(@Valid @RequestBody EmployeeDTO employeeDTO) throws EmployeeException {

		Integer employeeId = employeeService.addEmployeeDetails(employeeDTO);

		String successMessage = env.getProperty("API.EMPLOYEE_ADDED_SUCCESSFULLY") + ": " + employeeId;

		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getAllEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeDTO>> fetechAllEmployeeDetails() throws EmployeeException {

		List<EmployeeDTO> employeeDTOs = employeeService.getAllEmployeeDetails();

		return new ResponseEntity<>(employeeDTOs, HttpStatus.OK);

	}

	@RequestMapping(value = "/updateEmployee/{phoneNo}/{employeeId}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateEmployeeDetails(@PathVariable Long phoneNo,
			@PathVariable Integer employeeId)
			throws EmployeeException {

		Integer Id = employeeService.updatePhoneNo(phoneNo, employeeId);

		String successMessage = env.getProperty("API.EMPLOYEE_UPDATED_SUCCESSFULLY") + ": " + Id;

		return new ResponseEntity<>(successMessage, HttpStatus.OK);

	}

	@RequestMapping(value = "/deleteEmployee/{employeeId}")
	public ResponseEntity<String> deleteEmployeeDetails(@PathVariable Integer employeeId) throws EmployeeException {

		Integer Id = employeeService.deleteEmployeeDetails(employeeId);

		String successMessage = env.getProperty("API.EMPLOYEE_DELETED_SUCCESSFULLY") + ": " + Id;

		return new ResponseEntity<>(successMessage, HttpStatus.ACCEPTED);

	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDTO> viewEmployeeProfile(Integer employeeId) throws EmployeeException {

		EmployeeDTO employeeDTO = employeeService.viewEmployeeProfile(employeeId);

		return new ResponseEntity<>(employeeDTO, HttpStatus.OK);

	}
	
	@RequestMapping(value ="/getFullEmployeeProfile/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestEmployeeDTO> viewFullEmployeeProfile(@PathVariable Integer employeeId) throws EmployeeException {
		
		
		String allocationMsUrl = "http://InfyAllocation/manager/getEmployeeAndManager/"+employeeId;
		
		//feteching the details from ms-Infyallocation
		
		RestEmployeeDTO restEmployeeDTO = restTemplate.getForObject(allocationMsUrl, RestEmployeeDTO.class);
		
		//feteching employee details from our class details f
		EmployeeDTO employeeDTO = employeeService.viewEmployeeProfile(employeeId);
		
		//fetevhing the employee finance detials from the ms-Infy-Finance
		
		String financeMsUrl = "http://Infy-EmployeeFinance/finance/getFinance/"+employeeDTO.getFinanceId();
		
		FinanceDTO financeDTO = restTemplate.getForObject(financeMsUrl,FinanceDTO.class);
		
		restEmployeeDTO.setEmployee(employeeDTO);
		restEmployeeDTO.setFinance(financeDTO);
		
		
		return new ResponseEntity<>(restEmployeeDTO,HttpStatus.OK);
			
	}


}
