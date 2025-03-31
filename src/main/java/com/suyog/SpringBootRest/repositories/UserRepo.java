package com.suyog.SpringBootRest.repositories;

import com.suyog.SpringBootRest.models.authentication_models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
