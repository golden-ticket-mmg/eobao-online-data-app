package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo;

import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Company;
import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.YourBusinessInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YourBusinessInfoRepository extends JpaRepository<YourBusinessInfo, String> {
}
