package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.service;

import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Company;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CompanyDetailsServiceImpl implements CompanyDetailsService {

    private CompanyRepository companyRepository;
    CompanyDetailsServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company findByArn(String arn) {
        log.info("Looking for company by ARN {} in repo", arn);
        Optional<Company> optCompany = companyRepository.findById(arn);
        if (optCompany.isPresent()) {
            log.info("Found for ARN {} company {}", arn, optCompany.get());
            return optCompany.get();
        }
        throw new OnlineDataException(
                String.format("No company record found for arn=%s", arn));
    }
}
