package com.fractal.domain.employee_management.insurance.coverage;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.employee_management.insurance.Insurance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "insurance_coverage", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsuranceCoverage extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id", referencedColumnName = "id")
    private Insurance insurance;

    private String description;
    private BigDecimal amount;


}
