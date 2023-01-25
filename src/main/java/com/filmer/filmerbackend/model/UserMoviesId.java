package com.filmer.filmerbackend.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserMoviesId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "movie_id")
    private Long movieId;

    public UserMoviesId() {
    }

    public UserMoviesId(Long userId, Long movieId) {
        this.userId = userId;
        this.movieId = movieId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserMoviesId)) return false;
        UserMoviesId that = (UserMoviesId) o;
        return getUserId().equals(that.getUserId()) &&
                getMovieId().equals(that.getMovieId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getMovieId());
    }
}
