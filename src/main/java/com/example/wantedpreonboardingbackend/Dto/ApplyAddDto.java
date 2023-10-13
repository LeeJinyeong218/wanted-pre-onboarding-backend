package com.example.wantedpreonboardingbackend.Dto;

import com.example.wantedpreonboardingbackend.Entity.Apply;
import lombok.Data;

@Data
public class ApplyAddDto {
    private Long companyId;
    private Long userId;

    public Apply toEntityWithJobPostingId(Long jobPostingId) {
        return Apply.builder()
                .jobPostingId(jobPostingId)
                .companyId(this.companyId)
                .userId(this.userId)
                .build();
    }
}
