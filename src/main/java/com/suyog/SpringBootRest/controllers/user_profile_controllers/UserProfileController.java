package com.suyog.SpringBootRest.controllers.user_profile_controllers;

import com.suyog.SpringBootRest.constants.AppConstants;
import com.suyog.SpringBootRest.models.DTO.UserProfileDTO;
import com.suyog.SpringBootRest.models.authentication_models.User;
import com.suyog.SpringBootRest.models.authentication_models.UserProfile;
import com.suyog.SpringBootRest.services.user_profile_services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(AppConstants.API_BASE_PATH+"/profile")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    // add new user profile
    @PatchMapping("/basic/{userId}")
    public ResponseEntity<Map<String, Object>> updateBasicProfile(@PathVariable int userId, @RequestBody UserProfileDTO userProfileDTO) {
        Map<String, Object> response = new HashMap<>();
        // update user profile

        try{
            UserProfile userProfile = userProfileService.updateUserProfile(userId, userProfileDTO);
            User user = userProfileService.getCurrentUser();
            response.put("message","update successful.");
            response.put("data", user);

        }catch(Exception e) {
            response.put("message","Not able to update the profile.");
            response.put("error",e.getMessage());
        }
        return ResponseEntity.ok(response);
    }


    @GetMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> getUserProfile(@PathVariable int userId) {
        Map<String, Object> response = new HashMap<>();
        // update user profile
        try{
            UserProfile userProfile = userProfileService.getUserProfile(userId);
            response.put("message","update successful.");
            response.put("data", userProfile);
        }catch(Exception e) {
            response.put("message","Not able to update the profile.");
            response.put("error",e.getMessage());
        }
        return ResponseEntity.ok(response);
    }


}
