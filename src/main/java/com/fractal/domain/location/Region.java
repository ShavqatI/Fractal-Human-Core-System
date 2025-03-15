package com.fractal.domain.location;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "region", schema = "location_schema", catalog = "fractal")
public class Region extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "code", unique = true, length = 5)
    private String code;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "location_unit_id", referencedColumnName = "id")
    private LocationUnit locationUnit;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Region parent;

    public LocationUnit getLocationUnit() {
        return locationUnit;
    }

    public void setLocationUnit(LocationUnit locationUnit) {
        this.locationUnit = locationUnit;
    }

    public Region getParent() {
        return parent;
    }

    public void setParent(Region parent) {
        this.parent = parent;
    }

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
