package com.fractal.domain.employee_management.business_trip.location.address;


import com.fractal.domain.employee_management.business_trip.location.BusinessTripLocation;
import com.fractal.domain.location.address.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "business_trip_location_address", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class BusinessTripLocationAddress extends Address {

    @ManyToOne
    @JoinColumn(name = "business_trip_location_id", referencedColumnName = "id")
    private BusinessTripLocation businessTripLocation;


}
