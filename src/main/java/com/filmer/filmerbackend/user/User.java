package com.filmer.filmerbackend.user;


import com.filmer.filmerbackend.movie.Movie;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.LAZY,
        cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
        })
    @JoinTable(name = "user_movies",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private Set<Movie> likedMovies = new HashSet<>();

    public User(Set<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public Set<Movie> getLikedMovies() {
        return likedMovies;
    }

    public void setLikedMovies(Set<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }
}
