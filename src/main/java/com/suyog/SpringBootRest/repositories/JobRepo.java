package com.suyog.SpringBootRest.repositories;

import com.suyog.SpringBootRest.models.Job;
import com.suyog.SpringBootRest.models.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface JobRepo extends JpaRepository<Job, Integer> {
    @Query("Select j from Job j where " +
            "(  :searchKeyword is null or" +
            "       upper(j.title) like upper(concat('%',:searchKeyword,'%')) or" +
            "       upper(j.description) like upper(concat('%',:searchKeyword,'%'))  ) AND" +
            "(  :locationKeyword is null or " +
            "       upper(j.location) like upper(concat('%',:locationKeyword,'%'))   ) AND" +
            "(  :type is null or j.type in :type ) AND" +
            "(  :minSalary is null or j.salaryMin >= :minSalary       ) AND" +
            "(  :postingDate is null or j.postedDate = :postingDate )")
    List<Job> getFilteredJobs(String searchKeyword,
                              String locationKeyword,
                              List<JobType> type,
                              Double minSalary,
                              Double maxSalary,
                              Date postingDate);
}
