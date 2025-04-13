package com.suyog.SpringBootRest.controllers.user_profile_controllers;

import com.suyog.SpringBootRest.models.authentication_models.SocialLink;
import com.suyog.SpringBootRest.services.user_profile_services.SocialLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("social_link")
public class SocialLinkController {

    @Autowired
    SocialLinkService socialLinkService;

    // add social link by user
    @PostMapping("/add/{userId}")
    ResponseEntity<?> addSocialLink(@PathVariable int userId, @RequestBody SocialLink socialLink){
        Map<String, Object> response = new HashMap<>();
        // update user profile
        try{
            SocialLink result = socialLinkService.addSocialLink(userId, socialLink);
            response.put("message","update successful.");
            response.put("data", result);

        }catch(Exception e) {
            response.put("message","Not able to update the profile.");
            response.put("error",e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    ResponseEntity<?> getSocialLink(@RequestParam int userId){
        Map<String, Object> response = new HashMap<>();
        // update user profile
        try{

            List<SocialLink> result = socialLinkService.getUserSocialLinks(userId);
            response.put("message","update successful.");
            response.put("data", result);

        }catch(Exception e) {
            response.put("message","Not able to update the profile.");
            response.put("error",e.getMessage());
        }
        return ResponseEntity.ok(response);
    }


    @DeleteMapping("/delete")
    ResponseEntity<?> deleteSocialLink(@RequestParam int userId, @RequestParam int socialLinkId){
        Map<String, Object> response = new HashMap<>();
        // update user profile
        try{
           socialLinkService.removeSocialLink(userId ,socialLinkId);
           response.put("message","update successful.");
        }catch(Exception e) {
            response.put("message","Not able to update the profile.");
            response.put("error",e.getMessage());
        }
        return ResponseEntity.ok(response);
    }

}
