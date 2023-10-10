package com.example.wantedpreonboardingbackend.Controller;

import com.example.wantedpreonboardingbackend.Constants;
import com.example.wantedpreonboardingbackend.Dto.CompanySignUpDto;
import com.example.wantedpreonboardingbackend.Entity.Company;
import com.example.wantedpreonboardingbackend.Service.CompanyService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/login-company")
    public String companyLoginPage() {
        return "companyLogin";
    }
    @GetMapping("/signup-company")
    public String companySignUpPage(Model model) {
        model.addAttribute("countriesAndLocations", Constants.COUNTRIES_LOCATIONS);
        return "companySignUp";
    }
    @PostMapping("/login-company")
    public String companyLoginProcess(HttpServletRequest request,
                                      String id, String password) {
        Company company = companyService.getCompanyById(id);

        if (company == null || !password.equals(company.getPassword())) {
            return "redirect:/login-company";
        }

        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3600);
        session.setAttribute("company_id", company.getCompanyId());
        session.setAttribute("id", company.getId());
        return "redirect:/";
    }

    @PostMapping("/signup-company")
    public String companySignUpProcess(CompanySignUpDto dto) {
        companyService.addCompany(dto);
        return "redirect:/";
    }
}
