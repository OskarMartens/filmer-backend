package com.filmer.filmerbackend.service;

import com.filmer.filmerbackend.dto.UserDTO;
import com.filmer.filmerbackend.dto.UserMoviesDTO;
import com.filmer.filmerbackend.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity<String> saveUser(User user);
    ResponseEntity<UserDTO> findUserByName(String name);
    ResponseEntity<String> likeMovie(UserMoviesDTO userMoviesDTO);
}
