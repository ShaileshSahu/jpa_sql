package com.example.servermicroservice.controller;

import com.example.servermicroservice.entity.Department;
import com.example.servermicroservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;
    @PostMapping("/deparments")
    public Department saveDeparment(@RequestBody Department department) {
        return departmentService.saveDeparment(department);
    }

    @GetMapping("/deparments")
    public List<Department> getDepartments() {
        return departmentService.getDepartment();
    }

    @GetMapping("/deparments/{id}")
    public Optional<Department> getDepartment(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/deparmemts/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) {
        return departmentService.deleteDepartmentById(departmentId);
    }

    @PutMapping("/deparments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDeparment(departmentId, department);
    }
}
