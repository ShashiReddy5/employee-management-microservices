package com.shashi.employee.service;

import com.shashi.employee.client.DepartmentClient;
import com.shashi.employee.dto.DepartmentDto;
import com.shashi.employee.dto.EmployeeRequest;
import com.shashi.employee.dto.EmployeeResponse;
import com.shashi.employee.model.Employee;
import com.shashi.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentClient departmentClient;

    public List<EmployeeResponse> getAll() {
        return employeeRepository.findAll().stream().map(this::toResponse).toList();
    }

    public EmployeeResponse getById(Long id) {
        return toResponse(findOrThrow(id));
    }

    public EmployeeResponse create(EmployeeRequest request) {
        Employee employee = Employee.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .jobTitle(request.getJobTitle())
                .departmentId(request.getDepartmentId())
                .annualSalary(request.getAnnualSalary())
                .build();

        return toResponse(employeeRepository.save(employee));
    }

    public EmployeeResponse update(Long id, EmployeeRequest request) {
        Employee employee = findOrThrow(id);
        employee.setFullName(request.getFullName());
        employee.setEmail(request.getEmail());
        employee.setJobTitle(request.getJobTitle());
        employee.setDepartmentId(request.getDepartmentId());
        employee.setAnnualSalary(request.getAnnualSalary());
        return toResponse(employeeRepository.save(employee));
    }

    public void delete(Long id) {
        employeeRepository.delete(findOrThrow(id));
    }

    private Employee findOrThrow(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Employee not found: " + id));
    }

    private EmployeeResponse toResponse(Employee employee) {
        DepartmentDto department;
        try {
            department = departmentClient.getDepartmentById(employee.getDepartmentId());
        } catch (RestClientException ex) {
            department = null;
        }

        return EmployeeResponse.builder()
                .id(employee.getId())
                .fullName(employee.getFullName())
                .email(employee.getEmail())
                .jobTitle(employee.getJobTitle())
                .annualSalary(employee.getAnnualSalary())
                .department(department)
                .build();
    }
}
