package com.filmer.filmerbackend.serviceimpl;

import com.filmer.filmerbackend.dto.RatedMovieDTO;
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

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final UserMoviesRepository userMoviesRepository;

    public UserServiceImpl(UserRepository userRepository,
                           MovieRepository movieRepository,
                           UserMoviesRepository userMoviesRepository) {
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
        UserDTO userDTO = new UserDTO();
        User user = userRepository.findByName(name).orElseThrow(() ->
                new IllegalArgumentException("User not found with name: " + name));

        Set<UserMovies> userMovies = user.getRatedMovies();
        Set<RatedMovieDTO> ratedMovieDTOS = new HashSet<>();

        for (UserMovies userMovie: userMovies) {
            Long movieId = userMovie.getId().getMovieId();
            Movie movie = movieRepository.findById(movieId).orElseThrow(() ->
                    new IllegalArgumentException("Movie not found with id: " + movieId));
            ratedMovieDTOS.add(new RatedMovieDTO(movieId, movie.getTitle(), userMovie.getLikes()));
        }
        userDTO.setUserId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setRatedMovies(ratedMovieDTOS);

        return ResponseEntity.ok().body(userDTO);
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
        userMovies.setLikes(userMoviesDTO.isLikes());
        userMoviesRepository.save(userMovies);

        return new ResponseEntity<>("Movie rated successfully", HttpStatus.OK);
    }

}
