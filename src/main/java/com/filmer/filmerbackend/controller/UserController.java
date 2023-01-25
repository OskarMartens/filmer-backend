package com.filmer.filmerbackend.controller;


import com.filmer.filmerbackend.dto.UserDTO;
import com.filmer.filmerbackend.dto.UserMoviesDTO;
import com.filmer.filmerbackend.model.User;
import com.filmer.filmerbackend.serviceimpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<String> saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{name}")
    public ResponseEntity<UserDTO> getUserByName(@PathVariable String name){
        return userService.findUserByName(name);
    }

    @PostMapping("/like-movie")
    public ResponseEntity<String> likeMovie(@RequestBody UserMoviesDTO userMoviesDTO){
        userService.likeMovie(userMoviesDTO);
        return new ResponseEntity<>("Movie successfully liked", HttpStatus.OK);

    }
}
