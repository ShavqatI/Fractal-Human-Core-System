package com.fractal.domain.integration.mapping.position;

import com.fractal.domain.abstraction.Integration;
import com.fractal.domain.organization_management.department.Department;
import com.fractal.domain.organization_management.position.Position;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "position_mapping", schema = "integration_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class PositionMapping extends Integration {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id",updatable = false,referencedColumnName = "id")
    protected Position position;

}
