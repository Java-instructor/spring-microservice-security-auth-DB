package com.java.instructor.spring.microservice.departments.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.instructor.spring.microservice.departments.entity.Department;
import com.java.instructor.spring.microservice.departments.service.DepartmentService;
import com.java.instructor.spring.microservice.security.user.service.UserInfoUserDetailsService;
import com.java.instructor.spring.microservice.user.entity.UserInfo;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("departments")
@AllArgsConstructor
public class DepartmentController {

	private DepartmentService departmentService;
	//private UserInfoUserDetailsService userInfoUserDetailsService;

	@PostMapping
	public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		Department savedDepartment = departmentService.saveDepartment(department);
		return new ResponseEntity(savedDepartment, HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId) {
		Department department = departmentService.getDepartmentById(departmentId);
		return ResponseEntity.ok(department);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Department>> getAllDepartments() {
		List<Department> departments = departmentService.getAllDepartments();
		return ResponseEntity.ok(departments);
	}
	//@GetMapping("/test")
	@PostMapping("/test")	
	public ResponseEntity<UserInfo> getTest(@RequestBody  UserInfo userInfo) {	
		UserInfo savedUserInfo = departmentService.addUser(userInfo);
		return new ResponseEntity(savedUserInfo, HttpStatus.CREATED);
	}
}