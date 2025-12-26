package com.fractal.domain.learning_develpment.learning.session.expense;

import com.fractal.domain.finance.expense.Expense;
import com.fractal.domain.learning_develpment.learning.session.LearningSession;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "learning_session_expense", schema = "ld_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LearningSessionExpense extends Expense {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "learning_session_id", referencedColumnName = "id")
    private LearningSession learningSession;

    @Column(name = "invoice_number")
    private String invoiceNumber;
}

