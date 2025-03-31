package com.suyog.SpringBootRest.models.authentication_models;

public class SocialLink {
    private Long id;
    private String type; // e.g., Twitter, LinkedIn
    private String url;
    private UserProfile userProfile;
}
