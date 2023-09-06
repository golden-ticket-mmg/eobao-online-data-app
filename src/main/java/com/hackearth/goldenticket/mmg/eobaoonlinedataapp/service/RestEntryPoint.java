package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.service;

import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Company;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.CompanyType;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.GetStartedInfo;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.YourBusinessInfo;
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

    @GetMapping("/getstarted/{arn}")
    public GetStartedInfo getStarted(@PathVariable String arn) {
        log.info("Looking for get started information by ARN {}", arn);
        GetStartedInfo getStartedInfo = companyDetailsService.findGetStartedInfoByArn(arn);
        log.info("For ARN {} found get started info {}", arn, getStartedInfo);
        return getStartedInfo;
    }

    @GetMapping("/yourbusiness/{arn}")
    public YourBusinessInfo yourBusiness(@PathVariable String arn) {
        log.info("Looking for your business information by ARN {}", arn);
        YourBusinessInfo yourBusinessInfo = companyDetailsService.findYourBusinessInfoByArn(arn);
        log.info("For ARN {} found your business info {}", arn, yourBusinessInfo);
        return yourBusinessInfo;
    }

}