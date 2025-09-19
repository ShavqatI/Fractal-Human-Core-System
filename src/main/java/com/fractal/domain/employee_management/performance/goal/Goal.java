package com.fractal.domain.employee_management.performance.goal;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employee_management.performance.Performance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "performance_goal", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Goal extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id", referencedColumnName = "id")
    private Performance performance;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "achieved")
    private Boolean achieved;

    @Column(name = "achieved_date")
    private LocalDate achievedDate;

    @Column(name = "remarks")
    private String remarks;

}