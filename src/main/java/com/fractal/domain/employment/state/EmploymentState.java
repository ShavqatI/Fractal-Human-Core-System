package com.fractal.domain.employment.state;

import com.fractal.domain.employment.Employment;
import com.fractal.domain.state.EntityState;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "employment_state", schema = "state_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmploymentState extends EntityState {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employment_id", referencedColumnName = "id")
    private Employment employment;
}
