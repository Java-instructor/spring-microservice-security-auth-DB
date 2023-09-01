package com.java.instructor.spring.microservice.security.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.java.instructor.spring.microservice.user.entity.UserInfo;
import com.java.instructor.spring.microservice.user.entity.UserInfoToUserDetails;
import com.java.instructor.spring.microservice.user.repository.UserInfoRepository;
@Component

public class UserInfoUserDetailsService implements UserDetailsService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo=	userInfoRepository.findByName(username);
		return userInfo.map(UserInfoToUserDetails::new).orElseThrow(()->new UsernameNotFoundException("user not available"));
	}


}
