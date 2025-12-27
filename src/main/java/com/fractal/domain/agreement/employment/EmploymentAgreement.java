package com.fractal.domain.agreement.employment;

import com.fractal.domain.agreement.Agreement;
import com.fractal.domain.employment.Employment;
import com.fractal.domain.employment.internal.compensation_component.CompensationComponent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "employment_agreement", schema = "agreement_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmploymentAgreement extends Agreement {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employment_id", referencedColumnName = "id")
    private Employment employment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "compensation_component_id", referencedColumnName = "id")
    private CompensationComponent compensationComponent;

}
