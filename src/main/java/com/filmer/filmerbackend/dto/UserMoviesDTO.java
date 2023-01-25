package com.filmer.filmerbackend.dto;

import com.filmer.filmerbackend.model.UserMovies;

// This class is used for PostMapping.
public class UserMoviesDTO {

    private Long userId;
    private Long movieId;
    private boolean likesOrNot;

    public UserMoviesDTO() {}

    public UserMoviesDTO(UserMovies userMovies) {
        this.userId = userMovies.getUser().getId();
        this.movieId = userMovies.getMovie().getId();
        this.likesOrNot = userMovies.getLikesOrNot();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public boolean isLikesOrNot() {
        return likesOrNot;
    }

    public void setLikesOrNot(boolean likesOrNot) {
        this.likesOrNot = likesOrNot;
    }

}

