package com.suyog.SpringBootRest.repositories.user_profile_repos;

import com.suyog.SpringBootRest.models.authentication_models.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationsRepo extends JpaRepository<Application, Integer> {

}
