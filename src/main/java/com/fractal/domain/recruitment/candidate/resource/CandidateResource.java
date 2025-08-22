package com.fractal.domain.recruitment.candidate.resource;


import com.fractal.domain.recruitment.candidate.Candidate;
import com.fractal.domain.recruitment.candidate.resource.type.CandidateResourceType;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "candidate_resource",schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class CandidateResource extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_resource_type_id", referencedColumnName = "id")
    private CandidateResourceType candidateResourceType;

}
