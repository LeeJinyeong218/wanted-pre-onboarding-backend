package com.example.wantedpreonboardingbackend.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class JobPosting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_posting_id")
    private Long jobPostingId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "recruitment_compensation")
    private Long recruitmentCompensation;

    @Column(name = "title")
    private String title;

    @Column(name = "position")
    private String position;

    @Column(name = "content")
    private String content;

    @Column(name = "required_skill")
    private String requiredSkill;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Builder
    public JobPosting(
            Long companyId,
            Long recruitmentCompensation,
            String title,
            String position,
            String content,
            String requiredSkill
    ) {
        this.companyId = companyId;
        this.recruitmentCompensation = recruitmentCompensation;
        this.title = title;
        this.position = position;
        this.content = content;
        this.requiredSkill = requiredSkill;
    }
}
