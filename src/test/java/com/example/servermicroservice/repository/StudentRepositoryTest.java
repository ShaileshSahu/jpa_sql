package com.example.servermicroservice.repository;

import com.example.servermicroservice.entity.Guardian;
import com.example.servermicroservice.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder().name("mohit").email("Chandra@gmail.com").mobile("9810393088").build();
        Student student = Student.builder()
                .firstName("Mohit")
                .lastName("Sharma")
                .emailId("mohit@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }
    
    @Test
    public void getStudents() {
        List<Student> students = studentRepository.findAll();
        System.out.println("StudentList ="+students);
    }

    @Test
    public void getStudentByEmail() {
        List<Student> students = studentRepository.findStudentByEmailId("sahushailesh9@gmail.com");
        System.out.println("StudentList ="+students);
    }

    @Test
    public void getStudentByFirst() {
        List<Student> students = studentRepository.findStudentByFirstNameContaining("h");
        System.out.println("StudentList ="+students);
    }

    @Test
    public void getStudentEmailQuery() {
        Student student = studentRepository.getStudentByEmailAddress("sahushailesh9@gmail.com");
        System.out.println("StudentList ="+student);
    }
    @Test
    public void getStudendNameEmailQuery() {
        String firstName = studentRepository.getStudentByNameEmailAddress("sahushailesh9@gmail.com");
        System.out.println("StudentList ="+firstName);
    }

    @Test
    public void getStudendNameEmailQueryNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("sahushailesh9@gmail.com");
        System.out.println("StudentList ="+student);
    }

    @Test
    public void getStudendNameEmailQueryNativeByParams() {
        Student student = studentRepository.getStudentByEmailAddressNativeByParams("sahushailesh9@gmail.com");
        System.out.println("StudentList ="+student);
    }

    @Test
    public void updateStudentFirstByEmail() {
        int i = studentRepository.updateStudentNameByEmailId("Shashank", "sahushailesh9@gmail.com");
        System.out.println("Student Updated"+i);
    }
}