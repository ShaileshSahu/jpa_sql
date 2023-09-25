package com.example.servermicroservice.repository;

import com.example.servermicroservice.entity.Course;
import com.example.servermicroservice.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void createTeacher() {
        Course courseBA = Course.builder().title("BA").credit(5).build();
        Course courseABC = Course.builder().title("ABC").credit(4).build();
        Teacher teacher = Teacher.builder().firstName("Hima").lastName("Sahu").courses(List.of(courseBA,courseABC)).build();
        teacherRepository.save(teacher);
    }
}