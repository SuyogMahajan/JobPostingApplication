package com.suyog.SpringBootRest.repositories.user_profile_repos;


import com.suyog.SpringBootRest.models.authentication_models.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInfoRepo extends JpaRepository<ContactInfo, Integer> {

    // add contact email by user

    // add contact number by user

    // update contact email by user

    // update contact number by user

    // delete contact email by user

    // delete contact number by user
}
