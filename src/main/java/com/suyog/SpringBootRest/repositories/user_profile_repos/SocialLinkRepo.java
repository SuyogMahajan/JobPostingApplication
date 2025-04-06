package com.suyog.SpringBootRest.repositories.user_profile_repos;

import com.suyog.SpringBootRest.models.authentication_models.SocialLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialLinkRepo extends JpaRepository<SocialLink, Integer> {

    // add social link by user

    // remove social link by user

}
