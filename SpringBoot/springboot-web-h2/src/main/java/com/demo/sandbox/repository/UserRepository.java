package com.demo.sandbox.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.sandbox.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
