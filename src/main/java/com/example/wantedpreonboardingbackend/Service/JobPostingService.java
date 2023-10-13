package com.example.wantedpreonboardingbackend.Service;

import com.example.wantedpreonboardingbackend.Dto.JobPostingEditDto;
import com.example.wantedpreonboardingbackend.Dto.JobPostingWriteDto;
import com.example.wantedpreonboardingbackend.Entity.JobPosting;
import com.example.wantedpreonboardingbackend.Repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingService {
    @Autowired
    private JobPostingRepository jobPostingRepository;

    public List<JobPosting> getJobPostings() {
        return jobPostingRepository.findAllByOrderByJobPostingIdDesc();
    }

    public JobPosting getJobPostingByJobPostingId(Long jobPostingId) {
        return jobPostingRepository.findByJobPostingId(jobPostingId);
    }
    public List<JobPosting> getJobPostingsBySearchWord(String searchWord) {
        return jobPostingRepository.findAllAboutSearchWord(searchWord);
    }
    public List<JobPosting> getJobPostingsByCompanyId(Long companyId) {
        return jobPostingRepository.findAllByCompanyIdOrderByJobPostingIdDesc(companyId);
    }
    public void addJobPosting(JobPostingWriteDto dto, Long companyId) {
        jobPostingRepository.save(dto.toEntityWithCompanyId(companyId));
    }

    public void editJobPosting(Long jobPostingId, JobPostingEditDto dto) {
        JobPosting existingJobPosting = jobPostingRepository.findByJobPostingId(jobPostingId);
        existingJobPosting.setRecruitmentCompensation(dto.getRecruitmentCompensation());
        existingJobPosting.setTitle(dto.getTitle());
        existingJobPosting.setPosition(dto.getPosition());
        existingJobPosting.setContent(dto.getContent());
        existingJobPosting.setRequiredSkill(dto.getRequiredSkill());
        jobPostingRepository.save(existingJobPosting);
    }

    public void deleteJobPosting(Long jobPostingId) {
        jobPostingRepository.delete(jobPostingRepository.findByJobPostingId(jobPostingId));
    }
}
