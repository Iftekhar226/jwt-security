package com.ifty.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ifty.security.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {
	@Autowired
	private  UserRepo repo;
	@Bean 
	public UserDetailsService userDetailsService() {
		return username-> this.repo.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("user is not present"));
			

	}
		
	
}
