package com.example.wantedpreonboardingbackend.Controller;

import com.example.wantedpreonboardingbackend.Dto.UserSignUpDto;
import com.example.wantedpreonboardingbackend.Entity.User;
import com.example.wantedpreonboardingbackend.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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

    @PostMapping("/login-user")
    public String userLoginProcess(HttpServletRequest request,
                                   String id, String password) {
        User user = userService.getUserById(id);
        if (user == null || !password.equals(user.getPassword())) {
            return "redirect:/login-user";
        }
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(3600);
        session.setAttribute("user_id", user.getUserId());
        session.setAttribute("id", user.getId());
        return "redirect:/";
    }



    @PostMapping("/signup-user/add")
    public String userSignupProcess(UserSignUpDto dto) {
        userService.addUser(dto);
        return "redirect:/";
    }
}
