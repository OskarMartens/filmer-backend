package com.filmer.filmerbackend.dto;

public class RatedMovieDTO {

    private Long id;
    private String title;
    private boolean rating;

    public RatedMovieDTO(Long id, String title, boolean rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isRating() {
        return rating;
    }

    public void setRating(boolean rating) {
        this.rating = rating;
    }
}
