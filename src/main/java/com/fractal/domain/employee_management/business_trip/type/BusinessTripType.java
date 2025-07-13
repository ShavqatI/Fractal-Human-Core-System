package com.fractal.domain.employee_management.business_trip.type;

import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "business_trip_type", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BusinessTripType extends Dictionary {
    private String description;
}
