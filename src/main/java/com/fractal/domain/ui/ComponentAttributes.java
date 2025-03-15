package com.fractal.domain.ui;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "component_attributes", schema = "ui_schema", catalog = "fractal")
public class ComponentAttributes extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "component_id", referencedColumnName = "id")
    private Component component;

    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "id")
    private Attribute attribute;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
