package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.service;

import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Company;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.GetStartedInfo;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.YourBusinessInfo;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo.CompanyRepository;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo.GetStartedInfoRepository;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo.YourBusinessInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class CompanyDetailsServiceImpl implements CompanyDetailsService {

    private CompanyRepository companyRepository;
    private GetStartedInfoRepository getStartedInfoRepository;
    private YourBusinessInfoRepository yourBusinessInfoRepository;

    CompanyDetailsServiceImpl(CompanyRepository companyRepository,
                              GetStartedInfoRepository getStartedInfoRepository,
                              YourBusinessInfoRepository yourBusinessInfoRepository
                              ) {
        this.companyRepository = companyRepository;
        this.getStartedInfoRepository = getStartedInfoRepository;
        this.yourBusinessInfoRepository = yourBusinessInfoRepository;
    }

    @Override
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

    @Override
    public GetStartedInfo findGetStartedInfoByArn(String arn) {
        log.info("Looking for get started info by ARN {} in repo", arn);
        Optional<GetStartedInfo> getStartedInfoOpt = getStartedInfoRepository.findById(arn);
        if (getStartedInfoOpt.isPresent()) {
            log.info("Found for ARN {} get started info {}", arn, getStartedInfoOpt.get());
            return getStartedInfoOpt.get();
        }
        throw new OnlineDataException(
                String.format("No get started info found for arn=%s", arn));
    }

    @Override
    public YourBusinessInfo findYourBusinessInfoByArn(String arn) {
        log.info("Looking for your business info by ARN {} in repo", arn);
        Optional<YourBusinessInfo> yourBusinessInfoOpt = yourBusinessInfoRepository.findById(arn);
        if (yourBusinessInfoOpt.isPresent()) {
            log.info("Found for ARN {} your business info {}", arn, yourBusinessInfoOpt.get());
            return yourBusinessInfoOpt.get();
        }
        throw new OnlineDataException(
                String.format("No your business info found for arn=%s", arn));
    }
}
