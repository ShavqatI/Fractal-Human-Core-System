package com.fractal.domain.organization;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "department", schema = "organization_schema", catalog = "fractal")
public class Department extends AbstractEntity {

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "level")
    private Integer level;
    @Basic
    @Column(name = "level_map")
    private String levelMap;
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Department parent;
    @ManyToOne
    @JoinColumn(name = "organization_unit_id", referencedColumnName = "id")
    private OrganizationUnit organizationUnit;


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


    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    public String getLevelMap() {
        return levelMap;
    }

    public void setLevelMap(String levelMap) {
        this.levelMap = levelMap;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department departmentByParentId) {
        this.parent = departmentByParentId;
    }

    public OrganizationUnit getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(OrganizationUnit organizationUnit) {
        this.organizationUnit = organizationUnit;
    }
}
