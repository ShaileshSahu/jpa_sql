package com.example.servermicroservice.repository;

import com.example.servermicroservice.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterilaRepository  extends JpaRepository<CourseMaterial,Long> {
}
