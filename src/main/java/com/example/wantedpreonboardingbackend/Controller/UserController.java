package com.example.wantedpreonboardingbackend.Controller;

import com.example.wantedpreonboardingbackend.Dto.UserSignUpDto;
import com.example.wantedpreonboardingbackend.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login-user")
    public String userLoginPage(){
        return "userLogin";
    }

    @GetMapping("/signup-user")
    public String userSignUpPage() {
        return "userSignUp";
    }

    @PostMapping("/signup-user/add")
    public String userSignupProcess(UserSignUpDto dto) {
        userService.addUser(dto);
        return "redirect:/";
    }
}
