package com.fractal.domain.employee_management.performance;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.performance.goal.Goal;
import com.fractal.domain.employee_management.performance.improvement.Improvement;
import com.fractal.domain.employee_management.performance.type.PerformanceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "performance", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Performance extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_type_id", referencedColumnName = "id")
    private PerformanceType performanceType;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "review_period_start", nullable = false)
    private LocalDate reviewPeriodStart;

    @Column(name = "review_period_end", nullable = false)
    private LocalDate reviewPeriodEnd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reviewer_employee_id", referencedColumnName = "id")
    private Employee reviewerEmployee;

    @Column(name = "comments", length = 2000)
    private String comments;

    @OneToMany(mappedBy = "performance", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Goal> goals;

    @OneToMany(mappedBy = "performance", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Improvement> improvements;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;


    public void addGoal(Goal goal) {
        if (goals == null) goals = new ArrayList<>();
        goal.setPerformance(this);
        goals.add(goal);
    }

    public void removeGoal(Goal goal) {
        if (goals != null && !goals.isEmpty())
            goals.remove(goal);
    }

    public void addImprovement(Improvement improvement) {
        if (improvements == null) improvements = new ArrayList<>();
        improvement.setPerformance(this);
        improvements.add(improvement);
    }

    public void removeImprovement(Improvement improvement) {
        if (improvements != null && !improvements.isEmpty())
            improvements.remove(improvement);
    }



}
