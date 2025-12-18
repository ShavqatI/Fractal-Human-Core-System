package com.fractal.domain.agreement.resource;


import com.fractal.domain.agreement.Agreement;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "agreement_resource", schema = "employee_schema", catalog = "fractal")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AgreementResource extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agreement_id", referencedColumnName = "id")
    private Agreement agreement;

}
