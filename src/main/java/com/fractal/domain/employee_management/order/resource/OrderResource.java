package com.fractal.domain.employee_management.order.resource;


import com.fractal.domain.employee_management.order.Order;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_resource",schema = "employee_schema", catalog = "fractal")
@Data
@NoArgsConstructor
public class OrderResource extends Resource {

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

}
