package com.fractal.domain.employee_management.order;


import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.employee_management.order.resource.OrderResource;
import com.fractal.domain.employee_management.order.type.OrderType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order", schema = "employee_schema", catalog = "fractal")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "order_type_id")
    protected OrderType orderType;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderResource> resources = new ArrayList<>();

    public void addResource(OrderResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setOrder(this);
        resources.add(resource);
    }
    public void removeResource(OrderResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }
}
