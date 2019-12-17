package com.satriya.app.repository;

import com.satriya.app.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public Optional<User> findUserByUsername(String username);
}
