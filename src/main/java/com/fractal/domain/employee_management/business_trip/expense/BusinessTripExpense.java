package com.fractal.domain.employee_management.business_trip.expense;

import com.fractal.domain.employee_management.business_trip.BusinessTrip;
import com.fractal.domain.finance.expense.Expense;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "business_trip_expense", schema = "employee_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BusinessTripExpense extends Expense {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "business_trip_id", referencedColumnName = "id")
    private BusinessTrip businessTrip;
}
