package com.suyog.SpringBootRest.models.authentication_models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class NotificationSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean notifyShortlisted;
    private Boolean notifyJobAlerts;
    private Boolean notifyAppliedJobsExpiry;
    private Boolean notifyProfileSaved;


    @JsonBackReference
    @OneToOne
    private UserProfile userProfile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getNotifyShortlisted() {
        return notifyShortlisted;
    }

    public void setNotifyShortlisted(Boolean notifyShortlisted) {
        this.notifyShortlisted = notifyShortlisted;
    }

    public Boolean getNotifyJobAlerts() {
        return notifyJobAlerts;
    }

    public void setNotifyJobAlerts(Boolean notifyJobAlerts) {
        this.notifyJobAlerts = notifyJobAlerts;
    }

    public Boolean getNotifyAppliedJobsExpiry() {
        return notifyAppliedJobsExpiry;
    }

    public void setNotifyAppliedJobsExpiry(Boolean notifyAppliedJobsExpiry) {
        this.notifyAppliedJobsExpiry = notifyAppliedJobsExpiry;
    }

    public Boolean getNotifyProfileSaved() {
        return notifyProfileSaved;
    }

    public void setNotifyProfileSaved(Boolean notifyProfileSaved) {
        this.notifyProfileSaved = notifyProfileSaved;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    @Override
    public String toString() {
        return "NotificationSettings{" +
                "id=" + id +
                ", notifyShortlisted=" + notifyShortlisted +
                ", notifyJobAlerts=" + notifyJobAlerts +
                ", notifyAppliedJobsExpiry=" + notifyAppliedJobsExpiry +
                ", notifyProfileSaved=" + notifyProfileSaved +
                ", userProfile=" + userProfile.getId() +
                '}';
    }
}
