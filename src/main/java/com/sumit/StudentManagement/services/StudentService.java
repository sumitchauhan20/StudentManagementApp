package com.sumit.StudentManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumit.StudentManagement.entity.Student;
import com.sumit.StudentManagement.entity.StudentDto;
import com.sumit.StudentManagement.entity.Teacher;
import com.sumit.StudentManagement.repository.StudentRepository;
import com.sumit.StudentManagement.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student saveStudent(StudentDto studentDto) {
    	Student student = StudentDtoToStudent(studentDto); 
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setEmail(studentDetails.getEmail());
            student.setDepartment(studentDetails.getDepartment());
            student.setTeacher(studentDetails.getTeacher());
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    
    
    public Student assignTeacherToStudent(Long studentId, Long teacherId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);

        if (student != null && teacher != null) {
            student.setTeacher(teacher);
            return studentRepository.save(student);
        }
        return null;
    }
    
    
    public Student  StudentDtoToStudent(StudentDto studentDto) {
    	Student student =new Student();
    	student.setName(studentDto.getName());
    	student.setEmail(studentDto.getEmail());
    	student.setDepartment(studentDto.getDepartment());
    	return student;
    	
    }
    

}
