package com.fractal.domain.organization_management.grade;

import com.fractal.domain.abstraction.Dictionary;
import com.fractal.domain.dictionary.currency.Currency;
import com.fractal.domain.dictionary.status.Status;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Table(name = "grade", schema = "organization_schema", catalog = "fractal")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Grade extends Dictionary {
    @ManyToOne
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;

    @Column(name = "min_salary")
    private BigDecimal minSalary;

    @Column(name = "max_salary")
    private BigDecimal  maxSalary;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Status status;

    @Column(name = "notes", columnDefinition = "TEXT")
    private String notes;

}
