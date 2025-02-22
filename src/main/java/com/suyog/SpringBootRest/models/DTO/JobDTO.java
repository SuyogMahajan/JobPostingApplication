package com.suyog.SpringBootRest.models.DTO;

import com.suyog.SpringBootRest.models.Job;

import java.util.Date;

public class JobDTO {

    private String title;
    private String description;
    private String type; // Full-Time, Part-Time, Internship
    private String location;
    private Double salaryMin;
    private Double salaryMax;
    private Date postedDate;
    private Date expiryDate;

    public JobDTO(String title, String description, String type, String location, Double salaryMin, Double salaryMax, Date postedDate, Date expiryDate) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.location = location;
        this.salaryMin = salaryMin;
        this.salaryMax = salaryMax;
        this.postedDate = postedDate;
        this.expiryDate = expiryDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Double salaryMin) {
        this.salaryMin = salaryMin;
    }

    public Double getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Double salaryMax) {
        this.salaryMax = salaryMax;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "JobDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", salaryMin=" + salaryMin +
                ", salaryMax=" + salaryMax +
                ", postedDate=" + postedDate +
                ", expiryDate=" + expiryDate +
                '}';
    }

    // -------------------------------------------------------------------------

    public Job getJob() {
        Job job = new Job();

        job.setTitle(this.title);
        job.setDescription(this.description);
        job.setExpiryDate(this.expiryDate);
        job.setLocation(this.location);
        job.setType(this.type);
        job.setPostedDate(this.postedDate);
        job.setSalaryMax(this.salaryMax);
        job.setSalaryMin(this.salaryMin);

        return job;
    }
}
