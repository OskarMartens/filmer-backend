package com.filmer.filmerbackend.repositories;

import com.filmer.filmerbackend.model.UserMovies;
import com.filmer.filmerbackend.model.UserMoviesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMoviesRepository extends JpaRepository<UserMovies, UserMoviesId> {

    @Query("SELECT m.id FROM Movie m WHERE m.id NOT IN (SELECT um.movie.id FROM UserMovies um WHERE um.user.id = :userId)")
    List<Long> findUnratedMovieIdsByUserId(@Param("userId") Long userId);
}
