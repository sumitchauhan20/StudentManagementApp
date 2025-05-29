package com.sumit.StudentManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sumit.StudentManagement.entity.Teacher;
import com.sumit.StudentManagement.repository.TeacherRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Teacher teacher = teacherRepository.findByEmail(username);
		 if(teacher ==null) {
			 throw new UsernameNotFoundException("Teacher is not present");
		 }
		
		return new UserPrincipal(teacher);
	}

}
