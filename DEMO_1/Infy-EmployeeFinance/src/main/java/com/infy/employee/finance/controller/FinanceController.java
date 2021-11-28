package com.infy.employee.finance.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.infy.employee.finance.dto.FinanceDTO;
import com.infy.employee.finance.exception.FinanceException;
import com.infy.employee.finance.service.FinanceServiceImpl;


@RestController
@RequestMapping("/finance")
@Validated
public class FinanceController {

//	private static final Logger logger= (Logger) LogFactory.getLog(FinanceController.class);
	@Autowired
	private FinanceServiceImpl finService;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(value="/addFinance", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addFinanace(@RequestBody @Valid FinanceDTO financeDTO) throws FinanceException{
		
		
		Integer finId = finService.addFinanceDetails(financeDTO);
		
		String successMessage = environment.getProperty("API.FINANCE_ADDED")+":"+finId;
		//logger.info(environment.getProperty("API.FINANCE_ADDED")+":"+finId);
		
		return new ResponseEntity<>(successMessage,HttpStatus.CREATED);
		
	}
	
	
	@RequestMapping(value="/getFinance/{financeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FinanceDTO> getFinanace(@PathVariable Integer financeId) throws FinanceException{
		
		
		FinanceDTO financeDTO = finService.getFinanceDetail(financeId);
		
		return new ResponseEntity<>(financeDTO,HttpStatus.OK);
		
	}
	
	

	@RequestMapping(value="/getAllFinance", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FinanceDTO>> getAllFinanace() throws FinanceException{
		
		
		List<FinanceDTO> financeDTOs = finService.getAllFinanceDetails();
		
		return new ResponseEntity<>(financeDTOs,HttpStatus.OK);
	
    }
	
	@RequestMapping(value="/updateFinance/{financeId}/{bonus}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateBonusFinanace(@PathVariable Integer financeId, @PathVariable Integer bonus) throws FinanceException{
		
		
		Integer finId = finService.updateBonusDetails(financeId,bonus);
		String successMessage = environment.getProperty("API.FINANCE_UPDATED")+":"+finId;
		//logger.info(environment.getProperty("API.FINANCE_UPDATED")+":"+finId);
		return new ResponseEntity<>(successMessage,HttpStatus.ACCEPTED);
	
    }
	

	@RequestMapping(value="/removeFinance/{financeId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> updateBonusFinanace(@PathVariable Integer financeId) throws FinanceException{
		
		
		Integer finId = finService.removeFinanceDetail(financeId);
		String successMessage = environment.getProperty("API.FINANCE_REMOVED")+":"+finId;
		//logger.info(environment.getProperty("API.FINANCE_REMOVED")+":"+finId);
		return new ResponseEntity<>(successMessage,HttpStatus.ACCEPTED);
	
    }
	
	
	
	
}

