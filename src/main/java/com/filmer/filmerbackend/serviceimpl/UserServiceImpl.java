package com.filmer.filmerbackend.serviceimpl;

import com.filmer.filmerbackend.dto.UserDTO;
import com.filmer.filmerbackend.dto.UserMoviesDTO;
import com.filmer.filmerbackend.model.User;
import com.filmer.filmerbackend.model.Movie;
import com.filmer.filmerbackend.model.UserMoviesId;
import com.filmer.filmerbackend.repositories.MovieRepository;
import com.filmer.filmerbackend.model.UserMovies;
import com.filmer.filmerbackend.repositories.UserMoviesRepository;
import com.filmer.filmerbackend.service.UserService;
import com.filmer.filmerbackend.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final UserMoviesRepository userMoviesRepository;

    public UserServiceImpl(UserRepository userRepository, MovieRepository movieRepository, UserMoviesRepository userMoviesRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.userMoviesRepository = userMoviesRepository;
    }

    @Override
    public ResponseEntity<String> saveUser(User user) {
        Optional<User> existingUser = userRepository.findByName(user.getName());
        if(existingUser.isPresent()) {
            throw new IllegalStateException("username is already taken");
        }
        User _user = userRepository.save(new User(user.getName()));
        return new ResponseEntity<>("User successfully created", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDTO> findUserByName(String name) {
        UserDTO userDTO = userRepository.
                findUserAndMoviesByName(name).
                stream().findFirst().orElse(null);

        if(userDTO == null) {
            throw new IllegalStateException("username is not present");
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> likeMovie(UserMoviesDTO userMoviesDTO) {
        UserMovies userMovies = new UserMovies();

        User user = userRepository.findById(userMoviesDTO.getUserId()).orElseThrow(()
                -> new IllegalArgumentException("Invalid user id"));
        Movie movie = movieRepository.findById(userMoviesDTO.getMovieId()).orElseThrow(()
                -> new IllegalArgumentException("Invalid movie id"));

        userMovies.setId(new UserMoviesId(user.getId(), movie.getId()));
        userMovies.setUser(user);
        userMovies.setMovie(movie);
        userMovies.setLikesOrNot(userMoviesDTO.isLikesOrNot());
        userMoviesRepository.save(userMovies);

        return new ResponseEntity<>("Movie rated successfully", HttpStatus.OK);
    }

}
