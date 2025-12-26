package com.fractal.domain.employment.internal.compensation_component.state;

import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.state.EntityState;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "compensation_component_state", schema = "state_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CompensationComponentState extends EntityState {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compensation_component_id", referencedColumnName = "id")
    private CompensationComponent compensationComponent;
}
