package com.fractal.domain.finance.expense;

import com.fractal.domain.abstraction.ApprovalWorkflow;
import com.fractal.domain.dictionary.currency.Currency;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.finance.expense.resource.ExpenseResource;
import com.fractal.domain.finance.expense.type.ExpenseType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "expense", schema = "finance_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Expense extends ApprovalWorkflow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expense_type_id", referencedColumnName = "id")
    protected ExpenseType expenseType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    protected Currency currency;

    protected BigDecimal amount;

    protected String description;

    protected LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    protected Status status;

    @OneToMany(mappedBy = "expense",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    protected List<ExpenseResource> resources = new ArrayList<>();

    public void addResource(ExpenseResource resource) {
        if (resources == null) resources = new ArrayList<>();
        resource.setExpense(this);
        resources.add(resource);
    }
    public void removeResource(ExpenseResource resource) {
        if (resources != null && !resources.isEmpty())
            resources.remove(resource);
    }

}
