package com.fractal.domain.navigation;

import com.fractal.domain.dictionary.Status;
import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.ui.ComponentAttributes;
import jakarta.persistence.*;

@Entity
@Table(name = "form_component_attributes", schema = "navigation_schema", catalog = "fractal")
public class FormComponentAttributes extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "form_component_id", referencedColumnName = "id")
    private FormComponents formComponents;

    @ManyToOne
    @JoinColumn(name = "component_attribute_id", referencedColumnName = "id")
    private ComponentAttributes componentAttribute;

    @Column(name = "value")
    private String value;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public FormComponents getFormComponents() {
        return formComponents;
    }

    public void setFormComponents(FormComponents formComponents) {
        this.formComponents = formComponents;
    }

    public ComponentAttributes getComponentAttribute() {
        return componentAttribute;
    }

    public void setComponentAttribute(ComponentAttributes componentAttribute) {
        this.componentAttribute = componentAttribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


}
