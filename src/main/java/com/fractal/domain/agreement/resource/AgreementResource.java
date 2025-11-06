package com.fractal.domain.agreement.resource;


import com.fractal.domain.agreement.Agreement;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "agreement_resource",schema = "employee_schema", catalog = "fractal")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AgreementResource extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agreement_id", referencedColumnName = "id")
    private Agreement agreement;

}
