package com.fractal.domain.order.resource;


import com.fractal.domain.order.Order;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_resource", schema = "employee_schema", catalog = "fractal")
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderResource extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

}
