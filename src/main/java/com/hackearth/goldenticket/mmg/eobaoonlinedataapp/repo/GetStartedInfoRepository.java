package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo;

import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Company;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.GetStartedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetStartedInfoRepository extends JpaRepository<GetStartedInfo, String> {
}
