package com.fractal.domain.localization.layout_label;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "layout_label", schema = "localization_schema", catalog = "fractal")
public class LayoutLabel extends AbstractEntity {

    @Column(name = "name")
    private String name;


     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   }
