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

    public UserProfile addNewUserProfile(User user) {
        UserProfile userProfile = new UserProfile();

        userProfile.setUser(user);
        userProfile.setUserName(user.getUserName());
        userProfile.setFullName(user.getFullName());
        user.setUserProfile(userProfile);

        return userProfileRepo.save(userProfile);
    }

    public UserProfile updateUserProfile(int userId, UserProfileDTO userProfileDTO) throws BadRequestException {

        System.out.println(userProfileDTO);
        User user = this.getCurrentUser();

        if(user.getId() != userId) {
            throw new UnautherizedUserException();
        }

        System.out.println(userProfileDTO);
        UserProfile userProfile = user.getUserProfile();

        if (userProfileDTO.getFullName() != null)
            userProfile.setFullName(userProfileDTO.getFullName());

        if (userProfileDTO.getGender() != null)
            userProfile.setGender(userProfileDTO.getGender());

        if (userProfileDTO.getDOB() != null)
            userProfile.setDOB(Date.valueOf(userProfileDTO.getDOB()));

        if (userProfileDTO.getNationality() != null)
            userProfile.setNationality(userProfileDTO.getNationality());

        if (userProfileDTO.getProfilePic() != null)
            userProfile.setProfilePicture(userProfileDTO.getProfilePic());

        if (userProfileDTO.getExperience() != null)
            userProfile.setExperience(userProfileDTO.getExperience());

        if (userProfileDTO.getEducation() != null)
            userProfile.setEducation(userProfileDTO.getEducation());

        if (userProfileDTO.getMaritalStatus() != null)
            userProfile.setMaritalStatus(userProfileDTO.getMaritalStatus());

        if (userProfileDTO.getPersonalWebsite() != null)
            userProfile.setPersonalWebsite(userProfileDTO.getPersonalWebsite());

        if (userProfileDTO.getTitle() != null)
            userProfile.setTitle(userProfileDTO.getTitle());

        return userProfileRepo.save(userProfile);
    }

    public UserProfile getUserProfile(int userId) throws UnautherizedUserException {

        User user = this.getCurrentUser();
        if(user.getId() != userId) {
            throw new UnautherizedUserException();
        }

        UserProfile userProfile = user.getUserProfile();
        Hibernate.initialize(userProfile);
        return userProfile;
    }

}
