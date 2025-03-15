package com.fractal.domain.location;

import com.fractal.domain.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@Table(name = "country", schema = "location_schema", catalog = "fractal")
public class Country extends AbstractEntity {
    @Column(name = "name")
    private String name;

    @Column(name ="code",unique = true,length = 5)
    private String code;

    @Column(name ="iso_code",unique = true)
    private String isoCode;

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

    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }
}
