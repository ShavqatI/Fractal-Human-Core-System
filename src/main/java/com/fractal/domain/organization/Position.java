package com.fractal.domain.organization;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "position", schema = "organization_schema", catalog = "fractal")
public class Position extends AbstractEntity {
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department departmentByDepartmentId) {
        this.department = departmentByDepartmentId;
    }


}
