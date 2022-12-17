package ru.kata.spring.boot_security.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;


import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringBootSecurityDemoApplication implements CommandLineRunner {

	private final RoleRepository roleRepository;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public SpringBootSecurityDemoApplication (RoleRepository roleRepository,
											  UserRepository userRepository,
											  PasswordEncoder passwordEncoder) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Role admin = new Role("ROLE_ADMIN");
		Role user = new Role("ROLE_USER");
		Set<Role> setRoleAdmin = new HashSet<>();
		setRoleAdmin.add(admin);
		setRoleAdmin.add(user);
		roleRepository.save(admin);
		roleRepository.save(user);
		userRepository.save(new User("Вадим", "Дрз", 20, "admin@mail.com", passwordEncoder.encode("admin"), setRoleAdmin));
		Set<Role> setRoleUser = new HashSet<>();
		setRoleUser.add(user);
		userRepository.save(new User("Вадим", "ProstoUser", 20, "user@mail.com", passwordEncoder.encode("user"), setRoleUser));
	}

}
