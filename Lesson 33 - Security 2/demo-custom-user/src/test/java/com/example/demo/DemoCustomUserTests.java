package com.example.demo;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class DemoCustomUserTests {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;


    @Test
    void save_role() {
        List<Role> roles = List.of(
                Role.builder().name("USER").build(),
                Role.builder().name("ADMIN").build(),
                Role.builder().name("AUTHOR").build()
        );
        roleRepository.saveAll(roles);
    }


    @Test
    void save_user() {
        Role userRole = roleRepository.findByName("USER").orElse(null);
        Role adminRole = roleRepository.findByName("ADMIN").orElse(null);
        Role authorRole = roleRepository.findByName("AUTHOR").orElse(null);

        List<User> users = List.of(
                User.builder().name("a").email("a@gmail.com").password(encoder.encode("123")).roles(List.of(userRole)).build(),
                User.builder().name("b").email("b@gmail.com").password(encoder.encode("123")).roles(List.of(adminRole)).build(),
                User.builder().name("c").email("c@gmail.com").password(encoder.encode("123")).roles(List.of(authorRole)).build(),
                User.builder().name("d").email("d@gmail.com").password(encoder.encode("123")).roles(List.of(userRole, adminRole)).build()
        );
        userRepository.saveAll(users);
    }

}
