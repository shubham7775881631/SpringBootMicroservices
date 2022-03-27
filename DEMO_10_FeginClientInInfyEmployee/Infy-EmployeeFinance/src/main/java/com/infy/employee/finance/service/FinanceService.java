package com.infy.employee.finance.service;

import java.util.List;

import com.infy.employee.finance.dto.FinanceDTO;
import com.infy.employee.finance.exception.FinanceException;

public interface FinanceService {
	
	public Integer addFinanceDetails(FinanceDTO financeDTO) throws FinanceException;
	public FinanceDTO getFinanceDetail(Integer financeId) throws FinanceException;
	public List<FinanceDTO> getAllFinanceDetails() throws FinanceException;
	public Integer updateBonusDetails(Integer financeId, Integer bonus) throws FinanceException;
	public Integer removeFinanceDetail(Integer financeId) throws FinanceException;


}
