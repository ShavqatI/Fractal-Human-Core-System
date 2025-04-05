package com.fractal.domain.employee_management.identification_document.type;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "identification_document_type",schema = "employee_schema", catalog = "fractal")
public class IdentificationDocumentType extends Dictionary {

}
