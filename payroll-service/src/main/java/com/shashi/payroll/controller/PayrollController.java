package com.shashi.payroll.controller;

import com.shashi.payroll.model.PayrollRecord;
import com.shashi.payroll.service.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
@RequiredArgsConstructor
public class PayrollController {

    private final PayrollService payrollService;

    @GetMapping
    public ResponseEntity<List<PayrollRecord>> getAll() {
        return ResponseEntity.ok(payrollService.getAll());
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<PayrollRecord>> getByEmployeeId(@PathVariable Long employeeId) {
        return ResponseEntity.ok(payrollService.getByEmployeeId(employeeId));
    }

    @PostMapping
    public ResponseEntity<PayrollRecord> create(@RequestBody PayrollRecord record) {
        return ResponseEntity.ok(payrollService.create(record));
    }
}
