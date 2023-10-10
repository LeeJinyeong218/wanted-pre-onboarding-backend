package com.example.wantedpreonboardingbackend.Service;

import com.example.wantedpreonboardingbackend.Dto.CompanySignUpDto;
import com.example.wantedpreonboardingbackend.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public void addCompany(CompanySignUpDto dto) {
        companyRepository.save(dto.toEntity());
    }
}
