package com.pems.backend.repositoriy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pems.backend.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);

	Optional<User> findByEmail(String email);
}
