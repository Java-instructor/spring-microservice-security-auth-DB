package com.java.instructor.spring.microservice.departments.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.instructor.spring.microservice.departments.entity.Department;
import com.java.instructor.spring.microservice.departments.repository.DepartmentRepository;
import com.java.instructor.spring.microservice.departments.service.DepartmentService;
import com.java.instructor.spring.microservice.user.entity.UserInfo;
import com.java.instructor.spring.microservice.user.repository.UserInfoRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	public Department getDepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}
	
	public UserInfo addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		System.out.println(userInfo);
		UserInfo userInfoRes =userInfoRepository.save(userInfo);
		return userInfoRes;
		
	}

}