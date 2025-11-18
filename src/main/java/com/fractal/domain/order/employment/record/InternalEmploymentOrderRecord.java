package com.fractal.domain.order.employment.record;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.order.employment.InternalEmploymentOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "internal_employment_order_record", schema = "order_schema", catalog = "fractal")
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class InternalEmploymentOrderRecord extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_trip_order_id", referencedColumnName = "id")
    private InternalEmploymentOrder internalEmploymentOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employment_id", referencedColumnName = "id")
    private InternalEmployment employment;
}
