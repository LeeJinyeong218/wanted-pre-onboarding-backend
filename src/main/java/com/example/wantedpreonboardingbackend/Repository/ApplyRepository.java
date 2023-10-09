package com.example.wantedpreonboardingbackend.Repository;

import com.example.wantedpreonboardingbackend.Entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {
}
