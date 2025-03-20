package com.pfe.AllTheTps.data;

import com.pfe.AllTheTps.entities.RoleEntity;
import com.pfe.AllTheTps.entities.UserEntity;
import com.pfe.AllTheTps.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UsersDump implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UsersDump(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void run(String... args) throws Exception {
        Set<RoleEntity> roles = new HashSet() {
            {
                add(new RoleEntity("ADMIN"));
                add(new RoleEntity("USER"));
            }
        };
        String user = "user" + 1;
        UserEntity userEntity = UserEntity.builder()
                .name(user)
                .email(user + "@gmail.com")
                .password(passwordEncoder.encode(user))
                .address(user)
                .roles(roles)
                .build();
        userRepository.save(userEntity);
    }
}
