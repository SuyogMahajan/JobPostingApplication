package com.suyog.SpringBootRest.models.authentication_models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;

@Entity
public class UserProfile {

    @MapsId
    @JsonBackReference
    @OneToOne(mappedBy = "userProfile")
    private User user;

    @Id
    private Long id;

    private String userName;
    private String fullName;
    private String title;
    private Integer experience;
    private String education;
    private String profilePicture;
    private String personalWebsite;
    private String nationality;
    private Date DOB;
    private String gender;
    private String maritalStatus;
    private String bio;

    @OneToMany(mappedBy = "userProfile")
    private List<Application> applications;

    @OneToMany(mappedBy = "userProfile")
    private List<SocialLink> socialLinks;

    @OneToMany(mappedBy = "userProfile")
    private List<Resume> resumes;

    @OneToOne(mappedBy = "userProfile")
    private ContactInfo contactInfo;

    @OneToOne(mappedBy = "userProfile")
    private NotificationSettings notificationSettings;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public List<SocialLink> getSocialLinks() {
        return socialLinks;
    }

    public void setSocialLinks(List<SocialLink> socialLinks) {
        this.socialLinks = socialLinks;
    }

    public void addSocialLink(SocialLink socialLink) {
        socialLinks.add(socialLink);
    }

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public NotificationSettings getNotificationSettings() {
        return notificationSettings;
    }

    public void setNotificationSettings(NotificationSettings notificationSettings) {
        this.notificationSettings = notificationSettings;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
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

    @Override
    public String toString() {
        return "UserProfile{" +
                "user=" + user +
                ", id=" + id +
                ", fullName='" + fullName + '\'' +
                ", title='" + title + '\'' +
                ", experience=" + experience +
                ", education='" + education + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                ", personalWebsite='" + personalWebsite + '\'' +
//                ", socialLinks=" + socialLinks +
//                ", resumes=" + resumes +
//                ", contactInfo=" + contactInfo +
//                ", notificationSettings=" + notificationSettings +
                '}';
    }
}
