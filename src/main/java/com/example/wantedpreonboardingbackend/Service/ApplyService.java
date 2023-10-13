package com.example.wantedpreonboardingbackend.Service;

import com.example.wantedpreonboardingbackend.Dto.ApplyAddDto;
import com.example.wantedpreonboardingbackend.Repository.ApplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {
    @Autowired
    private ApplyRepository applyRepository;

    public void addApply(Long jobPostingId, ApplyAddDto dto) {
        if (applyRepository.findByJobPostingIdAndUserId(jobPostingId, dto.getUserId()) == null) {
            applyRepository.save(dto.toEntityWithJobPostingId(jobPostingId));
        }
    }
}
