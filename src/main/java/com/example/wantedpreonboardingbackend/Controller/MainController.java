package com.example.wantedpreonboardingbackend.Controller;

import com.example.wantedpreonboardingbackend.Service.JobPostingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private JobPostingService jobPostingService;

    @GetMapping("/")
    public String homePage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        model.addAttribute("id", session.getAttribute("id"));
        model.addAttribute("user_id", session.getAttribute("user_id"));
        model.addAttribute("company_id", session.getAttribute("company_id"));
        model.addAttribute("job_postings", jobPostingService.getJobPostings());
        return "home";
    }

    @PostMapping("/logout")
    public String userLogoutProcess(HttpServletRequest request) {
        request.getSession().invalidate();
        request.getSession(true);
        return "redirect:/";
    }
}
