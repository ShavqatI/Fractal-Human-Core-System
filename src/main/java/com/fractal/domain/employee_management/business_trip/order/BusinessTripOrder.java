package com.fractal.domain.employee_management.business_trip.order;

import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.order.Order;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "business_trip_order", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTripOrder extends Order {

    @Column(name = "number")
    @Setter(AccessLevel.NONE)
    private Long number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_trip_id", referencedColumnName = "id")
    private BusinessTrip businessTrip;

}
