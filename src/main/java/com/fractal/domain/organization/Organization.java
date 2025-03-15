package com.fractal.domain.organization;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "organization", schema = "organization_schema", catalog = "fractal")
public class Organization extends AbstractEntity {

    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "full_name")
    private String fullName;
    @Basic
    @Column(name = "code")
    private String code;
    @Basic
    @Column(name = "tin_number")
    private String tinNumber;
    @Basic
    @Column(name = "open_date")
    private Date openDate;
    @Basic
    @Column(name = "close_date")
    private Date closeDate;
    @Basic
    @Column(name = "level")
    private Integer level;
    @Basic
    @Column(name = "level_map")
    private String levelMap;
    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Organization parent;
    @ManyToOne
    @JoinColumn(name = "organization_unit_id", referencedColumnName = "id")
    private OrganizationUnit organizationUnit;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }


    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }


    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
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

    public Organization getParent() {
        return parent;
    }

    public void setParent(Organization organizationByParentId) {
        this.parent = organizationByParentId;
    }

    public OrganizationUnit getOrganizationUnit() {
        return organizationUnit;
    }

    public void setOrganizationUnit(OrganizationUnit organizationUnit) {
        this.organizationUnit = organizationUnit;
    }
}
