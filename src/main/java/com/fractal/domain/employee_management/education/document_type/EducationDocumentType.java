package com.fractal.domain.employee_management.education.document_type;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "education_document_type", schema = "dictionary_schema", catalog = "fractal")
public class EducationDocumentType extends Dictionary {

}
