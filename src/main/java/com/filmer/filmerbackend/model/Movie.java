package com.filmer.filmerbackend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "movie")
public class Movie {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;


    public Movie() {
    }

    public Movie(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
