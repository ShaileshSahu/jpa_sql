package com.example.servermicroservice.service;

import com.example.servermicroservice.entity.Department;
import com.example.servermicroservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImp implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public Department saveDeparment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
        return "Delete the deparment Id";
    }

    @Override
    public Department updateDeparment(Long departmentId, Department department) {
    Department departmentData =  departmentRepository.findById(departmentId).get();
     if(Objects.nonNull(department.getDepartmentName())){
            departmentData.setDepartmentName(department.getDepartmentName());
     }
     return departmentRepository.save(departmentData);
    }
}
