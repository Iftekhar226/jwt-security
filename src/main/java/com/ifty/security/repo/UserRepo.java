package com.ifty.security.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifty.security.model.user.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	public Optional<User> findByEmail(String email);

}
