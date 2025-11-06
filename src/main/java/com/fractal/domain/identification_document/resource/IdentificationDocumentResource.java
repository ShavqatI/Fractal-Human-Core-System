package com.fractal.domain.identification_document.resource;


import com.fractal.domain.identification_document.IdentificationDocument;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "identification_document_resource",schema = "identification_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IdentificationDocumentResource extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "identification_document_id", referencedColumnName = "id")
    private IdentificationDocument identificationDocument;

}
