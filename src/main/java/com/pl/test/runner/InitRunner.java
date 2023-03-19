package com.pl.test.runner;

import com.pl.test.dto.User;
import com.pl.test.repository.UserRepository;
import com.pl.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitRunner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final UserService httpUserService;

    @Override
    public void run(String... args) {
        List<User> users = httpUserService.getAllUsers();
        userRepository.saveAll(users);
    }
}
