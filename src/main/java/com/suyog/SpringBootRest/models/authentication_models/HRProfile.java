package com.suyog.SpringBootRest.models.authentication_models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.suyog.SpringBootRest.models.Company;
import com.suyog.SpringBootRest.models.Job;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class HRProfile extends AbstractProfile{

    @MapsId
    @JsonBackReference
    @OneToOne(mappedBy = "profile")
    private User user;

    @ManyToOne
    private Company company;

    @OneToMany(mappedBy = "jobPoster")
    private List<Job> jobPostings;

//    @OneToMany
//    private List<UserProfile> savedApplicants;

    private String userName;
    private String fullName;
    private String profilePicture;
    private String nationality;
    private String gender;

//    @JsonManagedReference
//    @OneToOne(mappedBy = "userProfile",fetch = FetchType.EAGER)
//    private NotificationSettings notificationSettings;
//


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
