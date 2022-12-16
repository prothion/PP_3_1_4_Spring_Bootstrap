package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public List<User> findAll();

    public void save(User user);
    public void update(Long id, User user);

    public void delete(Long id);

    public User findById(Long id);
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
