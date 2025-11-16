package com.fractal.domain.organization_management.job_description.kpi;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.organization_management.job_description.JobDescription;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "key_performance_indicator", schema = "organization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class KeyPerformanceIndicator extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "measure_unit")
    private String measureUnit;

    @Column(name = "target_value")
    private double targetValue;

    @Column(name = "frequency")
    private String frequency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_description_id", referencedColumnName = "id")
    private JobDescription jobDescription;
}
