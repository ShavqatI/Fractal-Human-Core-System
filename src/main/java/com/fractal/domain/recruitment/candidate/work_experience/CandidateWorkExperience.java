package com.fractal.domain.recruitment.candidate.work_experience;


import com.fractal.domain.education.Education;
import com.fractal.domain.employment.work_experience.WorkExperience;
import com.fractal.domain.recruitment.candidate.Candidate;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "candidate_work_experience", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class CandidateWorkExperience extends WorkExperience {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="candidate_id", referencedColumnName = "id")
    private Candidate candidate;
}
