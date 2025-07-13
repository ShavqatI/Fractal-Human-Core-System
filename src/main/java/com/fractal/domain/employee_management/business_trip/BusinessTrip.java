package com.fractal.domain.employee_management.business_trip;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employee_management.business_trip.order.BusinessTripOrder;
import com.fractal.domain.employee_management.business_trip.resource.BusinessTripResource;
import com.fractal.domain.employee_management.business_trip.type.BusinessTripType;
import com.fractal.domain.employee_management.employee.Employee;
import com.fractal.domain.organization_management.organization.Organization;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "business_trip", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BusinessTrip extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "organization_id", referencedColumnName = "id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "business_tripType_id", referencedColumnName = "id")
    private BusinessTripType businessTripType;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "purpose",length = 5000)
    private String purpose;

    @Column(name = "description",length = 1000)
    private String description;

    @Column(name = "location",length = 1000)
    private String location;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "days")
    private Integer days;

    @OneToMany(mappedBy = "businessTrip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BusinessTripOrder> orders = new ArrayList<>();

    @OneToMany(mappedBy = "businessTrip",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<BusinessTripResource> resources = new ArrayList<>();

    public void addOrder(BusinessTripOrder order) {
        if (orders == null) orders = new ArrayList<>();
        order.setBusinessTrip(this);
        orders.add(order);
    }
    public void removeOrder(BusinessTripOrder order) {
        if (orders != null && !orders.isEmpty())
            orders.remove(order);
    }

    public void addResource(BusinessTripResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setBusinessTrip(this);
        resources.add(resource);
    }
    public void removeResource(BusinessTripResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }
}
