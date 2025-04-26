package com.suyog.SpringBootRest.services;

import com.suyog.SpringBootRest.exceptions.UnautherizedUserException;
import com.suyog.SpringBootRest.models.DTO.UserProfileDTO;
import com.suyog.SpringBootRest.models.authentication_models.User;
import com.suyog.SpringBootRest.services.user_profile_services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;

@Service
public class FileService {

    @Autowired
    UserProfileService userProfileService;

    public Map<String, Object> uploadProfilePic(int userId , MultipartFile file, String type ) {
        // Generate a unique file name using UUID
        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        User user = userProfileService.getCurrentUser();
        if(user.getId() != userId) {
            throw new UnautherizedUserException();
        }

        String filePath = System.getProperty("user.dir")
                + File.separator + "upload"
                + File.separator + type
                + File.separator + uniqueFileName;

        String fileUploadStatus;
        Map<String, Object > response = new HashMap<>();
        try {
            FileOutputStream fout = new FileOutputStream(filePath);
            fout.write(file.getBytes());
            fout.close();

            UserProfileDTO userProfileDTO = new UserProfileDTO();
            userProfileDTO.setProfilePic(uniqueFileName);

            userProfileService.updateUserProfile(userId, userProfileDTO);
            fileUploadStatus = "File uploaded successfully with name: " + uniqueFileName;
            response.put("data",user);
        } catch (Exception e) {
            fileUploadStatus = "Error: " + e.getMessage();
        }
        response.put("message",fileUploadStatus);

        return response;
    }

    public Map<String, Object> uploadResume(int userId , MultipartFile file, String type ) {
        // Generate a unique file name using UUID
        String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();

        User user = userProfileService.getCurrentUser();
        if(user.getId() != userId) {
            throw new UnautherizedUserException();
        }

        String filePath = System.getProperty("user.dir")
                + File.separator + "upload"
                + File.separator + type
                + File.separator + uniqueFileName;

        String fileUploadStatus;
        Map<String, Object > response = new HashMap<>();
        try {
            FileOutputStream fout = new FileOutputStream(filePath);
            fout.write(file.getBytes());
            fout.close();

//            UserProfileDTO userProfileDTO = new UserProfileDTO();
//            userProfileDTO.setProfilePic(uniqueFileName);
//
//            userProfileService.updateUserProfile(userId, userProfileDTO);

            // resume logic


            fileUploadStatus = "File uploaded successfully with name: " + uniqueFileName;
//            response.put("data",user);
        } catch (Exception e) {
            fileUploadStatus = "Error: " + e.getMessage();
        }
        response.put("message",fileUploadStatus);

        return response;
    }

    public String[] getFiles(String type)
    {
        String folderPath = System.getProperty("user.dir") + File.separator + "upload"
                + File.separator + type;
        File directory = new File(folderPath);
        String[] files = directory.list();
        return files;
    }

    public InputStreamResource downloadFile(String type, String fileName) throws FileNotFoundException {

        String fileUploadPath =  System.getProperty("user.dir")
                + File.separator + "upload"
                + File.separator + type
                + File.separator + fileName;

        String[] fileList = this.getFiles(type);

        // Check if the file is present
        if (!Arrays.asList(fileList).contains(fileName))
            throw new FileNotFoundException("File not found");

        File file = new File(fileUploadPath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return resource;
    }
}
