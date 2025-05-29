package com.sumit.StudentManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumit.StudentManagement.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	
	Teacher findByEmail(String email);
	
}
