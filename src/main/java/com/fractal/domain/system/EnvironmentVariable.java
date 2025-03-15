package com.fractal.domain.system;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "environment_variable", schema = "system_schema", catalog = "fractal")
public class EnvironmentVariable extends AbstractEntity {
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "value")
    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
