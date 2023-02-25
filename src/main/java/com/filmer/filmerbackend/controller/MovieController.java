package com.filmer.filmerbackend.controller;

import com.filmer.filmerbackend.model.Movie;
import com.filmer.filmerbackend.serviceimpl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieServiceImpl movieService;

    @Autowired
    public MovieController(MovieServiceImpl movieService) {
        this.movieService = movieService;
    }

    @PostMapping()
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return movieService.findAllMovies();
    }

    @GetMapping("/{title}")
    public ResponseEntity<Movie> findMovieByTitle(@PathVariable String title){
        return movieService.findMovieByTitle(title);
    }

    @GetMapping("/{userId}/unrated-movies")
    public ResponseEntity<List<Movie>> getUnratedMovies(@PathVariable Long userId) {
        return movieService.findAllUnratedMovies(userId);
    }

}
