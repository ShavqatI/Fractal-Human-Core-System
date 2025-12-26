package com.fractal.domain.localization.layout_label.detail;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.localization.language.Language;
import com.fractal.domain.localization.layout_label.LayoutLabel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "layout_label_detail", schema = "localization_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LayoutLabelDetail extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "layout_label_id", referencedColumnName = "id")
    private LayoutLabel layoutLabel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    @Column(name = "description")
    private String description;


}
