package com.fractal.domain.location.address;

import com.fractal.domain.location.address.type.AddressType;
import com.fractal.domain.location.city.City;
import com.fractal.domain.location.country.Country;
import com.fractal.domain.location.district.District;
import com.fractal.domain.location.region.Region;
import com.fractal.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "address", schema = "location_schema", catalog = "fractal")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

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

    @Column(name = "created_date",updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    protected LocalDateTime createdDate;

    @Column(name = "updated_date")
    protected LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "created_user_id")
    protected User createdUser;

    @ManyToOne
    @JoinColumn(name = "updated_user_id")
    protected User updatedUser;

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }


}
