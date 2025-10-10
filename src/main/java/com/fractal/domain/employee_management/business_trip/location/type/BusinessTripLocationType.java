package com.fractal.domain.employee_management.business_trip.location.type;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "business_trip_location_type", schema = "employee_schema", catalog = "fractal")
@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
public class BusinessTripLocationType extends Dictionary {

}
