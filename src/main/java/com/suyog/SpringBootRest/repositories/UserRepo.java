package com.suyog.SpringBootRest.repositories;

import com.suyog.SpringBootRest.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
