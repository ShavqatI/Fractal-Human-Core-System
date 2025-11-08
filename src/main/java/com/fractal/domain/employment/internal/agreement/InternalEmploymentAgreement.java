package com.fractal.domain.employment.internal.agreement;

import com.fractal.domain.agreement.Agreement;
import com.fractal.domain.employment.internal.InternalEmployment;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "internal_employment_agreement", schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class InternalEmploymentAgreement extends Agreement {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "internal_employment_id",referencedColumnName = "id")
    private InternalEmployment internalEmployment;

}
