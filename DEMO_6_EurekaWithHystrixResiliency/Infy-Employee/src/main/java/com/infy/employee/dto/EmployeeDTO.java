package com.infy.employee.dto;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.infy.employee.entity.Employee;
import com.infy.employee.exception.EmployeeException;

public class EmployeeDTO {
	
	@NotNull(message= "{employee.id}")
	private Integer employeeId;
	private String employeeName;
	@NotNull(message= "{phoneNo.id}")
	//@Pattern(regexp="[0-9]{10}",message="Phone Number Should be 10 digit number")
	private Long phoneNo;
	@NotNull(message= "{finance.id}")
	private Integer financeId;
	@NotNull(message= "{course.id}")
	//@Pattern(regexp="[A-Z]{1}",message="Course Id must single capital letter from A-Z")
	private Character courseId;
	@NotNull(message= "{project.id}")
	private Integer projectId;
	

	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeedId) {
		this.employeeId = employeedId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Integer getFinanceId() {
		return financeId;
	}
	public void setFinanceId(Integer financeId) {
		this.financeId = financeId;
	}
	public Character getCourseId() {
		return courseId;
	}
	
	public void setCourseId(Character courseId) {
		this.courseId = courseId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		return Objects.equals(employeeId, other.employeeId);
	}
	
	public static Employee getEmployeeEnt(EmployeeDTO employeeDTO) throws EmployeeException
	{

		
		Employee employeeEnt = new Employee();
		employeeEnt.setCourseId(employeeDTO.getCourseId());
		employeeEnt.setEmployeeId(employeeDTO.getEmployeeId());
		employeeEnt.setEmployeeName(employeeDTO.getEmployeeName());
		employeeEnt.setFinanceId(employeeDTO.getFinanceId());
		employeeEnt.setPhoneNo(employeeDTO.getPhoneNo());
		employeeEnt.setProjectId(employeeDTO.getProjectId());
				
		return employeeEnt;
	}

}
