package com.fractal.domain.ui;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "component", schema = "ui_schema", catalog = "fractal")
public class Component extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true)
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
