package com.filmer.filmerbackend.service;

import com.filmer.filmerbackend.model.Movie;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MovieService {

    ResponseEntity<Movie> addMovie(Movie movie);
    ResponseEntity<List<Movie>> findAllMovies();
    ResponseEntity<Movie> findMovieByTitle(String title);
}
