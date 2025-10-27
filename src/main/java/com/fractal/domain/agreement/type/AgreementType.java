package com.fractal.domain.agreement.type;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManager;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "agreement_type", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AgreementType extends Dictionary {
    private String description;
    private String series;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_template_manager_id")
    protected DocumentTemplateManager documentTemplateManager;
}
