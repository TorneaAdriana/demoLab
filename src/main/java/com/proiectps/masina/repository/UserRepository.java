package com.proiectps.masina.repository;

import com.proiectps.masina.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

}
