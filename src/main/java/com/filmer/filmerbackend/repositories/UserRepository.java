package com.filmer.filmerbackend.repositories;

import com.filmer.filmerbackend.dto.UserDTO;
import com.filmer.filmerbackend.model.User;
import com.filmer.filmerbackend.model.UserMoviesId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import java.awt.*;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query("SELECT new com.filmer.filmerbackend.dto.UserDTO(u.id, u.name, new com.filmer.filmerbackend.dto.MovieSetDTO,m.id, m.title, um.likes) " +
//            "FROM User u " +
//            "JOIN UserMovies um ON u.id = um.user.id " +
//            "JOIN Movie m ON um.movie.id = m.id " +
//            "WHERE u.name = :name")
//    Set<UserDTO> findUserAndMoviesByName(@Param("name") String name);





    @Query("select u from User u where u.name = ?1")
    Optional<User> findByName(String name);








}
