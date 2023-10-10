package com.example.wantedpreonboardingbackend.Dto;

import com.example.wantedpreonboardingbackend.Entity.Company;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class CompanySignUpDto {
    private String id;
    private String password;
    private String name;
    private String country;
    private String location;
    private String detailAddress;

    public Company toEntity(){
        return Company.builder()
                .id(this.id)
                .password(this.password)
                .name(this.name)
                .country(this.country)
                .location(this.location)
                .detailAddress(this.detailAddress)
                .build();
    }
}
