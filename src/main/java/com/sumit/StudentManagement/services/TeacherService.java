package com.sumit.StudentManagement.services;


import com.sumit.StudentManagement.entity.Teacher;
import com.sumit.StudentManagement.entity.TeacherDto;
import com.sumit.StudentManagement.repository.TeacherRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public Teacher saveTeacher(TeacherDto teacherDto) {
    	Teacher teacher = teacherDtoToTeacher(teacherDto);
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long id, Teacher teacherDetails) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(id);
        if (optionalTeacher.isPresent()) {
            Teacher teacher = optionalTeacher.get();
            teacher.setName(teacherDetails.getName());
            teacher.setEmail(teacherDetails.getEmail());
            teacher.setSubject(teacherDetails.getSubject());
            
            return teacherRepository.save(teacher);
        }
        return null;
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
    
    public Teacher teacherDtoToTeacher(TeacherDto teacherDto) {
    	Teacher teacher =new Teacher();
    	teacher.setName(teacherDto.getName());
    	teacher.setEmail(teacherDto.getEmail());
    	teacher.setSubject(teacherDto.getSubject());
    	teacher.setPassword(teacherDto.getPassword());
    	return teacher;
    }
}
