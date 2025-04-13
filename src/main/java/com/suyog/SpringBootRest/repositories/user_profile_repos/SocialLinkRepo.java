package com.suyog.SpringBootRest.repositories.user_profile_repos;

import com.suyog.SpringBootRest.models.authentication_models.SocialLink;
import com.suyog.SpringBootRest.models.authentication_models.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialLinkRepo extends JpaRepository<SocialLink, Integer> {
    List<SocialLink> findByUserProfile(UserProfile userProfile);

    // add social link by user

    // remove social link by user

}
