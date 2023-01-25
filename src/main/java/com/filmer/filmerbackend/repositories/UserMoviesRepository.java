package com.filmer.filmerbackend.repositories;

import com.filmer.filmerbackend.model.UserMovies;
import com.filmer.filmerbackend.model.UserMoviesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMoviesRepository extends JpaRepository<UserMovies, UserMoviesId> {
}
