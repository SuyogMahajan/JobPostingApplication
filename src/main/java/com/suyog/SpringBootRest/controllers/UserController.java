package com.suyog.SpringBootRest.controllers;

import com.suyog.SpringBootRest.constants.AppConstants;
import com.suyog.SpringBootRest.models.DTO.UserDTO;
import com.suyog.SpringBootRest.models.User;
import com.suyog.SpringBootRest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping(AppConstants.API_BASE_PATH)
public class UserController {

    @Autowired
    UserService userService;

//    public User signIn(UserDTO  userDTO) {
//
//    }

    @PostMapping("sign_up")
    public User signUp(@RequestBody  UserDTO userDTO) {

        return userService.signUp(userDTO);
    }

}
