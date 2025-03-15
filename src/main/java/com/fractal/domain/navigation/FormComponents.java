package com.fractal.domain.navigation;

import com.fractal.domain.dictionary.Status;
import com.fractal.domain.localization.LayoutLabel;
import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.ui.Component;
import jakarta.persistence.*;

@Entity
@Table(name = "form_components", schema = "navigation_schema", catalog = "fractal")
public class FormComponents extends AbstractEntity {




    @ManyToOne
    @JoinColumn(name = "layout_label_id", referencedColumnName = "id")
    private LayoutLabel layoutLabel;

    @Column(name = "source")
    private String source;

    @Column(name = "section")
    private String section;

    @Column(name = "sequence")
    private Integer sequence;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private Component component;

    @Column(name = "value")
    private String value;


    public LayoutLabel getLayoutLabel() {
        return layoutLabel;
    }

    public void setLayoutLabel(LayoutLabel layoutLabel) {
        this.layoutLabel = layoutLabel;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
