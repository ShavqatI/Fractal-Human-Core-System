package com.fractal.domain.organization_management.position;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.organization_management.department.Department;
import com.fractal.domain.organization_management.grade.Grade;
import com.fractal.domain.organization_management.job_description.JobDescription;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "position", schema = "organization_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Position extends AbstractEntity {

    @Column(name = "code",unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "grade_id", referencedColumnName = "id")
    private Grade grade;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL)
    private List<JobDescription> jobDescriptions = new ArrayList<>();

}
