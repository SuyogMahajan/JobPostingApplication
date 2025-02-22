package com.suyog.SpringBootRest.services;

import com.suyog.SpringBootRest.models.Company;
import com.suyog.SpringBootRest.repositories.CompanyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    CompanyRepo companyRepo;

    public Company createCompany(Company company) {
        return companyRepo.save(company);
    }

    public Company getCompanyById(int id) {
        return companyRepo.findById(id).get();
    }

    public Company getCompanyByName(String name) {
        return companyRepo.findByName(name);
    }

    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }
}
