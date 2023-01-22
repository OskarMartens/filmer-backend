package com.filmer.filmerbackend.user;


import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Optional<User>> getUserByName(@PathVariable String name){
        return userService.findUserByName(name);
    }

    @PutMapping("/{userId}/movie/{movieId}")
    public ResponseEntity<User> likeMovie(@PathVariable Long userId,
                                          @PathVariable Long movieId){
        return userService.likeMovie(userId, movieId);
    }
}
