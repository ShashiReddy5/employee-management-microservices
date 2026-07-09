package com.shashi.employee.client;

import com.shashi.employee.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "department-service")
public interface DepartmentClient {

    @GetMapping("/api/departments/{id}")
    DepartmentDto getDepartmentById(@PathVariable("id") Long id);
}
