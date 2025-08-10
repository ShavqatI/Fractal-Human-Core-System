package com.fractal.domain.organization_management.job_description.accountability;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.organization_management.job_description.JobDescription;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accountability", schema = "organization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Accountability extends AbstractEntity {

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "performance_measure", columnDefinition = "TEXT", nullable = false)
    private String performanceMeasure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_description_id",referencedColumnName = "id")
    private JobDescription jobDescription;
}