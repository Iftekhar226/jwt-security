package com.ifty.security.authRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifty.security.model.domain.AuthenticationRequest;
import com.ifty.security.model.domain.AuthenticationResponse;
import com.ifty.security.model.domain.RegisterRequest;
import com.ifty.security.service.AuthenticateService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
	@Autowired
	AuthenticateService service;
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register( @RequestBody RegisterRequest user){
		return ResponseEntity.ok(this.service.register(user));
	}
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate( @RequestBody AuthenticationRequest user){
		return ResponseEntity.ok(this.service.authenticate(user));
	}
}
