package com.pl.test.service.impl;

import com.pl.test.dto.User;
import com.pl.test.repository.UserRepository;
import com.pl.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class DbUserService implements UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        return StreamSupport.stream(users.spliterator(), false)
                .collect(Collectors.toList());
    }
}
