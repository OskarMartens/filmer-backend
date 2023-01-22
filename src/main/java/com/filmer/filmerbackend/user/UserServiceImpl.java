package com.filmer.filmerbackend.user;

import com.filmer.filmerbackend.movie.Movie;
import com.filmer.filmerbackend.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public ResponseEntity<User> saveUser(User user) {
        Optional<User> userOptional = userRepository.findByName(user.getName());
        if(userOptional.isPresent()) {
            throw new IllegalStateException("username is already taken");
        }
        User _user = userRepository.save(new User(user.getName()));
        return new ResponseEntity<>(_user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Optional<User>> findUserByName(String name) {
        Optional<User> _user = userRepository.findByName(name);
        if(_user.isEmpty()) {
            throw new IllegalStateException("username is not present");
        }
        return new ResponseEntity<>(_user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<User> likeMovie(Long userId, Long movieId) {
        Set<Movie> likedMovies = null;
        User user = userRepository.findById(userId).get();
        Movie movie = movieRepository.findById(movieId).get();
        likedMovies = user.getLikedMovies();
        likedMovies.add(movie);
        user.setLikedMovies(likedMovies);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
