package com.example.wantedpreonboardingbackend.Service;

import com.example.wantedpreonboardingbackend.Dto.UserSignUpDto;
import com.example.wantedpreonboardingbackend.Entity.Apply;
import com.example.wantedpreonboardingbackend.Entity.User;
import com.example.wantedpreonboardingbackend.Repository.ApplyRepository;
import com.example.wantedpreonboardingbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApplyRepository applyRepository;

    public User getUserById(String id) {
        return userRepository.findById(id);
    }
    public void addUser(UserSignUpDto dto){
        userRepository.save(dto.toEntity());
    }

    public List<User> getUserFromApplyByJobPostingId(Long jobPostingId) {
        List<Apply> applies = applyRepository.findByJobPostingId(jobPostingId);
        List<Long> userIdList = applies.stream().map(u -> u.getUserId()).toList();
        return userRepository.findAllByUserIdIn(userIdList);
    }
}
