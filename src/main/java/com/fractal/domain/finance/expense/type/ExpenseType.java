package com.fractal.domain.finance.expense.type;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.finance.expense.type.category.ExpenseTypeCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "expense_type", schema = "finance_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseType extends Dictionary {

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_type_category_id", referencedColumnName = "id")
    private ExpenseTypeCategory expenseTypeCategory;
}
