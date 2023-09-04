package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CompanyDetails {
    private String arn;
    private String companyName;

    private CompanyType companyType;

}
