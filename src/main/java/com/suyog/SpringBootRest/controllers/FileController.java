package com.suyog.SpringBootRest.controllers;

import com.suyog.SpringBootRest.constants.AppConstants;
import com.suyog.SpringBootRest.services.FileService;
import com.suyog.SpringBootRest.services.user_profile_services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

@RestController
@RequestMapping(AppConstants.API_BASE_PATH+"/file")
public class FileController {
    @Autowired
    private FileService fileService;

    @Autowired
    private UserProfileService userProfileService;
    //Method to upload a file
//    @PostMapping("/upload/resume/{userId}")
//    public String uploadResumeFile(@PathVariable int userId,@RequestParam("file") MultipartFile file)
//    {
//        return  fileService.uploadFile(userId, file, "resumes");
//    }

    @PostMapping("/upload/profile_pics/{userId}")
    public ResponseEntity<?> uploadProfilePhoto(@PathVariable int userId, @RequestParam("file") MultipartFile file) {
        return ResponseEntity.ok(fileService.uploadProfilePic(userId, file, "profile_pics"));
    }

    @PostMapping("/upload/resume/{userId}")
    public ResponseEntity<?> uploadResume(@PathVariable int userId, @RequestParam("file") MultipartFile file) {

        fileService.uploadResume(userId,file,"resumes");


    }

    @GetMapping("/download/{type}/{path:.+}")
    public ResponseEntity downloadFile(@PathVariable String type, @PathVariable(value = "path") String fileName) throws FileNotFoundException {
        try {
            InputStreamResource resource = fileService.downloadFile(type, fileName);

            HttpHeaders headers = new HttpHeaders();

            MediaType mediaType;
            String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();

            switch (extension) {
                case "jpg":
                case "jpeg":
                    mediaType = MediaType.IMAGE_JPEG;
                    break;
                case "png":
                    mediaType = MediaType.IMAGE_PNG;
                    break;
                case "gif":
                    mediaType = MediaType.IMAGE_GIF;
                    break;
                default:
                    mediaType = MediaType.APPLICATION_OCTET_STREAM;
            }
            System.out.println(type);
            if (!type.equals("company_logos") && !type.equals("profile_pics"))
                mediaType = MediaType.APPLICATION_OCTET_STREAM;

            System.out.println(mediaType);
            return ResponseEntity.ok()
                    .contentType(mediaType)
                    .body(resource);
        } catch (FileNotFoundException e) {
            return ResponseEntity.ok("file not found");
        } catch (Exception e) {
            return ResponseEntity.ok("Something went wrong");
        }
    }
}