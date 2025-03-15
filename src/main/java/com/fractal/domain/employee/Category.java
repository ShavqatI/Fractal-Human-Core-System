package com.fractal.domain.employee;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "category", schema = "employee_schema", catalog = "fractal")
public class Category extends AbstractEntity {

    private String code;
    private String name;

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
