package com.example.wantedpreonboardingbackend.Controller;

import com.example.wantedpreonboardingbackend.Dto.ApplyAddDto;
import com.example.wantedpreonboardingbackend.Service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    // user function
    @PostMapping("/job_posting/{job_posting_id}/apply")
    public String applyProcess(@PathVariable("job_posting_id") Long jobPostingId, ApplyAddDto dto) {
        applyService.addApply(jobPostingId, dto);
        return "redirect:/";
    }
}
