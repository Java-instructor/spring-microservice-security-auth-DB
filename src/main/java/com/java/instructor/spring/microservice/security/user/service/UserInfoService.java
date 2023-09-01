package com.java.instructor.spring.microservice.security.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.instructor.spring.microservice.user.entity.UserInfo;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping()
@AllArgsConstructor
public class UserInfoService {

	private UserInfoUserDetailsService userInfoUserDetailsService;
	
	/*@PostMapping("/addUser2")
	public UserInfo addUser(@RequestBody UserInfo userInfo) {
		return userInfoUserDetailsService.addUser(userInfo);
	}
*/
}
