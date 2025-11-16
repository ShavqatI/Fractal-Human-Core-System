package com.fractal.domain.integration.mapping.department;

import com.fractal.domain.abstraction.Integration;
import com.fractal.domain.organization_management.department.Department;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "department_mapping", schema = "integration_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class DepartmentMapping extends Integration {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", updatable = false, referencedColumnName = "id")
    protected Department department;

}
