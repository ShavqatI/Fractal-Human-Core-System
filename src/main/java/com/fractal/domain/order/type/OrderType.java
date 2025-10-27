package com.fractal.domain.order.type;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManager;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "order_type", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderType extends Dictionary {
    private String description;
    private String series;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_template_manager_id")
    protected DocumentTemplateManager documentTemplateManager;
}
