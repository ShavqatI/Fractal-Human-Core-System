package com.fractal.domain.employee_management.identification.identification_document_type;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "identification_type", schema = "dictionary_schema", catalog = "fractal")
public class IdentificationDocumentType extends Dictionary {

}
