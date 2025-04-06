package com.suyog.SpringBootRest.controllers;

import com.suyog.SpringBootRest.constants.AppConstants;
import com.suyog.SpringBootRest.services.FileService;
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
public class FileController
{
    @Autowired
    private FileService fileService;
    //Method to upload a file
    @PostMapping("/upload/resume")
    public String uploadResumeFile(@RequestParam("file") MultipartFile file)
    {
        return  fileService.uploadFile(file, "resumes");
    }

    @PostMapping("/upload/profile")
    public String uploadProfilePhoto(@RequestParam("file") MultipartFile file)
    {
        return fileService.uploadFile(file, "profiles");
    }

    @GetMapping("/download/{type}/{path:.+}")
    public ResponseEntity downloadFile (@PathVariable String type, @PathVariable(value = "path") String fileName) throws FileNotFoundException
    {
       try{
           InputStreamResource resource = fileService.downloadFile(type, fileName);

           HttpHeaders headers = new HttpHeaders();
           String contentType = "application/octet-stream";
           String headerValue = "attachment; filename=\"" + fileName + "\"";

           return ResponseEntity.ok()
                   .contentType(MediaType.parseMediaType(contentType))
                   .header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
                   .body(resource);
       }catch(FileNotFoundException e) {
           return ResponseEntity.ok("file not found");
       }catch (Exception e) {
           return ResponseEntity.ok("Something went wrong");
       }

    }


}