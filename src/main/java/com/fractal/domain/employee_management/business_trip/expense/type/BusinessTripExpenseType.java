package com.fractal.domain.employee_management.business_trip.expense.type;


import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "business_trip_expense_type", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BusinessTripExpenseType extends Dictionary {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private BusinessTripExpenseType parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<BusinessTripExpenseType> children = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private Status status;

    @Transactional
    public void addChild(BusinessTripExpenseType businessTripExpenseType) {
        if (children == null) children = new ArrayList<>();
        businessTripExpenseType.setParent(this);
        children.add(businessTripExpenseType);
    }

    @Transactional
    public void removeChild(BusinessTripExpenseType businessTripExpenseType) {
        if (children != null && !children.isEmpty())
            children.remove(businessTripExpenseType);
    }

}
