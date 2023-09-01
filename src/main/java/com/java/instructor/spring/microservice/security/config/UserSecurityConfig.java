package com.java.instructor.spring.microservice.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcherEntry;

import com.java.instructor.spring.microservice.security.user.service.UserInfoUserDetailsService;

@Configuration
@EnableWebSecurity
public class UserSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		/*UserDetails instructor = User.withUsername("Sasi")
				.password(passwordEncoder.encode("Password123"))
				.roles("INSTRCTOR")
				.build();
		UserDetails user = User.withUsername("Kumar")
				.password(passwordEncoder.encode("Password456"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(instructor, user);*/
		// hard coded value above userdetails now moved to DB 
		return new UserInfoUserDetailsService();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.cors().disable().authorizeHttpRequests()
				.requestMatchers("/departments/test").permitAll()
				.and()
				.authorizeHttpRequests().requestMatchers("/departments/all").authenticated()
				.and()
				.formLogin()
				.and()
				.build();

	}
	
	
	// authentication provider need for DB layer
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

}
