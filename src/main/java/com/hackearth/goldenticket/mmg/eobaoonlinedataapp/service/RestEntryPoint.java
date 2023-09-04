package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.service;

import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.CompanyDetails;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.CompanyType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("online-data")
public class RestEntryPoint {

    @GetMapping("/{arn}")
    public CompanyDetails getBook(@PathVariable String arn) {
        return findBookById(arn);
    }

    private CompanyDetails findBookById(String id) {
        return CompanyDetails.builder()
                .arn("1234")
                .companyName("Big Company Ltd")
                .companyType(CompanyType.LTD)
                .build();
    }
}