package com.example.filmerbackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<User> saveUser(User user) {
        User _user = userRepository.save(new User(user.getName()));
        return new ResponseEntity<>(_user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> findUserByName(String name) {
        User _user = userRepository.findByName(name);
        return new ResponseEntity<>(_user, HttpStatus.OK);
    }
}
