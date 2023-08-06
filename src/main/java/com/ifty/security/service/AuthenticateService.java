package com.ifty.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ifty.security.config.JwtService;
import com.ifty.security.model.domain.AuthenticationRequest;
import com.ifty.security.model.domain.AuthenticationResponse;
import com.ifty.security.model.domain.RegisterRequest;
import com.ifty.security.model.user.User;
import com.ifty.security.repo.UserRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticateService { 
	@Autowired
	UserRepo repository;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	JwtService jwtService;
	@Autowired
	AuthenticationManager authManeger;

	public AuthenticationResponse register(RegisterRequest request) {
		var user =  User.builder()
		        .firstname(request.getFirstname())
		        .lastname(request.getLastname())
		        .email(request.getEmail())
		        .password(passwordEncoder.encode(request.getPassword()))
		        .role(request.getRole())
		        .build();
	
		    this.repository.save(user);
		    var jwtToken = jwtService.genrateToken(user);
		   return AuthenticationResponse.builder().token(jwtToken).build();
	}
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authManeger.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
				);
		var user = repository.findByEmail(request.getEmail())
		        .orElseThrow();
		    var jwtToken = jwtService.genrateToken(user);
		    return AuthenticationResponse.builder()
		       .token(jwtToken)
		        
		        .build();
	}
}
