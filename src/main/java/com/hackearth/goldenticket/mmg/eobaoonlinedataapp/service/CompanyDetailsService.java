package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.service;

import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Company;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.GetStartedInfo;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.YourBusinessInfo;

import java.util.Optional;

public interface CompanyDetailsService {

    Company findByArn(String arn);

    GetStartedInfo findGetStartedInfoByArn(String arn);

    YourBusinessInfo findYourBusinessInfoByArn(String arn);
}
