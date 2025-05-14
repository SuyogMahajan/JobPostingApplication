package com.suyog.SpringBootRest.services.user_profile_services;

import com.suyog.SpringBootRest.models.authentication_models.HRProfile;
import com.suyog.SpringBootRest.models.authentication_models.ProfileServiceInterface;
import com.suyog.SpringBootRest.models.authentication_models.User;
import com.suyog.SpringBootRest.repositories.user_profile_repos.HRProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HRProfileService implements ProfileServiceInterface {

    @Autowired
    HRProfileRepo hrProfileRepo;

    @Override
    public HRProfile addNewProfile(User user) {
        HRProfile hrProfile = new HRProfile();

        hrProfile.setUser(user);
        hrProfile.setUserName(user.getUserName());
        hrProfile.setFullName(user.getFullName());
        user.setProfile(hrProfile);

        return hrProfileRepo.save(hrProfile);
    }
}
