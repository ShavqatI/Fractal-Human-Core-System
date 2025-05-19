package com.fractal.domain.employee_management.identification_document.resource;


import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.employee_management.identification_document.IdentificationDocument;
import com.fractal.domain.employee_management.identification_document.type.IdentificationDocumentType;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "identification_document_resource",schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdentificationDocumentResource extends Resource {

    @ManyToOne
    @JoinColumn(name = "identification_document_id", referencedColumnName = "id")
    private IdentificationDocument identificationDocument;

}
