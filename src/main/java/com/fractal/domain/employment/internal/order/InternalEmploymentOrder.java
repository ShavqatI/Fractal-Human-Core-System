package com.fractal.domain.employment.internal.order;

import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "internal_employment_order", schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class InternalEmploymentOrder extends Order {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "internal_employment_id", referencedColumnName = "id")
    private InternalEmployment internalEmployment;

}
