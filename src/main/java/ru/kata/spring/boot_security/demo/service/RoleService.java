package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> findAll();
    void save(Role role);
    Role findById(Long id);
    void delete(Long id);
    Role findByName(String role);
}
