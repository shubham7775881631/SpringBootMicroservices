package com.infy.employee.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.infy.employee.dto.EmployeeDTO;
import com.infy.employee.exception.EmployeeException;

@Entity
@Table(name ="infy_employee")
public class Employee {
	@Id
	private Integer employeeId;
	
	private String employeeName;
	
	@Column(name = "phone")
	private Long phoneNo;
	
	private Integer financeId;
	private Integer projectId;
	
	@Column(name = "course_code")
	private Character courseId;

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

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Character getCourseId() {
		return courseId;
	}

	public void setCourseId(Character courseId) {
		this.courseId = courseId;
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
		Employee other = (Employee) obj;
		return Objects.equals(employeeId, other.employeeId);
	}
	
	public static EmployeeDTO getEmployeeDTO(Employee employee) throws EmployeeException{
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		
		employeeDTO.setCourseId(employee.getCourseId());
		employeeDTO.setEmployeeId(employee.getEmployeeId());
		employeeDTO.setEmployeeName(employee.getEmployeeName());
		employeeDTO.setFinanceId(employee.getFinanceId());
		employeeDTO.setPhoneNo(employee.getPhoneNo());
		employeeDTO.setProjectId(employee.getProjectId());
			
		return employeeDTO;
	}
	
	

}
