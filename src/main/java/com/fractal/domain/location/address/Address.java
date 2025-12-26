package com.fractal.domain.location.address;

import com.fractal.domain.abstraction.Auditable;
import com.fractal.domain.location.address.type.AddressType;
import com.fractal.domain.location.city.City;
import com.fractal.domain.location.country.Country;
import com.fractal.domain.location.district.District;
import com.fractal.domain.location.region.Region;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "address", schema = "location_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(callSuper = true)
public class Address extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "address_type_id", referencedColumnName = "id")
    protected AddressType addressType;

    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    protected Country country;

    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    protected Region region;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    protected City city;

    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    protected District district;

    @Column(name = "street")
    protected String street;

    @Column(name = "house")
    protected String house;

    @Column(name = "apartment")
    protected String apartment;

    @Column(name = "postal_code")
    protected String postalCode;

    @Column(name = "building_number")
    protected String buildingNumber;

    @Column(name = "floor_number")
    protected String floorNumber;

    @Column(name = "latitude")
    protected Double latitude;

    @Column(name = "longitude")
    protected Double longitude;

    @Column(name = "start_date")
    protected LocalDate startDate;

    @Column(name = "end_date")
    protected LocalDate endDate;

}
