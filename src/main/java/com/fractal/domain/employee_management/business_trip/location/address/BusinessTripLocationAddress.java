package com.fractal.domain.employee_management.business_trip.location.address;


import com.fractal.domain.employee_management.business_trip.location.BusinessTripLocation;
import com.fractal.domain.location.address.Address;
import jakarta.persistence.*;
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
    @JoinColumn(name ="business_trip_location_id", referencedColumnName = "id")
    private BusinessTripLocation businessTripLocation;


}
