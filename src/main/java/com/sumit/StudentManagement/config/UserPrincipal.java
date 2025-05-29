package com.sumit.StudentManagement.config;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sumit.StudentManagement.entity.Teacher;

public class UserPrincipal implements UserDetails{
	
	Teacher teacher;
	
	public UserPrincipal(Teacher teacher) {
		super();
		this.teacher = teacher;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return teacher.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return teacher.getEmail();
	}

}
