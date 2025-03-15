package com.fractal.domain.location;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.EntityType;
import com.fractal.domain.dictionary.AddressType;
import jakarta.persistence.*;

@Entity
@Table(name = "address", schema = "location_schema", catalog = "fractal")
public class Address extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name ="entity_type_id", referencedColumnName = "id")
    private EntityType entityType;

    @Column(name = "entity_id")
    private Integer entity;

    @ManyToOne
    @JoinColumn(name ="address_type_id", referencedColumnName = "id")
    private AddressType addressType;

    @ManyToOne
    @JoinColumn(name ="location_unit_id", referencedColumnName = "id")
    private LocationUnit locationUnit;

    @ManyToOne
    @JoinColumn(name ="country_id", referencedColumnName = "id")
    private Country country;

    @ManyToOne
    @JoinColumn(name ="region_id", referencedColumnName = "id")
    private Region region;

    @Column(name = "house")
    private String house;

    @Column(name = "apartment")
    private String apartment;

    @Column(name = "description")
    private String description;

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    public Integer getEntity() {
        return entity;
    }

    public void setEntity(Integer entity) {
        this.entity = entity;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public LocationUnit getLocationUnit() {
        return locationUnit;
    }

    public void setLocationUnit(LocationUnit locationUnit) {
        this.locationUnit = locationUnit;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
