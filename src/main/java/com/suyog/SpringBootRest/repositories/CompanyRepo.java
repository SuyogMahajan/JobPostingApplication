package com.suyog.SpringBootRest.repositories;

import com.suyog.SpringBootRest.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

    Company findByName(String name);

}
