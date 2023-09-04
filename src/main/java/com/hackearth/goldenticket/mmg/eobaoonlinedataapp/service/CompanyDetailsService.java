package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.service;

import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Company;

import java.util.Optional;

public interface CompanyDetailsService {

    Company findByArn(String arn);
}
