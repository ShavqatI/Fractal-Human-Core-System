package com.fractal.domain.organization_management.grade;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.finance.currency.Currency;
import com.fractal.domain.organization_management.grade.benchmarking.Benchmarking;
import com.fractal.domain.organization_management.grade.level.GradeLevel;
import com.fractal.domain.organization_management.grade.step.GradeStep;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "grade", schema = "organization_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Grade extends Dictionary {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grade_level_id", referencedColumnName = "id")
    private GradeLevel level;

    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @Column(name = "max_salary")
    private BigDecimal  maxSalary;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Grade parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Grade> children = new ArrayList<>();

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<GradeStep> steps = new ArrayList<>();

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Benchmarking> benchmarkings = new ArrayList<>();
    public void addChild(Grade grade) {
        if (children == null) children = new ArrayList<>();
        grade.setParent(this);
        children.add(grade);
    }
    public void removeChild(Grade grade) {
        if (children != null && !children.isEmpty())
            children.remove(grade);
    }
    public void addStep(GradeStep step) {
        if (steps == null) steps = new ArrayList<>();
        step.setGrade(this);
        steps.add(step);
    }
    public void removeStep(GradeStep step) {
        if (steps != null && !steps.isEmpty())
            steps.remove(step);
    }

    public void addBenchmarking(Benchmarking benchmarking) {
        if (benchmarkings == null) benchmarkings = new ArrayList<>();
        benchmarking.setGrade(this);
        benchmarkings.add(benchmarking);
    }
    public void removeBenchmarking(Benchmarking benchmarking) {
        if (benchmarkings != null && !benchmarkings.isEmpty())
            benchmarkings.remove(benchmarking);
    }

}
