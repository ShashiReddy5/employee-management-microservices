package com.shashi.payroll.repository;

import com.shashi.payroll.model.PayrollRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayrollRepository extends JpaRepository<PayrollRecord, Long> {
    List<PayrollRecord> findByEmployeeId(Long employeeId);
}
