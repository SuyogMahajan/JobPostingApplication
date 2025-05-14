package com.suyog.SpringBootRest.services.user_profile_services;

import com.suyog.SpringBootRest.exceptions.UnautherizedUserException;
import com.suyog.SpringBootRest.models.DTO.UserProfileDTO;
import com.suyog.SpringBootRest.models.authentication_models.User;
import com.suyog.SpringBootRest.models.authentication_models.UserPricipl;
import com.suyog.SpringBootRest.models.authentication_models.UserProfile;
import com.suyog.SpringBootRest.repositories.user_profile_repos.UserProfileRepo;
import com.suyog.SpringBootRest.services.MyUserDetailService;
import org.apache.coyote.BadRequestException;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class UserProfileService {

    @Autowired
    UserProfileRepo userProfileRepo;

    @Autowired
    MyUserDetailService userDetailService;

    // add new user profile
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserPricipl userPricipl = (UserPricipl) userDetailService.loadUserByUsername(userName);
        return userPricipl.getUser();
    }

    public UserProfile addNewProfile(User user) {
        UserProfile userProfile = new UserProfile();

        userProfile.setUser(user);
        userProfile.setUserName(user.getUserName());
        userProfile.setFullName(user.getFullName());
        user.setProfile(userProfile);


        return userProfileRepo.save(userProfile);
    }

    public UserProfile updateUserProfile(int userId, UserProfileDTO userProfileDTO) throws BadRequestException {

        User user = this.getCurrentUser();
        System.out.println("indeinindineindd" + user);
        if(user.getId() != userId) {
            throw new BadRequestException("user not authorized");
        }

        UserProfile userProfile = (UserProfile) user.getProfile();

        userProfile.setFullName(userProfileDTO.getFullName());
        userProfile.setGender(userProfileDTO.getGender());
        userProfile.setDOB(Date.valueOf(userProfileDTO.getDOB()));
        userProfile.setNationality(userProfileDTO.getNationality());
        userProfile.setExperience(userProfileDTO.getExperience());
        userProfile.setEducation(userProfileDTO.getEducation());
        userProfile.setProfilePicture(userProfileDTO.getProfilePicture());
        userProfile.setMaritalStatus(userProfileDTO.getMaritalStatus());
        userProfile.setPersonalWebsite(userProfileDTO.getPersonalWebsite());
        userProfile.setTitle(userProfileDTO.getTitle());

        return userProfileRepo.save(userProfile);
    }
    public UserProfile getUserProfile(int userId) throws UnautherizedUserException {

        User user = this.getCurrentUser();
        if(user.getId() != userId) {
            throw new UnautherizedUserException();
        }

        UserProfile userProfile = (UserProfile) user.getProfile();
        Hibernate.initialize(userProfile);
        return userProfile;
    }
}
