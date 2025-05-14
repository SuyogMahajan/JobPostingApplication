package com.suyog.SpringBootRest.models.authentication_models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class SocialLink {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type; // e.g., Twitter, LinkedIn
    private String url;

    @JsonBackReference
    @ManyToOne
    private AbstractProfile profile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AbstractProfile getProfile() {
        return profile;
    }

    public void setProfile(AbstractProfile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "SocialLink{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", userProfile=" + profile.getId() +
                '}';
    }
}
