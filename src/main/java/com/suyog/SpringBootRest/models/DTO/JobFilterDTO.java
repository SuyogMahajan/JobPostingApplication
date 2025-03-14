package com.suyog.SpringBootRest.models.DTO;

import com.suyog.SpringBootRest.models.JobType;

import java.util.Date;
import java.util.List;

public class JobFilterDTO {

    private String searchKeyword;
    private String locationKeyword;
    private List<JobType> type;
    private Double minSalary;
    private Double maxSalary;
    private Date postingDate;

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getLocationKeyword() {
        return locationKeyword;
    }

    public void setLocationKeyword(String locationKeyword) {
        this.locationKeyword = locationKeyword;
    }

    public List<JobType> getType() {
        return type;
    }

    public void setType(List<JobType> type) {
        this.type = type;
    }

    public Double getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(Double minSalary) {
        this.minSalary = minSalary;
    }

    public Double getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(Double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(Date postingDate) {
        this.postingDate = postingDate;
    }
}
