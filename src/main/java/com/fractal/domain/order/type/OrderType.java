package com.fractal.domain.order.type;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.dictionary.docuemnt_template_manager.DocumentTemplateManager;
import com.fractal.domain.order.category.OrderCategory;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "order_type", schema = "order_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderType extends Dictionary {
    private String description;
    private String series;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_category_id")
    protected OrderCategory orderCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_template_manager_id")
    protected DocumentTemplateManager documentTemplateManager;
}
