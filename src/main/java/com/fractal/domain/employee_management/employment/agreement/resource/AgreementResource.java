package com.fractal.domain.employee_management.employment.agreement.resource;


import com.fractal.domain.employee_management.employment.agreement.Agreement;
import com.fractal.domain.employee_management.identification_document.IdentificationDocument;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "agreement_resource",schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class AgreementResource extends Resource {

    @ManyToOne
    @JoinColumn(name = "agreement_id", referencedColumnName = "id")
    private Agreement agreement;

}
