package com.example.filmerbackend.movie;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {

    ResponseEntity<Movie> addMovie(Movie movie);
    ResponseEntity<List<Movie>> findAllMovies();
    ResponseEntity<Movie> findMovieByTitle(String title);
}
