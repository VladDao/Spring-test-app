package com.pl.test.repository;

import com.pl.test.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
