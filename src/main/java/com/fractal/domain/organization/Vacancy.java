package com.fractal.domain.organization;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "vacancy", schema = "organization_schema", catalog = "fractal")
public class Vacancy extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @Basic
    @Column(name = "description")
    private String description;

    @Column(name = "open_date")
    private Date openDate;
    @Column(name = "close_date")
    private Date closeDate;

    @Column(name = "salary")
    private Double salary;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
