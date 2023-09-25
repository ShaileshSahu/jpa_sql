package com.example.servermicroservice.repository;

import com.example.servermicroservice.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findStudentByEmailId(String email);

    public  List<Student> findStudentByFirstNameContaining(String name);

    //JPQL
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentByNameEmailAddress(String emailId);


    @Query(
            value="select  * from tbl_student s where s.email_address=?1",nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String email);

    @Query(
            value="select  * from tbl_student s where s.email_address=:emailId",nativeQuery = true
    )
    Student getStudentByEmailAddressNativeByParams(@Param("emailId") String email);


    @Modifying
    @Transactional
    @Query(
            value="update tbl_student set first_name=?1 where email_address=?2",
            nativeQuery=true
    )
    int updateStudentNameByEmailId(String firstName, String emailId);

}
