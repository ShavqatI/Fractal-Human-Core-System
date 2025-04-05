package com.fractal.domain.localization.layout_label_detail;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.localization.language.Language;
import com.fractal.domain.localization.layout_label.LayoutLabel;
import jakarta.persistence.*;

@Entity
@Table(name = "layout_label_detail", schema = "localization_schema", catalog = "fractal")
public class LayoutLabelDetail extends AbstractEntity {

    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "layout_label_id", referencedColumnName = "id")
    private LayoutLabel layoutLabel;

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }





    public LayoutLabel getLayoutLabel() {
        return layoutLabel;
    }

    public void setLayoutLabel(LayoutLabel layoutLabelId) {
        this.layoutLabel = layoutLabelId;
    }



    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language languageByLanguageId) {
        this.language = languageByLanguageId;
    }


}
