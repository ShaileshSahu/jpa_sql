package com.example.servermicroservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(
        name="tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name="emailid_unique",
                columnNames="email_address"
        )
)
public class Student {

     @Id
     @SequenceGenerator(name="student_sequence",sequenceName = "student_sequence", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
     private  long id;
     private String firstName;
     private String lastName;
     @Column(name="email_address",nullable = false)
     private String emailId;
     @Embedded
     private Guardian guardian;
}
