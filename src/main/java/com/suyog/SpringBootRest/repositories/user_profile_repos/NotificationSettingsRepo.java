package com.suyog.SpringBootRest.repositories.user_profile_repos;


import com.suyog.SpringBootRest.models.authentication_models.NotificationSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationSettingsRepo extends JpaRepository<NotificationSettings, Integer> {

//    update notifyShortlisted by user
//    update notifyJobAlerts by user
//    update notifyAppliedJobsExpiry by user
//    update notifyProfileSaved by user

}
