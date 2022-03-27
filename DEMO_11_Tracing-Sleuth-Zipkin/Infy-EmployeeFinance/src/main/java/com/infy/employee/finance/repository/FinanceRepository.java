package com.infy.employee.finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.employee.finance.entity.Finance;

public interface FinanceRepository extends JpaRepository<Finance, Integer> {

}
