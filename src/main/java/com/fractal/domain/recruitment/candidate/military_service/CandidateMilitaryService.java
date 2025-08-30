package com.fractal.domain.recruitment.candidate.military_service;


import com.fractal.domain.military_service.MilitaryService;
import com.fractal.domain.recruitment.candidate.Candidate;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "candidate_military_service", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class CandidateMilitaryService extends MilitaryService {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

}
