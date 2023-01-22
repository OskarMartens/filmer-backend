package com.filmer.filmerbackend.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public ResponseEntity<Movie> addMovie(Movie movie) {
        Movie _movie = movieRepository.save(new Movie(movie.getTitle()));
        return new ResponseEntity<>(_movie, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> allMovies = new ArrayList<>(movieRepository.findAll());
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Movie> findMovieByTitle(String title) {
        Movie _movie = movieRepository.findByTitle(title);
        return new ResponseEntity<>(_movie, HttpStatus.OK);
    }
}
