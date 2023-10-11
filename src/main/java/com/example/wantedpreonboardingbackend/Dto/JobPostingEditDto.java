package com.example.wantedpreonboardingbackend.Dto;

import com.example.wantedpreonboardingbackend.Entity.JobPosting;
import lombok.Data;

@Data
public class JobPostingEditDto {
    private Long recruitmentCompensation;
    private String title;
    private String position;
    private String content;
    private String requiredSkill;
}
