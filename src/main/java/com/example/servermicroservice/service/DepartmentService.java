package com.example.servermicroservice.service;

import com.example.servermicroservice.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    Department saveDeparment(Department department);

    List<Department> getDepartment();

    Optional<Department> getDepartmentById(Long departmentId);

    String deleteDepartmentById(Long departmentId);

    Department updateDeparment(Long departmentId, Department department);
}
