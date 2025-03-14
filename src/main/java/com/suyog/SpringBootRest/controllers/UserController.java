package com.suyog.SpringBootRest.controllers;

import com.suyog.SpringBootRest.constants.AppConstants;
import com.suyog.SpringBootRest.models.DTO.UserDTO;
import com.suyog.SpringBootRest.models.User;
import com.suyog.SpringBootRest.services.JwtService;
import com.suyog.SpringBootRest.services.MyUserDetailService;
import com.suyog.SpringBootRest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@CrossOrigin(value = "http://localhost:3000/")
@RestController
@RequestMapping(AppConstants.API_BASE_PATH)
public class UserController {

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("sign_in")
    public ResponseEntity<?> signIn(@RequestBody UserDTO userDTO) {
        ResponseEntity.ok();

        try {
            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    userDTO.getUserName(), userDTO.getPassword()
                            )
                    );

            Map<String , Object> data = new HashMap<>();

            if(authentication.isAuthenticated()) {
                data.put("message", "Log In Successful");
                data.put("Bearer Token", jwtService.getToken(userDTO.getUserName()));
            }
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(data);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
        }

    }

    @PostMapping("sign_up")
    public User signUp(@RequestBody UserDTO userDTO) {
        return userDetailService.signUp(userDTO);
    }

}
