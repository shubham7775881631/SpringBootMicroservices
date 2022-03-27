package com.infy.employee.finance.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.infy.employee.finance.dto.FinanceDTO;
import com.infy.employee.finance.entity.Finance;
import com.infy.employee.finance.exception.FinanceException;
import com.infy.employee.finance.repository.FinanceRepository;

@Service(value = "finService")
@Transactional
public class FinanceServiceImpl implements FinanceService {
	
	@Autowired
	private FinanceRepository financeRepository;
	
	@Autowired
	private Environment env;

	@Override
	public Integer addFinanceDetails(FinanceDTO financeDTO) throws FinanceException {
		
		Optional<Finance> FinEnt = financeRepository.findById(financeDTO.getFinanceId());
		
		if(FinEnt.isPresent())
		{
			throw new FinanceException("Employee is alredy exist ! .");
			
		}else {
			
			Finance finance = new Finance();
			finance = financeDTO.getFinanceEntity(financeDTO);
			financeRepository.save(finance);
		}
		return financeDTO.getFinanceId();
	}

	@Override
	public FinanceDTO getFinanceDetail(Integer financeId) throws FinanceException {
		
		Optional<Finance> FinEnt = financeRepository.findById(financeId);
		
		Finance finance = FinEnt.orElseThrow(()-> new FinanceException("Finance Deatial not found for this id !:"+financeId));
		
		FinanceDTO financeDTO = finance.getFinanceDTO(finance);
		
		
		return financeDTO;
	}

	@Override
	public List<FinanceDTO> getAllFinanceDetails() throws FinanceException {
		
		List<Finance> finEntList = financeRepository.findAll();
		List<FinanceDTO> finList = new ArrayList<>();
		
		if(finEntList.isEmpty())
		{
			throw new FinanceException("Finance Details is not found");
		}
		
		for (Finance fin : finEntList) {
			
			FinanceDTO financeDTO = new FinanceDTO();
			financeDTO = fin.getFinanceDTO(fin);
			finList.add(financeDTO);	
		}
		return finList;
	}

	@Override
	public Integer updateBonusDetails(Integer financeId, Integer bonus) throws FinanceException {
		
		Optional<Finance> FinEnt = financeRepository.findById(financeId);
		
		Finance finance = FinEnt.orElseThrow( ()-> new FinanceException("Finance Deatial not found for this id !:"+financeId));
		
		finance.setBonus(bonus);
		financeRepository.save(finance);
		
		return finance.getFinanceId();
	}

	@Override
	public Integer removeFinanceDetail(Integer financeId) throws FinanceException {
		
		Optional<Finance> FinEnt = financeRepository.findById(financeId);
		
		Finance finance = FinEnt.orElseThrow(()-> new FinanceException("Finance Deatial alreday deleted! !:"+financeId));
		
		financeRepository.delete(finance);
		
		return financeId;
	}

}
