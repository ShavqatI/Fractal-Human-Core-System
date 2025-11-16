package com.fractal.domain.recruitment.candidate.address;


import com.fractal.domain.location.address.Address;
import com.fractal.domain.recruitment.candidate.Candidate;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "candidate_address", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class CandidateAddress extends Address {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;
}
