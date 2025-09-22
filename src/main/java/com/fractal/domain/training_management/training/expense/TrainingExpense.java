package com.fractal.domain.training_management.training.expense;

import com.fractal.domain.finance.expense.Expense;
import com.fractal.domain.training_management.training.Training;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "training_expense", schema = "training_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class TrainingExpense extends Expense {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "training_id", referencedColumnName = "id")
    private Training training;

    @Column(name = "invoice_number")
    private String invoiceNumber;
}

