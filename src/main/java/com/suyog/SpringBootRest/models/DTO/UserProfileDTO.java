package com.suyog.SpringBootRest.models.DTO;

import com.suyog.SpringBootRest.models.authentication_models.UserProfile;

import java.sql.Date;

public class UserProfileDTO {

    private String userName;
    private String fullName;
    private String title;
    private Integer experience;
    private String education;
    private String profilePicture;
    private String personalWebsite;
    private String nationality;
    private Date   DOB;
    private String gender;
    private String maritalStatus;
    private String bio;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getPersonalWebsite() {
        return personalWebsite;
    }

    public void setPersonalWebsite(String personalWebsite) {
        this.personalWebsite = personalWebsite;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public UserProfile userProfileBuilder() {
        UserProfile userProfile = new UserProfile();

        userProfile.setFullName(this.fullName);
        userProfile.setTitle(this.title);
        userProfile.setUserName(this.userName);
        userProfile.setExperience(this.experience);
        userProfile.setEducation(this.education);
        userProfile.setProfilePicture(this.profilePicture);
        userProfile.setPersonalWebsite(this.personalWebsite);

        userProfile.setNationality(this.nationality);
        userProfile.setDOB(this.DOB);
        userProfile.setGender(this.gender);
        userProfile.setMaritalStatus(this.maritalStatus);
        userProfile.setBio(this.bio);

        return userProfile;
    }

    @Override
    public String toString() {
        return "UserProfileDTO{" +
                "fullName='" + fullName + '\'' +
                ", title='" + title + '\'' +
                ", experience=" + experience +
                ", education='" + education + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", personalWebsite='" + personalWebsite + '\'' +
                '}';
    }
}

