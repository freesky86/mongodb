package com.example.mongodb.repository;

import com.example.mongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Max
 */
public interface UserRepository extends MongoRepository<User, String> {
    User findByName(String name);

    List<User> findByNameContaining(String name);
}
