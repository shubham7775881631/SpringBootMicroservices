package com.infy.employee.dto;

import java.util.Objects;

public class RestEmployeeDTO {
	private Integer employeeId;
	private String employeeName;
	private String courseId;
	private String courseName;
	private Integer score;
	private Integer hoursSpent;
	private ManagerDTO manager;
	private EmployeeDTO employee;
	private FinanceDTO finance;
	
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getHoursSpent() {
		return hoursSpent;
	}
	public void setHoursSpent(Integer hoursSpent) {
		this.hoursSpent = hoursSpent;
	}
	public ManagerDTO getManager() {
		return manager;
	}
	public void setManager(ManagerDTO manager) {
		this.manager = manager;
	}
	
	
	public FinanceDTO getFinance() {
		return finance;
	}
	public void setFinance(FinanceDTO finance) {
		this.finance = finance;
	}
	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}
	
	public EmployeeDTO getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestEmployeeDTO other = (RestEmployeeDTO) obj;
		return Objects.equals(employeeId, other.employeeId);
	}
	
	

}
