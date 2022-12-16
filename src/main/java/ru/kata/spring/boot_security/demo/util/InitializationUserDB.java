package ru.kata.spring.boot_security.demo.util;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class InitializationUserDB {

    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public InitializationUserDB(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createUsersWithRoles() {

        Role role1 = new Role("ADMIN");
        Role role2 = new Role( "USER");

        roleService.save(role1);
        roleService.save(role2);

        Set<Role> set = new HashSet<>();
        set.add(role1);
        set.add(role2);

        User user1 = new User(new BCryptPasswordEncoder(8).encode("admin"), "Вадим", "Деречин", 20, "Отсутствует",  "testMail@gmail.com", set);

        userService.save(user1);

    }
}
