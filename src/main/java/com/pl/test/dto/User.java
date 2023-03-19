package com.pl.test.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "users_id_seq")
    private long id;
    private String body;
    private int postId;
    private String username;
    private ZonedDateTime updatedAt;
}
