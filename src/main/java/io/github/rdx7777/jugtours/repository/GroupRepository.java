package io.github.rdx7777.jugtours.repository;

import io.github.rdx7777.jugtours.model.Group;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {

    Group findByName(String name);

    List<Group> findAllByUserId(String id);
}
