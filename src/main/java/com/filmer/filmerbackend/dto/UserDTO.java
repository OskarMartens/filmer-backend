package com.filmer.filmerbackend.dto;

import com.filmer.filmerbackend.model.Movie;
import com.filmer.filmerbackend.model.User;

import java.util.HashSet;
import java.util.Set;


public class UserDTO {

    private Long userId;
    private String name;
    private Set<UserMoviesDTO> ratedMovies;

    public UserDTO(Long userId, String name, Set<UserMoviesDTO> ratedMovies) {
        this.userId = userId;
        this.name = name;
        this.ratedMovies = ratedMovies;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Set<UserMoviesDTO> getRatedMovies() {
        return ratedMovies;
    }
}
