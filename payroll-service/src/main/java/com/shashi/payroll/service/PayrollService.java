package com.shashi.payroll.service;

import com.shashi.payroll.model.PayrollRecord;
import com.shashi.payroll.repository.PayrollRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PayrollService {

    private final PayrollRepository payrollRepository;

    public List<PayrollRecord> getByEmployeeId(Long employeeId) {
        return payrollRepository.findByEmployeeId(employeeId);
    }

    public PayrollRecord create(PayrollRecord record) {
        return payrollRepository.save(record);
    }

    public List<PayrollRecord> getAll() {
        return payrollRepository.findAll();
    }
}
