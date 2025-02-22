package com.suyog.SpringBootRest.controllers;

import com.suyog.SpringBootRest.constants.AppConstants;
import com.suyog.SpringBootRest.models.Company;
import com.suyog.SpringBootRest.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(AppConstants.API_BASE_PATH)
public class CompanyController {

    @Autowired
    CompanyService companyService;

    public static final String uploadPath = "upload/company_logos";

    @GetMapping("companies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("company/{id}")
    public Company getCompanyById(@PathVariable int id) {
        return companyService.getCompanyById(id);
    }

    @GetMapping("company")
    public Company getCompanyById(@RequestParam String name) {
        return companyService.getCompanyByName(name);
    }

    @PostMapping("company")
    public Company createCompany(   @RequestParam String name,
                               @RequestParam String location,
                               @RequestParam MultipartFile image
                               ) {

        try {
             String uniqueFileName = UUID.randomUUID()+"_"+image.getOriginalFilename();
             Path filePath = Path.of(uploadPath,uniqueFileName);

             Files.createDirectories(filePath.getParent());
             Files.write(filePath,image.getBytes());

             Company company = new Company();
             company.setName(name);
             company.setLocation(location);
             company.setLogo_file_name(uniqueFileName);

             return companyService.createCompany(company);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
