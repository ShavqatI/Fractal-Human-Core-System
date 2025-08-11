package com.fractal.domain.recruitment.candidate.citizenship;

import com.fractal.domain.citizenship.Citizenship;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.recruitment.candidate.Candidate;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "candidate_citizenship", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Inheritance()
public class CandidateCitizenship extends Citizenship {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;


}
