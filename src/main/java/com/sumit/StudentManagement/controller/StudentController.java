package com.sumit.StudentManagement.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sumit.StudentManagement.entity.Student;
import com.sumit.StudentManagement.entity.StudentDto;
import com.sumit.StudentManagement.services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody StudentDto studentDto) {
        return studentService.saveStudent(studentDto);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    
    @PutMapping("/{studentId}/assign-teacher/{teacherId}")
    public Student assignTeacherToStudent(
            @PathVariable Long studentId,
            @PathVariable Long teacherId) {
        return studentService.assignTeacherToStudent(studentId, teacherId);
    }
}

