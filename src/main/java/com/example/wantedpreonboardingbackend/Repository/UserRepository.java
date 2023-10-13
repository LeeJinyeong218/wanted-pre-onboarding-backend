package com.example.wantedpreonboardingbackend.Repository;

import com.example.wantedpreonboardingbackend.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(String id);
    List<User> findAllByUserIdIn(List<Long> userIdList);
}
