package com.example.wantedpreonboardingbackend.Service;

import com.example.wantedpreonboardingbackend.Dto.UserSignUpDto;
import com.example.wantedpreonboardingbackend.Entity.User;
import com.example.wantedpreonboardingbackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(String id) {
        return userRepository.findById(id);
    }
    public void addUser(UserSignUpDto dto){
        userRepository.save(dto.toEntity());
    }
}
