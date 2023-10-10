package com.example.wantedpreonboardingbackend.Controller;

import com.example.wantedpreonboardingbackend.Dto.JobPostingWriteDto;
import com.example.wantedpreonboardingbackend.Service.JobPostingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

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
}
