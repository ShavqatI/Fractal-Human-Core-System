package com.fractal.domain.order.vacation;

import com.fractal.domain.order.Order;
import com.fractal.domain.vacation_management.vacation.Vacation;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "vacation_order", schema = "order_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class VacationOrder extends Order {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacation_id", referencedColumnName = "id")
    private Vacation vacation;

}
