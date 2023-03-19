package com.pl.test.service.impl;

import com.pl.test.dto.User;
import com.pl.test.service.UserService;
import lombok.RequiredArgsConstructor;
import com.pl.test.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HttpUserService implements UserService {

    @Value("${user.source.url}")
    private String url;

    private final RestTemplate restTemplate;
    private final UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        ResponseEntity<String> responseEntity = restTemplate
                .getForEntity(url, String.class);
        return userMapper.toUserList(responseEntity);
    }
}
