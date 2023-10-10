package com.example.wantedpreonboardingbackend.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String homePage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        model.addAttribute("user_id", session.getAttribute("user_id"));
        return "home";
    }

    @PostMapping("/logout")
    public String userLogoutProcess(HttpServletRequest request) {
        request.getSession().invalidate();
        request.getSession(true);
        return "redirect:/";
    }
}
