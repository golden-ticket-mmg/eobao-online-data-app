package com.hackearth.goldenticket.mmg.eobaoonlinedataapp.repo;

import com.hackearth.goldenticket.mmg.eobaoonlinedataapp.data.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {
}
