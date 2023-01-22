package com.example.filmerbackend.user;

import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<User> saveUser(User user);
    ResponseEntity<User> findUserByName(String name);
}
