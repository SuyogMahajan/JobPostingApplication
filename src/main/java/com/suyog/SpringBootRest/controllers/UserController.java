package com.suyog.SpringBootRest.controllers;

import com.suyog.SpringBootRest.constants.AppConstants;
import com.suyog.SpringBootRest.models.DTO.UserDTO;
import com.suyog.SpringBootRest.models.authentication_models.User;
import com.suyog.SpringBootRest.models.authentication_models.UserPricipl;
import com.suyog.SpringBootRest.models.authentication_models.UserProfile;
import com.suyog.SpringBootRest.services.JwtService;
import com.suyog.SpringBootRest.services.MyUserDetailService;
import com.suyog.SpringBootRest.services.user_profile_services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


//@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping(AppConstants.API_BASE_PATH)
public class UserController {

    @Autowired
    private MyUserDetailService userDetailService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserProfileService userProfileService;

    @GetMapping("is_username_available")
    public ResponseEntity<Boolean> isUserNameAvailable(@RequestParam String userName) {
        boolean result = userDetailService.isUserNameAvailable(userName);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    @PostMapping("sign_in")
    public ResponseEntity<?> signIn(@RequestBody UserDTO userDTO) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    userDTO.getUserName(), userDTO.getPassword()
                            )
                    );

            Map<String , Object> data = new HashMap<>();
            UserPricipl userPricipl = (UserPricipl) userDetailService.loadUserByUsername(userDTO.getUserName());

            if(authentication.isAuthenticated()) {
                data.put("message", "Log In Successful");
                data.put("authToken", jwtService.getToken(userDTO.getUserName()));
                data.put("user", userPricipl.getUser());
            }
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(data);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
        }

    }

    @PostMapping("sign_up")
    public ResponseEntity<?> signUp(@RequestBody UserDTO userDTO) {

        try {
            User user = userDetailService.signUp(userDTO);
            UserProfile userProfile = userProfileService.addNewUserProfile(user);

            if(user == null) {
                throw new NullPointerException("Not able to create user");
            }

            Authentication authentication =
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    userDTO.getUserName(), userDTO.getPassword()
                            )
                    );

            Map<String , Object> data = new HashMap<>();

            if (authentication.isAuthenticated()) {
                data.put("message", "User Created Successfully.");
                data.put("authToken", jwtService.getToken(userDTO.getUserName()));
                data.put("user", user);
            }else{
                data.put("message","user creation failed");
            }
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(data);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
