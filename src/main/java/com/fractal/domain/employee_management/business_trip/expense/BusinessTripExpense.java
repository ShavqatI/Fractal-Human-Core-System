package com.fractal.domain.employee_management.business_trip.expense;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.currency.Currency;
import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.employee_management.business_trip.expense.resource.BusinessTripExpenseResource;
import com.fractal.domain.employee_management.business_trip.expense.type.BusinessTripExpenseType;
import com.fractal.domain.employee_management.order.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "business_trip_expense", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTripExpense extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_trip_id", referencedColumnName = "id")
    private BusinessTrip businessTrip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_trip_expense_type_id", referencedColumnName = "id")
    private BusinessTripExpenseType businessTripExpenseType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;

    private BigDecimal amount;

    private String description;

    private LocalDate date;

    @OneToMany(mappedBy = "businessTripExpense",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<BusinessTripExpenseResource> resources = new ArrayList<>();


    @Transactional
    public void addResource(BusinessTripExpenseResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setBusinessTripExpense(this);
        resources.add(resource);
    }

    @Transactional
    public void removeResource(BusinessTripExpenseResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }

}
