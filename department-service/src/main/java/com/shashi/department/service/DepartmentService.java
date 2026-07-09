package com.shashi.department.service;

import com.shashi.department.dto.DepartmentRequest;
import com.shashi.department.dto.DepartmentResponse;
import com.shashi.department.model.Department;
import com.shashi.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentResponse> getAll() {
        return departmentRepository.findAll().stream().map(this::toResponse).toList();
    }

    public DepartmentResponse getById(Long id) {
        return toResponse(findOrThrow(id));
    }

    public DepartmentResponse create(DepartmentRequest request) {
        Department department = Department.builder()
                .name(request.getName())
                .location(request.getLocation())
                .build();
        return toResponse(departmentRepository.save(department));
    }

    public DepartmentResponse update(Long id, DepartmentRequest request) {
        Department department = findOrThrow(id);
        department.setName(request.getName());
        department.setLocation(request.getLocation());
        return toResponse(departmentRepository.save(department));
    }

    public void delete(Long id) {
        departmentRepository.delete(findOrThrow(id));
    }

    private Department findOrThrow(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Department not found: " + id));
    }

    private DepartmentResponse toResponse(Department department) {
        return DepartmentResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .location(department.getLocation())
                .build();
    }
}
