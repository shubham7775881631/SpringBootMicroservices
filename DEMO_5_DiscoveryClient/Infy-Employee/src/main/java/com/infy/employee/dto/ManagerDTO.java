package com.infy.employee.dto;

import java.util.Objects;

public class ManagerDTO {
	
	
	private Integer managerId;
	private String managerName;
	private Integer noOfProjectMentored;
	private String domainName;
	private Integer noOfTeamHandled;
	private Integer teamId;
	private String courseId;
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public Integer getNoOfProjectMentored() {
		return noOfProjectMentored;
	}
	public void setNoOfProjectMentored(Integer noOfProjectMentored) {
		this.noOfProjectMentored = noOfProjectMentored;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public Integer getNoOfTeamHandled() {
		return noOfTeamHandled;
	}
	public void setNoOfTeamHandled(Integer noOfTeamHandled) {
		this.noOfTeamHandled = noOfTeamHandled;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(managerId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ManagerDTO other = (ManagerDTO) obj;
		return Objects.equals(managerId, other.managerId);
	}
	
	

}
