package com.pl.test.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pl.test.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public List<User> toUserList(ResponseEntity<String> entity) {
        JsonNode userArr = getCommentsNode(entity);
        return toList(userArr);
    }

    private List<User> toList(JsonNode userArr){
        List<User> users = new LinkedList<>();

        for (JsonNode jn : userArr) {
            String username = jn.path("user").get("username").asText();
            User user = new User();
            user.setBody(jn.get("body").asText());
            user.setPostId(jn.get("postId").asInt());
            user.setUsername(username.substring(0, 1).toUpperCase() + username.substring(1));
            user.setUpdatedAt(ZonedDateTime.now());
            users.add(user);
        }
        return users;
    }

    @SneakyThrows
    private JsonNode getCommentsNode(ResponseEntity<String> entity) {
        JsonNode root = objectMapper.readTree(entity.getBody());
        return root.path("comments");
    }
}
