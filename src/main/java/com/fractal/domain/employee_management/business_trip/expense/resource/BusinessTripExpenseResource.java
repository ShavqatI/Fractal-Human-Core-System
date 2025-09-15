package com.fractal.domain.employee_management.business_trip.expense.resource;


import com.fractal.domain.employee_management.business_trip.expense.BusinessTripExpense;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "business_trip_expense_resource",schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class BusinessTripExpenseResource extends Resource {

    @ManyToOne
    @JoinColumn(name = "business_trip_expense_id", referencedColumnName = "id")
    private BusinessTripExpense businessTripExpense;

}
