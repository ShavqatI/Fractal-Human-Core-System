package com.fractal.domain.organization_management.job_description;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.organization_management.job_description.accountability.Accountability;
import com.fractal.domain.organization_management.job_description.authority.Authority;
import com.fractal.domain.organization_management.job_description.kpi.KeyPerformanceIndicator;
import com.fractal.domain.organization_management.job_description.qualification.Qualification;
import com.fractal.domain.organization_management.job_description.required_experience.RequiredExperience;
import com.fractal.domain.organization_management.job_description.responsibility.Responsibility;
import com.fractal.domain.organization_management.position.Position;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "job_description", schema = "organization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class JobDescription extends AbstractEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "summary", columnDefinition = "TEXT")
    private String summary;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;

    @OneToMany(mappedBy = "jobDescription",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Responsibility> responsibilities = new ArrayList<>();

    @OneToMany(mappedBy = "jobDescription",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Qualification> qualifications = new ArrayList<>();

    @OneToMany(mappedBy = "jobDescription",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<RequiredExperience> requiredExperiences = new ArrayList<>();

    @OneToMany(mappedBy = "jobDescription",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<KeyPerformanceIndicator> keyPerformanceIndicators = new ArrayList<>();

    @OneToMany(mappedBy = "jobDescription",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Authority> authorities = new ArrayList<>();

    @OneToMany(mappedBy = "jobDescription",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Accountability> accountabilities = new ArrayList<>();

    public void addResponsibility(Responsibility responsibility) {
        if (responsibilities == null) responsibilities = new ArrayList<>();
        responsibility.setJobDescription(this);
        responsibilities.add(responsibility);
    }
    public void removeResponsibility(Responsibility responsibility) {
        if (responsibilities != null && !responsibilities.isEmpty())
            responsibilities.remove(responsibility);
    }

    public void addQualification(Qualification qualification) {
        if (qualifications == null) qualifications = new ArrayList<>();
        qualification.setJobDescription(this);
        qualifications.add(qualification);
    }
    public void removeQualification(Qualification qualification) {
        if (qualifications != null && !qualifications.isEmpty())
        qualifications.remove(qualification);
    }

    public void addRequiredExperience(RequiredExperience requiredExperience) {
        if (requiredExperiences == null) requiredExperiences = new ArrayList<>();
        requiredExperience.setJobDescription(this);
        requiredExperiences.add(requiredExperience);
    }
    public void removeRequiredExperience(RequiredExperience requiredExperience) {
        if (requiredExperiences != null && !requiredExperiences.isEmpty())
            requiredExperiences.remove(requiredExperience);
    }

    public void addKeyPerformanceIndicator(KeyPerformanceIndicator keyPerformanceIndicator) {
        if (keyPerformanceIndicators == null) keyPerformanceIndicators = new ArrayList<>();
        keyPerformanceIndicator.setJobDescription(this);
        keyPerformanceIndicators.add(keyPerformanceIndicator);
    }
    public void removeKeyPerformanceIndicator(KeyPerformanceIndicator keyPerformanceIndicator) {
        if (keyPerformanceIndicators != null && !keyPerformanceIndicators.isEmpty())
            keyPerformanceIndicators.remove(keyPerformanceIndicator);
    }

    public void addAuthority(Authority authority) {
        if (authorities == null) authorities = new ArrayList<>();
        authority.setJobDescription(this);
        authorities.add(authority);
    }
    public void removeAuthority(Authority authority) {
        if (accountabilities != null && !accountabilities.isEmpty())
            accountabilities.remove(authority);
    }

    public void addAccountability(Accountability accountability) {
        if (accountabilities == null) accountabilities = new ArrayList<>();
        accountability.setJobDescription(this);
        accountabilities.add(accountability);
    }
    public void removeAccountability(Accountability accountability) {
        if (accountabilities != null && !accountabilities.isEmpty())
            accountabilities.remove(accountability);
    }



}

