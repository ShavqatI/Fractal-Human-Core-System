package com.fractal.domain.order;


import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.authorization.user.User;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.order.resource.OrderResource;
import com.fractal.domain.order.state.OrderState;
import com.fractal.domain.order.type.OrderType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order", schema = "order_schema", catalog = "fractal")
@Inheritance(strategy = InheritanceType.JOINED)
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
public class Order extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @Column(name = "number")
    protected String number;

    @Column(name = "date")
    protected LocalDate date;

    @Column(name = "justification")
    protected String justification;

    @Column(name = "source_document")
    protected String sourceDocument;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_type_id")
    protected OrderType orderType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "canceled_date")
    private LocalDateTime canceledDate;

    @ManyToOne
    @JoinColumn(name = "canceled_user_id")
    private User canceledUser;

    @Column(name = "canceled_reason")
    private String canceledReason;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<OrderResource> resources = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<OrderState> states = new ArrayList<>();

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
