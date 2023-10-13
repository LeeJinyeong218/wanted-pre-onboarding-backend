package com.example.wantedpreonboardingbackend.Repository;

import com.example.wantedpreonboardingbackend.Entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {
    Apply findByJobPostingIdAndUserId(Long jobPostingId, Long UserId);

    List<Apply> findByJobPostingId(Long jobPostingId);
    List<Apply> findByUserId(Long userId);
}
