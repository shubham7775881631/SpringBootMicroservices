package com.infy.employee.dto;

import java.util.Objects;

public class FinanceDTO {
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
		FinanceDTO other = (FinanceDTO) obj;
		return Objects.equals(financeId, other.financeId);
	}
	
	

}
