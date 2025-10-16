package com.fractal.domain.organization_management.grade.benchmarking;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.organization_management.grade.Grade;
import com.fractal.domain.organization_management.grade.benchmarking.type.BenchmarkingType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "benchmarking", schema = "organization_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Benchmarking extends AbstractEntity {

    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @Column(name = "average_salary")
    private BigDecimal averageSalary;

    @Column(name = "max_salary")
    private BigDecimal  maxSalary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "benchmarking_type_id", referencedColumnName = "id")
    private BenchmarkingType benchmarkingType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    private Grade grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;
}
