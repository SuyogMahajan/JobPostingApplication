package com.suyog.SpringBootRest.repositories.user_profile_repos;

import com.suyog.SpringBootRest.models.authentication_models.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResumeRepo extends JpaRepository<Resume, Integer> {

    // add resume by user

    // get resume by user

    // delete resume by user

}
