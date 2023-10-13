package com.example.wantedpreonboardingbackend.Controller;

import com.example.wantedpreonboardingbackend.Dto.JobPostingEditDto;
import com.example.wantedpreonboardingbackend.Dto.JobPostingWriteDto;
import com.example.wantedpreonboardingbackend.Entity.JobPosting;
import com.example.wantedpreonboardingbackend.Repository.ApplyRepository;
import com.example.wantedpreonboardingbackend.Service.CompanyService;
import com.example.wantedpreonboardingbackend.Service.JobPostingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    @Autowired
    private CompanyService companyService;

    // common function

    // detail job posting
    @GetMapping("/job_posting/{job_posting_id}")
    public String detailJobPostingPage(@PathVariable("job_posting_id") Long jobPostingId,
                                       HttpServletRequest request,
                                       Model model) {
        HttpSession session = request.getSession();
        Object companyIdObject = session.getAttribute("company_id");
        Object userIdObject = session.getAttribute("user_id");
        Long companyId = companyIdObject == null ? 0 : Long.parseLong(String.valueOf(companyIdObject));
        JobPosting jobPosting = jobPostingService.getJobPostingByJobPostingId(jobPostingId);
        model.addAttribute("job_posting", jobPosting);
        model.addAttribute("editable", jobPosting.getCompanyId() == companyId);
        model.addAttribute("user_id", userIdObject == null? null : Long.parseLong(String.valueOf(userIdObject)));
        return "jobPostingDetail";
    }

    // search job posting with keyword
    @GetMapping("/job_posting/search")
    public String searchJobPostingProcess(@RequestParam String searchWord, Model model) {
        model.addAttribute("search_word", searchWord);
        model.addAttribute("job_postings", jobPostingService.getJobPostingsBySearchWord(searchWord));
        return "jobPostingSearch";
    }

    // company function

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

    // delete job posting
    @PostMapping("/job_posting/{job_posting_id}/delete")
    public String deleteJobPostingProcess(@PathVariable("job_posting_id") Long jobPostingId) {
        jobPostingService.deleteJobPosting(jobPostingId);
        return "redirect:/";
    }

    // view company's job postings
    @GetMapping("/job_posting/list")
    public String listCompanyJobPostingPage(HttpServletRequest request,
                                            Model model) {
        HttpSession session = request.getSession();
        Object companyIdObject = session.getAttribute("company_id");
        if (companyIdObject == null) {
            return "redirect:/";
        }
        Long companyId = Long.parseLong(String.valueOf(companyIdObject));
        model.addAttribute("company", companyService.getCompanyByCompanyId(companyId));
        model.addAttribute("job_postings", jobPostingService.getJobPostingsByCompanyId(companyId));
        return "jobPostingCompanyList";
    }


}
