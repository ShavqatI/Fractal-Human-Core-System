package com.fractal.domain.employment.internal.compensation;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.agreement.Agreement;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.employment.docuemnt_template_manager.PaymentFrequency;
import com.fractal.domain.employment.internal.InternalEmployment;
import com.fractal.domain.employment.salary_classification.SalaryClassification;
import com.fractal.domain.finance.currency.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "compensation_component", schema = "employment_schema", catalog = "fractal")
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CompensationComponent extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "internal_employment_id",referencedColumnName = "id")
    private InternalEmployment internalEmployment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_classification_id",referencedColumnName = "id")
    private SalaryClassification salaryClassification;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_frequency_id",referencedColumnName = "id")
    private PaymentFrequency paymentFrequency;

    @Column(name = "start_date")
    protected LocalDate startDate;

    @Column(name = "end_date")
    protected LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "currency_id",referencedColumnName = "id")
    private Currency currency;

    private BigDecimal grossAmount;
    private BigDecimal netAmount;
    private BigDecimal taxAmount;
    private BigDecimal deductionAmount;
    private Boolean taxable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id",referencedColumnName = "id")
    private Status status;


}
