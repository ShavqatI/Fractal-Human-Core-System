package com.fractal.domain.integration.mapping.vacation_type;

import com.fractal.domain.abstraction.Integration;
import com.fractal.domain.order.type.OrderType;
import com.fractal.domain.vacation_management.type.VacationType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "vacation_type_mapping", schema = "integration_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class VacationTypeMapping extends Integration {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_type_id", updatable = false, referencedColumnName = "id")
    protected VacationType vacationType;

}
