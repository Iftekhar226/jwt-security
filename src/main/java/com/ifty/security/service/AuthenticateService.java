package com.ifty.security.service;

import org.springframework.beans.factory.annotation.Autowired;
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

	public AuthenticationResponse register(RegisterRequest request) {
		var user =  User.builder()
		        .firstname(request.getFirstname())
		        .lastname(request.getLastname())
		        .email(request.getEmail())
		        .password(PasswordEncoder.encode(request.getPassword()))
		        .role(request.getRole())
		        .build();
		    var savedUser = this.repository.save(user);
		    var jwtToken = jwtService.generateToken(user);
		    var refreshToken = jwtService.generateRefreshToken(user);
		    saveUserToken(savedUser, jwtToken);
		    return AuthenticationResponse.builder()
		        .accessToken(jwtToken)
		            .refreshToken(refreshToken)
		        .build();
	}
	public AuthenticationResponse authenticate(AuthenticationRequest user) {
		
		return null;
	}
}
