package com.filmer.filmerbackend.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<UserMovies> ratedMovies;

    //    Constructor----------------------
    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    //    Getters and setters------------------
    public Long getId() {
        return id;
    }

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
