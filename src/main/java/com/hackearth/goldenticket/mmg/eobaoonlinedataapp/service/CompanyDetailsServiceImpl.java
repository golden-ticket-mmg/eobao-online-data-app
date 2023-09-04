package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.service;

import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Company;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyDetailsServiceImpl implements CompanyDetailsService {

    private CompanyRepository companyRepository;
    CompanyDetailsServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company findByArn(String arn) {
        Optional<Company> optCompany = companyRepository.findById(arn);
        if (optCompany.isPresent()) {
            return optCompany.get();
        }
        throw new OnlineDataException(
                String.format("No company record found for arn=%s", arn));
    }
}
