package com.java.instructor.spring.microservice.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.java.instructor.spring.microservice.user.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {

	Optional<UserInfo> findByName(String username);


	}
