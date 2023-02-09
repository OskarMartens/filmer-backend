package com.filmer.filmerbackend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "user_movie")
public class UserMovies {

    @EmbeddedId
    private UserMoviesId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column
    private boolean likes;

    public UserMovies() {
    }

    public UserMovies(User user, Movie movie, boolean likes) {
        this.id = new UserMoviesId(user.getId(), movie.getId());
        this.user = user;
        this.movie = movie;
        this.likes = likes;
    }

    public UserMoviesId getId() {
        return id;
    }

    public void setId(UserMoviesId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public boolean getLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }
}
