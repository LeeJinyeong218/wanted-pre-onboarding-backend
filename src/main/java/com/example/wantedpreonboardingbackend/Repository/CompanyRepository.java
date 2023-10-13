package com.example.wantedpreonboardingbackend.Repository;

import com.example.wantedpreonboardingbackend.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    Company findByCompanyId(Long companyId);
    Company findById(String id);
}
