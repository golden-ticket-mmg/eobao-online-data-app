package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Companies;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Company;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo.CompanyRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.InputStream;

@Service
@Slf4j
public class DataPopulator {

    @Autowired
    private CompanyRepository companyRepository;

    @PostConstruct
    @SneakyThrows
    public void init() {
        log.info("Pre-population company data ...");
        InputStream in
                = this.getClass().getClassLoader().getResourceAsStream("companies.json");
        ObjectMapper mapper = new ObjectMapper();
        Companies companies = mapper.readValue(in, Companies.class);
        log.info("Companies={} loaded", companies.getCompanies().size());
        companies.getCompanies().stream().forEach(c -> companyRepository.save(c));
    }
}
