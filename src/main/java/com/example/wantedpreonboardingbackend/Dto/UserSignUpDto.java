package com.example.wantedpreonboardingbackend.Dto;

import com.example.wantedpreonboardingbackend.Entity.User;
import lombok.Data;

@Data
public class UserSignUpDto {
    private String id;
    private String password;
    private String name;

    public User toEntity() {
        return User.builder()
                .id(this.id)
                .password(this.password)
                .name(name)
                .selfIntro(null)
                .build();
    }
}
