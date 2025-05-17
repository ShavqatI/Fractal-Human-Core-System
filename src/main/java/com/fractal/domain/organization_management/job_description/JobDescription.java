package com.fractal.domain.organization_management.job_description;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
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

    @ManyToOne
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    private Position position;

    @OneToMany(mappedBy = "jobDescription",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Responsibility> responsibilities = new ArrayList<>();

    @OneToMany(mappedBy = "jobDescription",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Qualification> qualifications = new ArrayList<>();

    @OneToMany(mappedBy = "jobDescription",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequiredExperience> requiredExperiences = new ArrayList<>();


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

}

