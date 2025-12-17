package com.fractal.domain.employment.internal.compensation_component.state;

import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import com.fractal.domain.state.EntityState;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "compensation_component_state", schema = "state_schema", catalog = "fractal")
@Setter
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CompensationComponentState extends EntityState {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compensation_component_id", referencedColumnName = "id")
    private CompensationComponent compensationComponent;
}
