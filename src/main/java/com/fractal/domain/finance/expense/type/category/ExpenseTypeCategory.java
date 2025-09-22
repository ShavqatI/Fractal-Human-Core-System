package com.fractal.domain.finance.expense.type.category;


import com.fractal.domain.abstraction.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "expense_type_category", schema = "finance_schema", catalog = "fractal")
@Data
@SuperBuilder
@NoArgsConstructor
public class ExpenseTypeCategory extends Dictionary {
}
