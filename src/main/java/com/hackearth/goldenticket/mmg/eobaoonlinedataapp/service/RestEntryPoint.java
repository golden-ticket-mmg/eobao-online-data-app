package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.service;

import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Company;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.CompanyType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("online-data")
@Slf4j
public class RestEntryPoint {

    private CompanyDetailsService companyDetailsService;

    public RestEntryPoint(CompanyDetailsService companyDetailsService) {
        this.companyDetailsService = companyDetailsService;
    }

    @GetMapping("/{arn}")
    public Company getCompany(@PathVariable String arn) {
        log.info("Looking for company by ARN {}", arn);
        Company company = companyDetailsService.findByArn(arn);
        log.info("For ARN {} found company {}", arn, company);
        return company;
    }

}