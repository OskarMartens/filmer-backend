package com.filmer.filmerbackend.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<UserMovies> ratedMovies;
//    @ManyToMany(cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE})
//    @JoinTable(name = "user_movies",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "movie_id"))
//    private Set<Movie> ratedMovies = new HashSet<>();

//    Constructor----------------------
    public User() {}

    public User(String name) {
        this.name = name;
    }


    //    Getters and setters------------------
    public Long getId() {
        return id;
    }

//    public Long setId(Long id){this.id = id}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//-------------------------------------------------


    public Set<UserMovies> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(Set<UserMovies> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

}
