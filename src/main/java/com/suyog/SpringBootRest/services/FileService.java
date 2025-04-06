package com.suyog.SpringBootRest.services;

import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

@Service
public class FileService {

    public String uploadFile(MultipartFile file, String type ) {

        String filePath = System.getProperty("user.dir")
                + File.separator + "upload"
                + File.separator + type
                + File.separator + file.getOriginalFilename();

        String fileUploadStatus;

        try {
            FileOutputStream fout = new FileOutputStream(filePath);
            fout.write(file.getBytes());
            fout.close();

            fileUploadStatus = "file uploaded successfuly";
        }catch (Exception e) {
            fileUploadStatus = "Error : " + e.getMessage();
        }

        return fileUploadStatus;
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

        //Check if the file is present
        if (!Arrays.asList(fileList).contains(fileName))
            throw new FileNotFoundException("File not found");

        File file = new File(fileUploadPath);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return resource;

    }
}
