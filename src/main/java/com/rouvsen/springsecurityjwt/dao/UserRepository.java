package com.rouvsen.springsecurityjwt.dao;

import com.rouvsen.springsecurityjwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

//    @Query(nativeQuery = true, value = "SELECT * FROM User WHERE username = :username")
    Optional<User> findUserByUsername(String username); //@Param("username")

}
