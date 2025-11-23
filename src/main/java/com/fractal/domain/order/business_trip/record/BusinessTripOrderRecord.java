package com.fractal.domain.order.business_trip.record;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.order.business_trip.BusinessTripOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "business_trip_order_record", schema = "order_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTripOrderRecord extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_trip_order_id", referencedColumnName = "id")
    private BusinessTripOrder businessTripOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_trip_id", referencedColumnName = "id")
    private BusinessTrip businessTrip;
}
