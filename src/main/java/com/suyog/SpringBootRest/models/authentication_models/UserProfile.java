package com.suyog.SpringBootRest.models.authentication_models;


import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class UserProfile {

    private User user;
    private Long id;
    private String fullName;
    private String title;
    private Integer experience;
    private String education;
    private String profilePicture;
    private String personalWebsite;
    private List<SocialLink> socialLinks;
    private List<Resume> resumes;
    private ContactInfo contactInfo;
    private NotificationSettings notificationSettings;

}
