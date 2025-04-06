package com.suyog.SpringBootRest.models.authentication_models;

import com.suyog.SpringBootRest.models.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("prototype")
@Entity
public class Application {

    @Id
    private Long id;
    private Date appliedDate;
    private String status;

    @OneToOne
    private UserProfile userProfile;

    @OneToOne// Pending, Accepted, Rejected
    private Resume resume;

    @ManyToOne
    private Job job;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(Date appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }


    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", appliedDate=" + appliedDate +
                ", status='" + status + '\'' +
                ", job=" + job +
                ", userProfile=" + userProfile.getId() +
                '}';
    }
}

