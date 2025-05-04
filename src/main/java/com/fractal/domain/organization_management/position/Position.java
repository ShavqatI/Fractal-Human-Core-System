package com.fractal.domain.organization_management.position;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.organization_management.department.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "position", schema = "organization_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

}
