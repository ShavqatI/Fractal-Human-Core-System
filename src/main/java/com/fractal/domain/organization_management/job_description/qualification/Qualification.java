package com.fractal.domain.organization_management.job_description.qualification;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.organization_management.job_description.JobDescription;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "qualification", schema = "organization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Qualification extends AbstractEntity {

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_description_id", referencedColumnName = "id")
    private JobDescription jobDescription;
}
