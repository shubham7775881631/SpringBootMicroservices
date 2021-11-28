package com.infy.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
