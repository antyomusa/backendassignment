package com.anton.tugasbackend.repository;

import com.anton.tugasbackend.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel, Integer> {

    UserModel findByEmail(@Param("email") String email);
    @Query(value = "SELECT * from dia_batch3.tab_anton ts WHERE ts.email= :email AND ts.password = :password", nativeQuery = true)
    UserModel getUsers(@Param("email") String email, @Param("password") String password);
}
