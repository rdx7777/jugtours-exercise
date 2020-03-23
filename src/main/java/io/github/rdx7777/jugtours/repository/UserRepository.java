package io.github.rdx7777.jugtours.repository;

import io.github.rdx7777.jugtours.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
