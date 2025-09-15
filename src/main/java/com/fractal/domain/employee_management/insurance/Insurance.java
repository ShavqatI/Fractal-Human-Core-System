package com.fractal.domain.employee_management.insurance;

import com.fractal.domain.abstraction.AbstractEntity;
import com.fractal.domain.dictionary.status.Status;
import com.fractal.domain.insurance.provider.InsuranceProvider;
import com.fractal.domain.insurance.type.InsuranceType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "insurance", schema = "employee_schema", catalog = "fractal")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Insurance extends AbstractEntity {
    private InsuranceType insuranceType;
    private InsuranceProvider insuranceProvider;
    private String policyNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    //private CoverageDetail coverage;     // Coverage specifics
    private Status status;
}
