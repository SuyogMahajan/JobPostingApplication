package com.suyog.SpringBootRest.services;

import com.suyog.SpringBootRest.models.DTO.UserDTO;
import com.suyog.SpringBootRest.models.User;
import com.suyog.SpringBootRest.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User signUp(UserDTO userDTO) {

        User user = userDTO.userBuilder();
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userRepo.save(user);

    }

}
