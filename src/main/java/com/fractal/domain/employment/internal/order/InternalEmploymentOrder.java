package com.fractal.domain.employment.internal.order;

import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.order.Order;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "internal_employment_order", schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class InternalEmploymentOrder extends Order {

    /*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "business_trip_order_number_generator")
    @SequenceGenerator(
            name = "business_trip_order_number_generator",
            sequenceName = "business_trip_order_number_seq",
            initialValue = 1000,
            allocationSize = 1
    )*/
    @Column(name = "number")
    @Setter(AccessLevel.NONE)
    private Long number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "internal_employment_id", referencedColumnName = "id")
    private InternalEmployment internalEmployment;

}
