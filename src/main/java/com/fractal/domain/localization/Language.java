package com.fractal.domain.localization;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "language", schema = "localization_schema", catalog = "fractal")
public class Language extends AbstractEntity {


    @Column(name = "name")
    private String name;
    @Column(name = "code")
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
