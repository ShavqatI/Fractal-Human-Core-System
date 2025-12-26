package com.fractal.domain.organization_management.grade.evaluation;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.organization_management.grade.Grade;
import com.fractal.domain.organization_management.grade.method.GradingEvaluation;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "grade_evaluation", schema = "organization_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GradeEvaluation extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    private Grade grade;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "grading_evaluation_id", referencedColumnName = "id")
    private GradingEvaluation evaluation;
}
