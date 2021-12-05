package com.infy.employee.finance.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.employee.finance.dto.FinanceDTO;
import com.infy.employee.finance.exception.FinanceException;


@Entity
@Table(name="infy_employee_finance")
public class Finance {
	@Id
	private Integer financeId;
	private Float salary;
	private Integer hike;
	private Integer bonus;
	
	public Integer getFinanceId() {
		return financeId;
	}
	public void setFinanceId(Integer financeId) {
		this.financeId = financeId;
	}
	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary) {
		this.salary = salary;
	}
	public Integer getHike() {
		return hike;
	}
	public void setHike(Integer hike) {
		this.hike = hike;
	}
	public Integer getBonus() {
		return bonus;
	}
	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}
	@Override
	public int hashCode() {
		return Objects.hash(financeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Finance other = (Finance) obj;
		return Objects.equals(financeId, other.financeId);
	}
	
	
     public static FinanceDTO getFinanceDTO(Finance finance) throws FinanceException
     {
    	 FinanceDTO financeDTO = new FinanceDTO();
    	 
    	 financeDTO.setFinanceId(finance.getFinanceId());
    	 financeDTO.setBonus(finance.getBonus());
    	 financeDTO.setHike(finance.getHike());
    	 financeDTO.setSalary(finance.getSalary());
    	 return financeDTO;
     }
}
