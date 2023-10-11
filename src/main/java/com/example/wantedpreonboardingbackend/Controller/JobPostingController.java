package com.example.wantedpreonboardingbackend.Controller;

import com.example.wantedpreonboardingbackend.Dto.JobPostingEditDto;
import com.example.wantedpreonboardingbackend.Dto.JobPostingWriteDto;
import com.example.wantedpreonboardingbackend.Entity.JobPosting;
import com.example.wantedpreonboardingbackend.Service.JobPostingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;


    // detail job posting
    @GetMapping("/job_posting/{job_posting_id}")
    public String detailJobPostingPage(@PathVariable("job_posting_id") Long jobPostingId,
                                       HttpServletRequest request,
                                       Model model) {
        HttpSession session = request.getSession();
        Object companyIdObject = session.getAttribute("company_id");
        Long companyId = companyIdObject == null ? 0 : Long.parseLong(String.valueOf(companyIdObject));
        JobPosting jobPosting = jobPostingService.getJobPostingByJobPostingId(jobPostingId);
        model.addAttribute("job_posting", jobPosting);
        model.addAttribute("editable", jobPosting.getCompanyId() == companyId);
        return "jobPostingDetail";
    }

    // write job posting
    @GetMapping("/job_posting/write")
    public String writeJobPostingPage() {
        return "jobPostingWrite";
    }

    @PostMapping("/job_posting/write")
    public String writeJobPostingProcess(HttpServletRequest request,
                                         JobPostingWriteDto dto) {
        HttpSession session = request.getSession();
        Long companyId = Long.parseLong(String.valueOf(session.getAttribute("company_id")));
        jobPostingService.addJobPosting(dto, companyId);
        return "redirect:/";
    }

    // edit job posting
    @GetMapping("/job_posting/{job_posting_id}/edit")
    public String editJobPostingPage(@PathVariable("job_posting_id") Long jobPostingId,
                                     Model model) {
        JobPosting jobPosting = jobPostingService.getJobPostingByJobPostingId(jobPostingId);
        model.addAttribute("jobPostingId", jobPostingId);
        model.addAttribute("existingJobPosting", jobPosting);
        return "jobPostingEdit";
    }

    @PostMapping("/job_posting/{job_posting_id}/edit")
    public String editJobPostingProcess(@PathVariable("job_posting_id") Long jobPostingId,
                                        JobPostingEditDto dto) {
        jobPostingService.editJobPosting(jobPostingId, dto);
        return "redirect:/job_posting/" + String.valueOf(jobPostingId);
    }
}
