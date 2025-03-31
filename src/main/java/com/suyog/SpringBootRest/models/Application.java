package com.suyog.SpringBootRest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("prototype")
@Entity
public class Application {
    // i am here
    @Id
    private Long id;
    private Date appliedDate;
    private String status; // Pending, Accepted, Rejected

    @ManyToOne
    private Job job;

    @ManyToOne
    private User applicant;

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

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", appliedDate=" + appliedDate +
                ", status='" + status + '\'' +
                ", job=" + job +
                ", applicant=" + applicant.getId() +
                '}';
    }
}

