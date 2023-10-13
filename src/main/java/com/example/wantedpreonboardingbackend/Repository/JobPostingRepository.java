package com.example.wantedpreonboardingbackend.Repository;

import com.example.wantedpreonboardingbackend.Entity.JobPosting;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    List<JobPosting> findAllByOrderByJobPostingIdDesc();
    JobPosting findByJobPostingId(Long jobPostingId);
    @Query(
            value = "SELECT * FROM job_posting jp " +
                    "WHERE jp.title LIKE %:searchWord% OR jp.content LIKE %:searchWord% " +
                    "OR jp.position LIKE %:searchWord% OR jp.required_skill LIKE %:searchWord% " +
                    "ORDER BY jp.job_posting_id DESC",
            nativeQuery = true
    )
    List<JobPosting> findAllAboutSearchWord(String searchWord);

    List<JobPosting> findAllByCompanyIdOrderByJobPostingIdDesc(Long companyId);
}
