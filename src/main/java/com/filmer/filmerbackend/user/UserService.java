package com.filmer.filmerbackend.user;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {

    ResponseEntity<User> saveUser(User user);
    ResponseEntity<Optional<User>> findUserByName(String name);
    ResponseEntity<User> likeMovie(Long userId, Long movieId);
}
