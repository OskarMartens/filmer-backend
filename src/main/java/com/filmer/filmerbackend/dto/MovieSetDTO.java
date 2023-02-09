package com.filmer.filmerbackend.dto;

public class MovieSetDTO {

    private Long movieId;
    private String title;
    private boolean likes;

    public MovieSetDTO(Long movieId, String title, boolean likes) {
        this.movieId = movieId;
        this.title = title;
        this.likes = likes;
    }

    public MovieSetDTO() {
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }
}
