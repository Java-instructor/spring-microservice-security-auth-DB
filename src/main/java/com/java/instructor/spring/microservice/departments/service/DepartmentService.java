package com.java.instructor.spring.microservice.departments.service;

import java.util.List;

import com.java.instructor.spring.microservice.departments.entity.Department;
import com.java.instructor.spring.microservice.user.entity.UserInfo;

public interface DepartmentService {
	Department saveDepartment(Department department);

	Department getDepartmentById(Long departmentId);

	List<Department> getAllDepartments();
	UserInfo addUser(UserInfo userInfo) ;
}