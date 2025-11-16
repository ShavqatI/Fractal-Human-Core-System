package com.fractal.domain.organization_management.grade.band;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.organization_management.grade.Grade;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "grade_salary_band", schema = "organization_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class GradeSalaryBand extends AbstractEntity {

    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @Column(name = "average_salary")
    private BigDecimal averageSalary;

    @Column(name = "max_salary")
    private BigDecimal maxSalary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    private Grade grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
}
