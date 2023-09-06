package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.*;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo.CompanyRepository;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo.GetStartedInfoRepository;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo.YourBusinessInfoRepository;
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

    @Autowired
    private GetStartedInfoRepository getStartedInfoRepository;

    @Autowired
    private YourBusinessInfoRepository yourBusinessInfoRepository;

    @PostConstruct
    @SneakyThrows
    public void init() {

        InputStream in = null;
        ObjectMapper mapper = new ObjectMapper();

        log.info("Pre-population company data ...");
        in = this.getClass().getClassLoader().getResourceAsStream("companies.json");
        Companies companies = mapper.readValue(in, Companies.class);
        log.info("Companies={} loaded", companies.getCompanies().size());
        companies.getCompanies().stream().forEach(c -> companyRepository.save(c));

        log.info("Pre-population get started info data ...");
        in = this.getClass().getClassLoader().getResourceAsStream("getstartedinfos.json");
        GetStartedInfos getStartedInfos = mapper.readValue(in, GetStartedInfos.class);
        log.info("GetStartedInfos={} loaded", getStartedInfos.getGetstartedinfos().size());
        getStartedInfos.getGetstartedinfos().stream().forEach(c -> getStartedInfoRepository.save(c));

        log.info("Pre-population your business info data ...");
        in = this.getClass().getClassLoader().getResourceAsStream("yourbusinessinfos.json");
        YourBusinessInfos yourBusinessInfos = mapper.readValue(in, YourBusinessInfos.class);
        log.info("YourBusinessInfos={} loaded", yourBusinessInfos.getYourbusinessinfos().size());
        yourBusinessInfos.getYourbusinessinfos().stream().forEach(c -> yourBusinessInfoRepository.save(c));
    }



}
