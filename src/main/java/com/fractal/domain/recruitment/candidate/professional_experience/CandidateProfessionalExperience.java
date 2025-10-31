package com.fractal.domain.recruitment.candidate.professional_experience;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.industry.Industry;
import com.fractal.domain.recruitment.candidate.Candidate;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "candidate_professional_experience",schema = "recruitment_schema", catalog = "fractal")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
public class CandidateProfessionalExperience extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "industry_id", referencedColumnName = "id")
    private Industry industry;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

    private Integer years;



}
