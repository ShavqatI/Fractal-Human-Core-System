package com.fractal.domain.organization_management.grade;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.dictionary.currency.Currency;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.organization_management.grade.step.GradeStep;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

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
    @ManyToOne
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;

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

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Grade> children = new ArrayList<>();

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<GradeStep> steps = new ArrayList<>();

    @Transactional
    public void addChild(Grade grade) {
        if (children == null) children = new ArrayList<>();
        grade.setParent(this);
        children.add(grade);
    }

    @Transactional
    public void removeChild(Grade grade) {
        if (children != null && !children.isEmpty())
            children.remove(grade);
    }

    @Transactional
    public void addStep(GradeStep step) {
        if (steps == null) steps = new ArrayList<>();
        step.setGrade(this);
        steps.add(step);
    }

    @Transactional
    public void removeChild(GradeStep step) {
        if (steps != null && !steps.isEmpty())
            steps.remove(step);
    }

}
