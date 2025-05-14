package com.suyog.SpringBootRest.services.user_profile_services;

import com.suyog.SpringBootRest.exceptions.ResourceNotFoundException;
import com.suyog.SpringBootRest.exceptions.UnautherizedUserException;
import com.suyog.SpringBootRest.models.authentication_models.AbstractProfile;
import com.suyog.SpringBootRest.models.authentication_models.SocialLink;
import com.suyog.SpringBootRest.models.authentication_models.User;
import com.suyog.SpringBootRest.models.authentication_models.UserPricipl;
import com.suyog.SpringBootRest.repositories.user_profile_repos.SocialLinkRepo;
import com.suyog.SpringBootRest.services.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialLinkService {

    @Autowired
    SocialLinkRepo socialLinkRepo;

    @Autowired
    MyUserDetailService userDetailService;

    // add new user profile
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        UserPricipl userPricipl = (UserPricipl) userDetailService.loadUserByUsername(userName);
        return userPricipl.getUser();
    }

    // add social link by user
    public SocialLink addSocialLink(int userId, SocialLink socialLink) throws UnautherizedUserException {
        User user = getCurrentUser();
        if(user.getId() != userId) {
            throw new UnautherizedUserException();
        }

        AbstractProfile profile = userDetailService.getUserProfile(user);

        socialLink.setProfile(profile);

        return socialLinkRepo.save(socialLink);
    }

    // remove social link by user
    public void removeSocialLink(int userId,  int socialLinkId) throws UnautherizedUserException {

        User user = getCurrentUser();
        if(user.getId() != userId) {
            throw new UnautherizedUserException();
        }

        SocialLink socialLink = socialLinkRepo.findById(socialLinkId).orElseThrow(()->new ResourceNotFoundException());

        socialLinkRepo.delete(socialLink);
    }

    public List<SocialLink> getUserSocialLinks(int userId) throws UnautherizedUserException {

        User user = getCurrentUser();
        if(user.getId() != userId) {
            throw new UnautherizedUserException();
        }

        return socialLinkRepo.findByProfile(user.getProfile());
    }
}
