package com.fractal.domain.employment.internal.agreement.resource;


import com.fractal.domain.employment.internal.agreement.InternalEmploymentAgreement;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "internal_employment_agreement_resource",schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class InternalEmploymentAgreementResource extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "internal_employment_agreement_id", referencedColumnName = "id")
    private InternalEmploymentAgreement internalEmploymentAgreement;

}
