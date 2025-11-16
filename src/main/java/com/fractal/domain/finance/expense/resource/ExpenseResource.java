package com.fractal.domain.finance.expense.resource;


import com.fractal.domain.finance.expense.Expense;
import com.fractal.domain.resource.Resource;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "expense_resource", schema = "finance_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class ExpenseResource extends Resource {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_id", referencedColumnName = "id")
    private Expense expense;

}
