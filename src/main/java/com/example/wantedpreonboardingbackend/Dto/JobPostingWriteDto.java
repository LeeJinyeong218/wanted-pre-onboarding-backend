package com.example.wantedpreonboardingbackend.Dto;

import com.example.wantedpreonboardingbackend.Entity.JobPosting;
import lombok.Data;

@Data
public class JobPostingWriteDto {
    private Long recruitmentCompensation;
    private String title;
    private String position;
    private String content;
    private String requiredSkill;

    public JobPosting toEntityWithCompanyId(Long companyId) {
        return JobPosting.builder()
                .companyId(companyId)
                .recruitmentCompensation(this.recruitmentCompensation)
                .title(this.title)
                .position(this.position)
                .content(this.content)
                .requiredSkill(this.requiredSkill)
                .build();
    }
}
