package com.filmer.filmerbackend.dto;

import com.filmer.filmerbackend.model.Movie;
import com.filmer.filmerbackend.model.User;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

// This class is for GetMapping
public class UserDTO {

    private Long id;
    private String name;
    private Set<RatedMovieDTO> ratedMovies;


    public UserDTO(Long id, String name, Set<RatedMovieDTO> ratedMovies) {
        this.id = id;
        this.name = name;
        this.ratedMovies = new HashSet<>();
    }

    public UserDTO() {
    }

    public UserDTO(Long id, String name) {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<RatedMovieDTO> getRatedMovies() {
        return ratedMovies;
    }

    public void setUserId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRatedMovies(Set<RatedMovieDTO> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }
}
