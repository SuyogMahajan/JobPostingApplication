package com.suyog.SpringBootRest.models.authentication_models;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserProfile {

    @OneToOne(mappedBy = "userProfile")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String title;
    private Integer experience;
    private String education;
    private String profilePicture;
    private String personalWebsite;

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
