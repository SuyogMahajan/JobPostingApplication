package com.suyog.SpringBootRest.models.DTO;

import java.util.Date;

public class JobFilterDTO {

    private String searchKeyword;
    private String locationKeyword;
    private String type[];
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

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
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
