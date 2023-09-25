package com.example.servermicroservice.repository;

import com.example.servermicroservice.entity.Course;
import com.example.servermicroservice.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterilaRepositoryTest {

    @Autowired
    private CourseMaterilaRepository courseMaterilaRepository;

    @Test
    public  void saveCouseMaterial() {
        Course course = Course.builder().title("Algo").credit(6).build();
        CourseMaterial courseMaterial = CourseMaterial.builder().url("www.googl.com").build();

        courseMaterilaRepository.save(courseMaterial);
    }

    @Test
    public  void printAllCoursesMaterial() {
        List<CourseMaterial> courseMaterials = courseMaterilaRepository.findAll();
        System.out.println("course materials"+ courseMaterials);
    }
}