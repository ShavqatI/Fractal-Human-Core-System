package com.fractal.domain.employee_management.identification_document.resource;


import com.fractal.domain.employee_management.identification_document.IdentificationDocument;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "identification_document_resource",schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class IdentificationDocumentResource extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identification_document_id", referencedColumnName = "id")
    private IdentificationDocument identificationDocument;

}
