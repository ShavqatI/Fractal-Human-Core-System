package com.fractal.domain.location;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.EntityType;
import com.fractal.domain.dictionary.AddressType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "address", schema = "location_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name ="country_id", referencedColumnName = "id")
    private Country country;

    @ManyToOne
    @JoinColumn(name ="region_id", referencedColumnName = "id")
    private Region region;

    @ManyToOne
    @JoinColumn(name ="city_id", referencedColumnName = "id")
    private City city;

    @ManyToOne
    @JoinColumn(name ="district_id", referencedColumnName = "id")
    private District district;

    @Column(name = "street")
    private String street;

    @Column(name = "house")
    private String house;

    @Column(name = "apartment")
    private String apartment;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "building_number")
    private String buildingNumber;

    @Column(name = "floor_number")
    private String floorNumber;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

}
