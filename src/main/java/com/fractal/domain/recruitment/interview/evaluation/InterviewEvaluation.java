package com.fractal.domain.recruitment.interview.evaluation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.recruitment.interview.Interview;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@Entity
@Table(name = "interview_evaluation", schema = "recruitment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InterviewEvaluation extends AbstractEntity {

    private LocalDateTime date;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "interview_id",referencedColumnName = "id")
    private Interview interview;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;*/
}
