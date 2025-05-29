package com.sumit.StudentManagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sumit.StudentManagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
