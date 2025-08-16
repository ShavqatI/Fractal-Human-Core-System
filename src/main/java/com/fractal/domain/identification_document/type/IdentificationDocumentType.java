package com.fractal.domain.identification_document.type;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "identification_document_type",schema = "identification_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class IdentificationDocumentType extends Dictionary {

}
