package com.shashi.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private Long id;
    private String fullName;
    private String email;
    private String jobTitle;
    private Double annualSalary;
    private DepartmentDto department;
}
